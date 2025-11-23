package org.lasalle.recipeapp.data.services

import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

//Instancia en Ktorfit
object KtorfitFactory{
    val base = "https://recipes.pjasoft.com/api/"

    //Clientes Http Axios, Fetch
    //No tenemos certeza de que la API siempre va a responder igual
    //Que pasa si la API no responde con el status code 200
    //API tarda en responder -> 105

    private val httpClient = HttpClient{
            expectSuccess = false
        //false porque no siempre va a responder con 200
            install(HttpTimeout){
                requestTimeoutMillis = 40000
                requestTimeoutMillis = 40000
                requestTimeoutMillis = 40000
            }

            install(ContentNegotiation){
                json(
                    Json{
                        isLenient = true //PERMITE JSONS IMPERFECTOS O INCOMPLETOS
                        ignoreUnknownKeys = true //Ignora propiedades no mapeadas
                    }
                )
            }
            defaultRequest {
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }
    }

    private val ktorfit = Ktorfit
        .Builder()
        .httpClient (httpClient)
        .baseUrl(base)
        .build()

    fun getAuthService(): AuthService{
        return ktorfit.createAuthService()
    }

    fun getRecipeService(): RecipeService{
        return ktorfit.createRecipeService()
    }
}
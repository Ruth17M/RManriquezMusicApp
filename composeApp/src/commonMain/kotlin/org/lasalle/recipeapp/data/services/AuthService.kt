package org.lasalle.recipeapp.data.services

import de.jensklingenberg.ktorfit.http.POST
import de.jensklingenberg.ktorfit.http.Body
import org.lasalle.recipeapp.models.AuthResponse
import org.lasalle.recipeapp.models.LoginBody
import org.lasalle.recipeapp.models.RegisterBody

//q tengo que mandar a la API y que responda?

interface AuthService {

    @POST("auth/register")
    suspend fun register(@Body request : RegisterBody) : AuthResponse

    @POST("auth/login")
    suspend fun login(@Body request : LoginBody) : AuthResponse
}
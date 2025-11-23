package org.lasalle.recipeapp.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.lasalle.recipeapp.data.services.KtorfitFactory
import org.lasalle.recipeapp.models.LoginBody
import org.lasalle.recipeapp.models.RegisterBody

class AuthViewModel(): ViewModel(){
    //Crear instancia de KTORFIT
    //CREAR EL SERVICIO DE AUTH
    //MANDAR A LLAMAR A LA API CON LOS DATOS QUE ME PIDEN

    var message by mutableStateOf("")
    val authService = KtorfitFactory.getAuthService()

    fun register(name:String, email:String, password:String){
        viewModelScope.launch {
            try{
                val register = RegisterBody(
                    name = name,
                    email = email,
                    password = password
                )
                val result = authService.register(register)
                if(result.isLogged){
                    //Q el usuario se resgistro y debo navegar a otra pantalla

                }
                else{
                    //no se pudo registar el usuario
                    message = result.message
                }
                println(result.toString())
            }
            catch (e: Exception){

                println(e.toString())
            }

        }
    }

    fun login(email:String, password:String){
        viewModelScope.launch {
           try{
               val request = LoginBody(
                   email = email,
                   password = password
               )
               val response = authService.login(request)
               if(response.isLogged){
                   //TODO: NAVEGAR A HOME Y GUARDAR EL USERID EN MEMORIA
               }else {
                   message = response.message
               }
           }
           catch (e:Exception){
               println(e.toString())
           }
        }
    }
}
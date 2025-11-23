package org.lasalle.recipeapp.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class HomeViewModel: ViewModel(){
    private val recipeService = ktorfitFactory.getRecipeService()
    var ingredients by mutableStateOf("")

    var showSheet by mutableStateOf(false)
    fun generateRecipe(){
        viewModelScope.launch {
            try{

            }catch (e: Exception){
                println(e.toString())
            }
        }
    }
}


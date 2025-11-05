package org.lasalle.recipeapp.data.services

import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Query
import org.lasalle.recipeapp.models.Recipe

interface RecipeService {

    @GET("recipes?userId=1")
    suspend fun getRecipesByUserId(@Query("userId")userId:Int) : List<Recipe>
}
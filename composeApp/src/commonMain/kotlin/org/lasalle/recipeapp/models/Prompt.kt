package org.lasalle.recipeapp.models

import kotlinx.serialization.Serializable

@Serializable
data class Prompt(
    val ingredientes: String
)

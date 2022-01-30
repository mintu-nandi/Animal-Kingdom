package com.animal.presentation.model

import android.util.Log

data class Animal(
    val active_time: String,
    val animal_type: String,
    val diet: String,
    val geo_range: String,
    val habitat: String,
    val id: Int,
    val image_link: String,
    val latin_name: String,
    val length_max: String,
    val length_min: String,
    val lifespan: String,
    val name: String,
    val weight_max: String,
    val weight_min: String
) {
    fun lifespan() = run {
        var result = ""
        try {
            result = when (lifespan.toInt()) {
                in 0..10 -> "Lifespan: $lifespan yrs (Not very long)"
                in 10..20 -> "Lifespan: $lifespan yrs (Kind of average)"
                else -> "Lifespan: $lifespan yrs (A long time)"
            }
        } catch (e: Exception) {
            Log.d("Animal", e.message.toString())
        }
        result
    }

    fun diet() = "Diet: $diet"
}

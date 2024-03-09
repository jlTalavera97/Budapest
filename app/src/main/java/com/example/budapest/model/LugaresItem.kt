package com.example.budapest.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


sealed class LugaresItem(
    @StringRes
    open val name: Int,
    open val ubication: String,
    @DrawableRes
    open val image: Int,
    open val description: String,
    open val coordinates: Pair<String, String>
){
    data class Restaurante(
        @StringRes
        override val name: Int,
        override val ubication: String,
        override val image: Int,
        override val description: String,
        override open val coordinates: Pair<String, String>
    ): LugaresItem(name, ubication, image, description, coordinates)

    data class Actividades(
        @StringRes
        override val name: Int,
        override val ubication: String,
        override val image: Int,
        override val description: String,
        override open val coordinates: Pair<String, String>

    ):LugaresItem(name, ubication, image, description, coordinates)

    data class Monumentos(
        @StringRes
        override val name: Int,
        override val ubication: String,
        override val image: Int,
        override val description: String,
        override open val coordinates: Pair<String, String>
    ):LugaresItem(name, ubication, image, description, coordinates)
}

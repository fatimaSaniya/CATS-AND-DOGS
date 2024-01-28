package com.example.catsdogs.data

import androidx.annotation.DrawableRes

enum class AnimalType {
    Cat,
    Dog,
    Cat_and_Dog
}

data class Animal(
    @DrawableRes val image: Int,
    val title: String,
    val age: Int,
    val type: AnimalType
)

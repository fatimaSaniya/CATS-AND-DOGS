package com.example.catsdogs.data

import com.example.catsdogs.R

class FakeRepository {
    fun loadData() : List<Animal>{
        return listOf(
            Animal(R.drawable.cat1, "Fluffy", 5, AnimalType.Cat),
            Animal(R.drawable.cat2, "Lucy", 3, AnimalType.Cat),
            Animal(R.drawable.cat3, "Cutie", 6, AnimalType.Cat),
            Animal(R.drawable.cat4, "Sara", 4, AnimalType.Cat),
            Animal(R.drawable.cat5, "Tia", 1, AnimalType.Cat),
            Animal(R.drawable.cat6, "Bella", 7, AnimalType.Cat),
            Animal(R.drawable.cat7, "Lily", 4, AnimalType.Cat),
            Animal(R.drawable.dog1, "Mikey", 8, AnimalType.Dog),
            Animal(R.drawable.dog2, "Elmo", 7, AnimalType.Dog),
            Animal(R.drawable.dog3, "Max", 6, AnimalType.Dog),
            Animal(R.drawable.dog4, "Scooby", 9, AnimalType.Dog),
            Animal(R.drawable.dog5, "Tuffy", 4, AnimalType.Dog),
            Animal(R.drawable.dog6, "Becky", 5, AnimalType.Dog),
            Animal(R.drawable.dog7, "Oreo", 9, AnimalType.Dog),

        )
    }
}
package com.learningwithmanos.uniexercise.heroes

import com.learningwithmanos.uniexercise.heroes.data.Hero

data object DummyData {
    val dummyHeroList = listOf(
        Hero(
            id = 1,
            name = "A-Bomb (HAS)",
            availableComics = 4,
            imageUrl = "http://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16.jpg",
        ),
        Hero(
            id = 2,
            name = "Absorbing Man",
            availableComics = 99,
            imageUrl = "http://i.annihil.us/u/prod/marvel/i/mg/1/b0/5269678709fb7.jpg",
        ),
        Hero(
            id = 3,
            name = "3-D Man",
            availableComics = 12,
            imageUrl = "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784.jpg",
        ),
        Hero(
            id = 4,
            name = "Aaron Stack",
            availableComics = 14,
            imageUrl = "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg",
        ),
        Hero(
            id = 5,
            name = "A.I.M.",
            availableComics = 53,
            imageUrl = "http://i.annihil.us/u/prod/marvel/i/mg/6/20/52602f21f29ec.jpg",
        ),
        Hero(
            id = 6,
            name = "Abomination (Ultimate)",
            availableComics = 2,
            imageUrl = "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg",
        ),
        Hero(
            id = 7,
            name = "Adam Destine",
            availableComics = 0,
            imageUrl = "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg",
        ),
        Hero(
            id = 8,
            name = "Abomination (Emil Blonsky)",
            availableComics = 58,
            imageUrl = "http://i.annihil.us/u/prod/marvel/i/mg/9/50/4ce18691cbf04.jpg",
        ),
        Hero(
            id = 9,
            name = "Abyss (Age of Apocalypse)",
            availableComics = 3,
            imageUrl = "http://i.annihil.us/u/prod/marvel/i/mg/3/80/4c00358ec7548.jpg",
        ),
        Hero(
            id = 10,
            name = "Abyss",
            availableComics = 8,
            imageUrl = "http://i.annihil.us/u/prod/marvel/i/mg/9/30/535feab462a64.jpg",
        ),
    )
}
package com.example.cinema.model

class Movie(
    val id: Long,
    val title: String,
    val year: Int,
    val rating: Double,
    val image: String,
    val genre: String
)

class MovieDetails(

    val movie: Movie,
    val descriptions: String
)
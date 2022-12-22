package com.example.cinema.model

import com.example.cinema.MovieNotFoundException

typealias MoviesListener = (movies: List<Movie>) -> Unit

class MovieService {

    private var movies = mutableListOf<Movie>()

    private val listeners = mutableSetOf<MoviesListener>()

    init {
        movies = (1..100).map { Movie(
            id = it.toLong(),
            title = "title cinema $it",
            year = (1967..2023).random(),
            rating = (0..10).random().toDouble(),
            image = "...",
            genre = "Жанр"

        )}.toMutableList()
    }

    fun getMovies(): List<Movie> {
        return movies
    }

    fun getById(id: Long): MovieDetails {
        val movie = movies.firstOrNull { it.id == id } ?: throw MovieNotFoundException()
        return MovieDetails(
            movie = movie,
            descriptions = "Описание сюжета"
        )

    }

    fun addListener(listener: MoviesListener) {
        listeners.add(listener)
        listener.invoke(movies)
    }

    fun removelistener(listener: MoviesListener) {
        listeners.remove(listener)
    }

    private fun notifyChanges() {
        listeners.forEach { it.invoke(movies) }
    }


}
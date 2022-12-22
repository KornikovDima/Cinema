package com.example.cinema.screens

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cinema.MovieNotFoundException
import com.example.cinema.model.Movie
import com.example.cinema.model.MovieDetails
import com.example.cinema.model.MovieService

class MovieDetailsViewModel(
    private val movieService: MovieService
) :ViewModel() {

    private val _movieDetails = MutableLiveData<MovieDetails>()
    val movieDetails = _movieDetails

    fun loadMovie(movieId: Long) {
        if (_movieDetails.value != null) return
        try {
            _movieDetails.value = movieService.getById(movieId)
        } catch (e: MovieNotFoundException) {
            e.printStackTrace()
        }

    }
}
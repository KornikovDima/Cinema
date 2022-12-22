package com.example.cinema.screens

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cinema.model.Movie
import com.example.cinema.model.MovieService
import com.example.cinema.model.MoviesListener

class MovieListViewModel(
    private val movieService: MovieService
) :ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()
    val movies = _movies


    private val listener: MoviesListener = {
        _movies.value = it
    }

    init {
        loadMovies()
    }

    override fun onCleared() {
        super.onCleared()
        movieService.removelistener(listener)
    }

    fun loadMovies() {
        movieService.addListener(listener)
    }
}
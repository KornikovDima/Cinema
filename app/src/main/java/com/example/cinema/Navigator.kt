package com.example.cinema

import com.example.cinema.model.Movie

interface Navigator {

    fun showDetails(movie: Movie)

    fun goBack()

    fun toast(messageRes: Int)
}
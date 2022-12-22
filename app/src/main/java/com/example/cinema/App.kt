package com.example.cinema

import android.app.Application
import com.example.cinema.model.MovieService

class App : Application() {
    val movieService = MovieService()
}
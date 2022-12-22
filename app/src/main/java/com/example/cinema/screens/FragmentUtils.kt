package com.example.cinema.screens

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cinema.App
import com.example.cinema.Navigator

class ViewModelFactory(
    private val app: App
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModel = when (modelClass) {
            MovieListViewModel::class.java -> {
                MovieListViewModel(app.movieService)
            }
            MovieDetailsViewModel::class.java -> {
                MovieDetailsViewModel(app.movieService)
            }
            else -> {
                throw IllegalStateException("Error")
            }
        }
        return viewModel as T
    }
}

fun Fragment.factory() = ViewModelFactory(requireContext().applicationContext as App)

fun Fragment.navigator() = requireActivity() as Navigator

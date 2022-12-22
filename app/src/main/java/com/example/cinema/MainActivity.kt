package com.example.cinema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cinema.databinding.ActivityMainBinding
import com.example.cinema.model.*
import com.example.cinema.screens.MovieDetailsFragment
import com.example.cinema.screens.MovieListFragment

class MainActivity : AppCompatActivity(), Navigator {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, MovieListFragment())
                .commit()
        }
    }

    override fun showDetails(movie: Movie) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragmentContainer, MovieDetailsFragment.newInstance(movie.id))
            .commit()
    }

    override fun goBack() {
        onBackPressed()
    }

    override fun toast(messageRes: Int) {
        Toast.makeText(this, messageRes, Toast.LENGTH_LONG).show()
    }
}
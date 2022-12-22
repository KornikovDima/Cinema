package com.example.cinema.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cinema.databinding.FragmentMovieListBinding
import com.example.cinema.model.Movie
import com.example.cinema.model.MovieActionListener
import com.example.cinema.model.MoviesAdapter
import com.example.cinema.model.MoviesListener

class MovieListFragment : Fragment() {

    private lateinit var binding: FragmentMovieListBinding
    private lateinit var adapter: MoviesAdapter

    private val viewModel: MovieListViewModel by viewModels { factory() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieListBinding.inflate(inflater, container, false)
        adapter = MoviesAdapter(object : MovieActionListener {
            override fun onMovieDetails(movie: Movie) {
                navigator().showDetails(movie)
            }
        })

        viewModel.movies.observe(viewLifecycleOwner, Observer {
            adapter.movies = it
        })

        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val layoutManager1 = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        binding.recyclerCinema.layoutManager = layoutManager
        binding.recyclerSerials.layoutManager = layoutManager1
        binding.recyclerCinema.adapter = adapter
        binding.recyclerSerials.adapter = adapter

        return binding.root
    }
}
package com.example.cinema.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.cinema.R
import com.example.cinema.databinding.FragmentDetailsListBinding

class MovieDetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsListBinding
    private val viewModel: MovieDetailsViewModel by viewModels { factory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadMovie(requireArguments().getLong(ARG_MOVIE_ID))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsListBinding.inflate(inflater, container, false)

        viewModel.movieDetails.observe(viewLifecycleOwner, Observer {
            binding.titleCinema.text = it.movie.title
            binding.year.text = it.movie.year.toString()
            binding.genre.text = it.movie.genre
            binding.descriptionCinema.text = it.descriptions
            binding.imageScreen.setImageResource(R.drawable.ic_baseline_image_search_24)
        })
        return binding.root
    }

    companion object {

        private const val ARG_MOVIE_ID = "ARG_MOVIE_ID"

        fun newInstance(movieId: Long): MovieDetailsFragment {
            val fragment = MovieDetailsFragment()
            fragment.arguments = bundleOf(ARG_MOVIE_ID to movieId)
            return fragment
        }
    }
}
package com.example.cinema.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cinema.R
import com.example.cinema.databinding.ItemMovieBinding

interface MovieActionListener {

    fun onMovieDetails(movie: Movie)
}


class MoviesAdapter(
    private val actionListener: MovieActionListener
) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>(), View.OnClickListener {

    var movies: List<Movie> = emptyList()
        set (newValue) {
            field = newValue
            notifyDataSetChanged()
    }

    override fun onClick(v: View) {
        val movie = v.tag as Movie
        actionListener.onMovieDetails(movie)
    }

    override fun getItemCount(): Int = movies.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(inflater, parent, false)

        binding.root.setOnClickListener(this)

        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = movies[position]
        with(holder.binding) {
            holder.itemView.tag = movie

            titleMovie.text = movie.title
            year.text = movie.year.toString()
            rating.text = movie.rating.toString()
            imageMovie.setImageResource(R.drawable.ic_baseline_image_search_24)
        }
    }



    class MoviesViewHolder(
        val binding: ItemMovieBinding
    ) : RecyclerView.ViewHolder(binding.root)
}
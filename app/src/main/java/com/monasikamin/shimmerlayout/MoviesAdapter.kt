package com.monasikamin.shimmerlayout

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.monasikamin.shimmerlayout.MoviesAdapter.MoviesViewHolder
import kotlinx.android.synthetic.main.item_movie.view.*
import kotlinx.android.synthetic.main.item_movie.view.txt_movies_overview
import kotlinx.android.synthetic.main.item_movie.view.txt_movies_title
import java.text.DecimalFormat

class MoviesAdapter (
    private val context: Context,
    private val movieList: ArrayList<Movie>
) : RecyclerView.Adapter<MoviesViewHolder>() {
    inner class MoviesViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind(movie: Movie){
            Glide.with(context)
                .load(ApiClient.POSTER_BASE_URL+movie.backdrop_path)
                .into(itemView.img_movies_poster)
            itemView.txt_movies_title.text = movie.title
            itemView.txt_movies_overview.text = movie.overview
            itemView.txt_movies_rating.text = DecimalFormat("0.0").format(movie.vote_average)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        return MoviesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(movieList.get(position))
    }

}
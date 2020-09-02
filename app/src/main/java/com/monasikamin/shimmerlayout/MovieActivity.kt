package com.monasikamin.shimmerlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_movie.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieActivity : AppCompatActivity() {
    private val api = ApiClient.getApi()
    private var adapter: MoviesAdapter? = null
    private var movieArrayList: ArrayList<Movie>? = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        adapter = MoviesAdapter(this, movieArrayList!!)

        rv_movies.layoutManager = LinearLayoutManager(this)
        rv_movies.setHasFixedSize(true)
        rv_movies.adapter = adapter

        api!!.getMovies(1)!!.enqueue(object: Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val movieList = response.body()
                movieArrayList?.addAll(movieList?.results!!)
                adapter!!.notifyDataSetChanged()
                shimmer_layout_json!!.stopShimmerAnimation()
                shimmer_layout_json!!.visibility = View.GONE
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Toast.makeText(this@MovieActivity, "Error : " + t.localizedMessage, Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    override fun onResume() {
        super.onResume()
        shimmer_layout_json!!.startShimmerAnimation()
    }

    override fun onPause() {
        shimmer_layout_json!!.stopShimmerAnimation()
        super.onPause()
    }
}
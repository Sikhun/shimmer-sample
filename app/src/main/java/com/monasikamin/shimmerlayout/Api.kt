package com.monasikamin.shimmerlayout

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("discover/movie?language=en-US&api_key="+BuildConfig.TMDB_API_KEY)
    fun getMovies (@Query("page") page: Int?) : Call<MovieResponse>
}
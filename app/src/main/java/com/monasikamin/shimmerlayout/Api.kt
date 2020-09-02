package com.monasikamin.shimmerlayout

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("discover/movie?language=en-US&api_key=854f1436ecee23a37aee7e3b3eae9d49")
    fun getMovies (@Query("page") page: Int?) : Call<MovieResponse>
}
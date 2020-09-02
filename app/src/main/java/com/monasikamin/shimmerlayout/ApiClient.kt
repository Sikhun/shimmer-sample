package com.monasikamin.shimmerlayout

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    public val BASE_URL : String = "https://api.themoviedb.org/3/"
    public val POSTER_BASE_URL: String = "https://image.tmdb.org/t/p/original"
    private var retrofit : Retrofit? = null
    private var api: Api? = null

    public fun getApi() : Api? {
        if (retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        if (api == null){
            api = retrofit!!.create(Api::class.java)
        }
        return api
    }

}
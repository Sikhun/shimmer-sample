package com.monasikamin.shimmerlayout

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Movie (
    var id : Int? = 0,
    var vote_count: Int? = 0,
    var vote_average: Double?  = 0.0,
    var title: String? = "",
    var overview: String? = "",
    var popularity: Double? = 0.0,
    var poster_path: String? = "",
    var original_language: String? = "",
    var backdrop_path: String? = "",
    var release_date: String? = ""
) {
}
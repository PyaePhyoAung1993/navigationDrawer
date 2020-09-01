package com.tmw.navigationdrawerexample.ui.toprated

import com.tmw.navigationdrawerexample.modeltoprated.TopRated
import com.tmw.navigationdrawerexample.ui.api.ApiInterfaceAll
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TopRatedApiClient {
    private val BASE_URL = "https://api.themoviedb.org/3/movie/"

    companion object{
        val API_KEY = "66de59240ced531546489a65f06b9c79"
    }

    private val apiInterface: ApiInterfaceAll

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInterface = retrofit.create(
            ApiInterfaceAll::class.java
        )
    }

    fun getTopRated(
        api_key: String,
        language: String,
        page: String
    ): Call<TopRated> {
        return apiInterface.getTopRated(
            api_key, language, page
        )
    }

}
package com.tmw.navigationdrawerexample.ui.nowplaying

import com.tmw.navigationdrawerexample.modelnowplaying.NowPlaying
import com.tmw.navigationdrawerexample.ui.api.ApiInterfaceAll
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NowPlayingApiClient {

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

    fun getNowPlaying(
        api_key: String,
        language: String,
        page: String
    ): Call<NowPlaying> {
        return apiInterface.getNowPlaying(
            api_key, language, page
        )
    }

}
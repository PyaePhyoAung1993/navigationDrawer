package com.tmw.navigationdrawerexample.ui.api

import com.tmw.navigationdrawerexample.modelnowplaying.NowPlaying
import com.tmw.navigationdrawerexample.modelpopular.Popular
import com.tmw.navigationdrawerexample.modeltoprated.TopRated
import com.tmw.navigationdrawerexample.modelupcoming.UpComing
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterfaceAll {

    @GET("now_playing")
    fun getNowPlaying(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: String
    ): Call<NowPlaying>

    @GET("popular")
    fun getPopular(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: String
    ):Call<Popular>

    @GET("top_rated")
    fun getTopRated(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: String
    ):Call<TopRated>

    @GET("upcoming")
    fun getUpComing(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: String
    ) : Call<UpComing>
}
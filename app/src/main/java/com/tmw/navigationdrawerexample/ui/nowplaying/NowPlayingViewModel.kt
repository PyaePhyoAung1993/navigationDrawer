package com.tmw.navigationdrawerexample.ui.nowplaying

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tmw.navigationdrawerexample.modelnowplaying.NowPlaying
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NowPlayingViewModel : ViewModel() {

    private var resultnowplaying: MutableLiveData<NowPlaying> = MutableLiveData()

    fun getResultNowPlaying(): LiveData<NowPlaying> = resultnowplaying

    fun loadResult1(){
        var apiClient=NowPlayingApiClient()
        val call=apiClient.getNowPlaying(NowPlayingApiClient.API_KEY,"en-US","1")

        call.enqueue(object: Callback<NowPlaying>{
            override fun onFailure(call: Call<NowPlaying>, t: Throwable) {
                Log.d("Error......",t.toString())
            }

            override fun onResponse(call: Call<NowPlaying>, response: Response<NowPlaying>) {
                resultnowplaying.value=response.body()
            }

        })
    }
}
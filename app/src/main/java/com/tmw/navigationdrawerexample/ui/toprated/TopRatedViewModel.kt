package com.tmw.navigationdrawerexample.ui.toprated

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tmw.navigationdrawerexample.modelnowplaying.NowPlaying
import com.tmw.navigationdrawerexample.modeltoprated.Result
import com.tmw.navigationdrawerexample.modeltoprated.TopRated
import com.tmw.navigationdrawerexample.ui.nowplaying.NowPlayingApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopRatedViewModel : ViewModel() {

    private var resulttopRated: MutableLiveData<TopRated> = MutableLiveData()

    fun getResultTopRated(): LiveData<TopRated> = resulttopRated

    fun loadResult3(){
        var apiClient= TopRatedApiClient()
        val call=apiClient.getTopRated(TopRatedApiClient.API_KEY,"en-US","1")

        call.enqueue(object: Callback<TopRated> {
            override fun onFailure(call: Call<TopRated>, t: Throwable) {
                Log.d("Error......",t.toString())
            }

            override fun onResponse(call: Call<TopRated>, response: Response<TopRated>) {
                resulttopRated.value=response.body()
            }

        })
    }
}
package com.tmw.navigationdrawerexample.ui.popular

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tmw.navigationdrawerexample.modelnowplaying.NowPlaying
import com.tmw.navigationdrawerexample.modelpopular.Popular
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopularViewModel : ViewModel() {
    private var resultPopular: MutableLiveData<Popular> = MutableLiveData()

    fun getResultPopular(): LiveData<Popular> = resultPopular

    fun loadResult2(){
        var apiClient= PopularApiClient()
        val call=apiClient.getPopular(PopularApiClient.API_KEY,"en-US","1")

        call.enqueue(object: Callback<Popular> {
            override fun onFailure(call: Call<Popular>, t: Throwable) {
                Log.d("Error......",t.toString())
            }

            override fun onResponse(call: Call<Popular>, response: Response<Popular>) {
                resultPopular.value=response.body()
            }

        })
    }
}
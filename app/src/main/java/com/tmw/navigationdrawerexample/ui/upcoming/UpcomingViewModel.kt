package com.tmw.navigationdrawerexample.ui.upcoming

import androidx.lifecycle.ViewModel
import com.tmw.navigationdrawerexample.ui.popular.PopularApiClient
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tmw.navigationdrawerexample.modelupcoming.UpComing
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpcomingViewModel : ViewModel() {
    private var resultPopular: MutableLiveData<UpComing> = MutableLiveData()

    fun getResultPopular(): LiveData<UpComing> = resultPopular

    fun loadResult2(){
        var apiClient= UpcomingApiClient()
        val call=apiClient.getUpcoming(PopularApiClient.API_KEY,"en-US","1")

        call.enqueue(object: Callback<UpComing> {
            override fun onFailure(call: Call<UpComing>, t: Throwable) {
                Log.d("Error......",t.toString())
            }

            override fun onResponse(call: Call<UpComing>, response: Response<UpComing>) {
                resultPopular.value=response.body()
            }

        })
    }
}
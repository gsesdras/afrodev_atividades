package com.goiz.retrofit.res.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.goiz.retrofit.api.CepApi
import com.goiz.retrofit.models.Cep
import com.goiz.retrofit.util.NetworkUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CepRepository {
    fun getCep(cep: String): MutableLiveData<Cep> {

        val retrofit = NetworkUtils.retrofitConfig()

        val cepApi: CepApi = retrofit.create(CepApi::class.java)

        val callback: Call<Cep> = cepApi.getCep(cep)

        val mutableLiveData = MutableLiveData<Cep>()

        callback.enqueue(object : Callback<Cep> {
            override fun onResponse(call: Call<Cep>, response: Response<Cep>) {
                if (response.isSuccessful && response.body() != null){
                    mutableLiveData.value = response.body()
                }
            }

            override fun onFailure(call: Call<Cep>, t: Throwable) {
                Log.d("Erro!", "Deu ruim, mané!")
            }
        })

        return mutableLiveData
    }
}
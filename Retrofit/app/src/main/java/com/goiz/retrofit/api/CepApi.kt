package com.goiz.retrofit.api

import com.goiz.retrofit.models.Cep
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CepApi {

    @GET("{cep}/json")
    fun getCep(@Path("cep") cep: String) : Call<Cep>
}
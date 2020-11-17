package com.goiz.retrofit.models

import com.google.gson.annotations.SerializedName

data class Cep(
    @SerializedName("bairro")
    val district: String,

    val cep: String,

    @SerializedName("complemento")
    val complement: String,

    @SerializedName("ddd")
    val areaCode: String,

    @SerializedName("localidade")
    val city: String,

    @SerializedName("logradouro")
    val street: String,

    @SerializedName("uf")
    val state: String,

    @SerializedName("erro")
    val error: Boolean
) {

}
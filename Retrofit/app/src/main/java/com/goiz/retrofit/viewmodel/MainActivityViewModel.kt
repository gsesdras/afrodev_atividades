package com.goiz.retrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.goiz.retrofit.models.Cep
import com.goiz.retrofit.res.repository.CepRepository

class MainActivityViewModel(
    private val cepRepository: CepRepository = CepRepository()
) : ViewModel() {
    private lateinit var mutableLiveData: MutableLiveData<Cep>

    fun getCep(cep: String): MutableLiveData<Cep> {
        mutableLiveData = cepRepository.getCep(cep)

        return mutableLiveData
    }
}
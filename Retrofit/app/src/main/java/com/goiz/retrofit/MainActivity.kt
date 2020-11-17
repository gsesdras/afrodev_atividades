package com.goiz.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.goiz.retrofit.api.CepApi
import com.goiz.retrofit.models.Cep
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val btnGet by lazy { findViewById<Button>(R.id.btnGet) }
    private val txtResult by lazy { findViewById<TextView>(R.id.txtResult) }
    private val edtCep by lazy { findViewById<TextView>(R.id.edtCep) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGet.setOnClickListener {
            if(edtCep.text.isEmpty()){
                val msg = "Por favor, digite um CEP"
                txtResult.text = msg
                txtResult.visibility = View.VISIBLE
                return@setOnClickListener
            }
            val cep = edtCep.text.toString()
            getCepData(cep)
        }
    }

    fun setResultOnScreen(cep: Cep){
        if(cep.error){
            val msg = "CEP inválido"
            txtResult.text = msg
            txtResult.visibility = View.VISIBLE
            return
        }
        val msg = "${cep.city} - ${cep.state}"
        txtResult.text = msg
        txtResult.visibility = View.VISIBLE
    }
    fun setResultOnScreen(error: String){
        txtResult.text = error
        txtResult.visibility = View.VISIBLE
    }
    private fun getCepData(cep: String): String {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://viacep.com.br/ws/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val cepApi: CepApi = retrofit.create(CepApi::class.java)

        val callback: Call<Cep> = cepApi.getCep(cep)

        callback.enqueue(object : Callback<Cep> {
            override fun onResponse(call: Call<Cep>, response: Response<Cep>) {
                if (!response.isSuccessful){
                    setResultOnScreen("Erro número ${response.code()}")
                    return
                }

                response.body()?.let {
                    setResultOnScreen(it)
                }

            }

            override fun onFailure(call: Call<Cep>, t: Throwable) {
                txtResult.text = t.message
            }
        })

        return ""
    }
}
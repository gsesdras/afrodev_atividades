package com.goiz.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import com.goiz.retrofit.api.CepApi
import com.goiz.retrofit.models.Cep
import com.goiz.retrofit.viewmodel.MainActivityViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val btnGet by lazy { findViewById<Button>(R.id.btnGet) }
    private val txtResult by lazy { findViewById<TextView>(R.id.txtResult) }
    private val edtCep by lazy { findViewById<TextView>(R.id.edtCep) }
    private val viewModel = MainActivityViewModel()

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
            getCep(cep)
        }
    }

    fun getCep(cep: String){
        viewModel.getCep(cep).observe(this,
            { t ->
                t?.let{
                    txtResult.visibility = View.VISIBLE
                    txtResult.text = t.city
                }
            })
    }
}
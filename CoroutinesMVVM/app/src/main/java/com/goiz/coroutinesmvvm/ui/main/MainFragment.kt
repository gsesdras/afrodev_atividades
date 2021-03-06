package com.goiz.coroutinesmvvm.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.goiz.coroutinesmvvm.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private val txtMovies: TextView? by lazy { view?.findViewById(R.id.txtMovies) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, MainViewModel.MainViewModelFactory(MainRepository())).get(MainViewModel::class.java)
        viewModel.moviesLiveData.observe(viewLifecycleOwner, Observer {movies ->
            txtMovies?.let {
                it.text = movies[0].title
            }
        })

        viewModel.getMoviesCoroutines()
    }

}
package com.goiz.coroutinesmvvm.ui.main

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MainRepository {

    fun getMovies(callback: (movies: List<Movie>) -> Unit) {
        Thread(Runnable {
            Thread.sleep(3000)
            callback.invoke(
                listOf(
                    Movie(1, "Title 01"),
                    Movie(2, "Title 02")
                )
            )
        }).start()
    }

    suspend fun getMoviesCoroutines(): List<Movie>{
        return withContext(Dispatchers.Default){
            delay(3000)
            listOf(
                Movie(1, "Title 01"),
                Movie(2, "Title 02")
            )
        }
    }
}
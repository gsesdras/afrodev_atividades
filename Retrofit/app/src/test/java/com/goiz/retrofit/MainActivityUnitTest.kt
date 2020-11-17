package com.goiz.retrofit

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MainActivityUnitTest {

    private  lateinit var activity: MainActivity

    @Test
    fun shouldGetCityName(){

        val data = activity.getCep()
        val city = "New York City"

        assertEquals("You live in $city", data)
    }

    @Before
    fun createActivity(){
        activity = MainActivity()
    }

}
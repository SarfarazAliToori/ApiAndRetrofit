package com.example.apicallusingretrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


val url: String = "https://fakestoreapi.com/"
interface MyApiInterface {

    @GET("products")
    fun getProductsData(): Call<List<MyDataClass>>

}

object MySingleton {
    val myApiInterface: MyApiInterface

    init {
        val retrofit = Retrofit.Builder().baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        myApiInterface = retrofit.create(MyApiInterface::class.java)
    }




}
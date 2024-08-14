package com.example.newsnation

import org.intellij.lang.annotations.Language
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL="https://newsdata.io/api/1/"
const val API_KEY="pub_5061487851af7bf20777bdeabb740b6691790"
 interface NewsMethods
{
    @GET("latest?apikey=$API_KEY")
    fun getLatestNews(@Query("country")country:String,@Query("language")language:String):Call<NewsResult>

}

object NewsService {
    val newsMethods:NewsMethods
    init {
        val retrofit:Retrofit= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsMethods= retrofit.create(NewsMethods::class.java)
    }

}
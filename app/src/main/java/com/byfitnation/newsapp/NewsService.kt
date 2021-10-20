package com.byfitnation.newsapp.Data

import com.byfitnation.newsapp.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=in&apiKey=6b08e0df42984034bb2b2d74704ccd64

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "6b08e0df42984034bb2b2d74704ccd64"

interface NewsInterface {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country") country : String , @Query("page") page : Int) : Call<News>

    //https://newsapi.org/v2/top-headlines?apiKey=6b08e0df42984034bb2b2d74704ccd64&country=in&page=1
}

object NewsService{
    val newsInstance : NewsInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}
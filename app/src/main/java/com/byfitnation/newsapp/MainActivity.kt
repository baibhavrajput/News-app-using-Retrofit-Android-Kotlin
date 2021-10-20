package com.byfitnation.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import com.byfitnation.newsapp.CustomAdapter
import com.byfitnation.newsapp.Data.*
import com.byfitnation.newsapp.News
import com.byfitnation.newsapp.databinding.ActivityMainBinding
import retrofit2.*

class MainActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityMainBinding

    lateinit var adapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getNews()


    }

    private fun getNews() {
        val news = NewsService.newsInstance.getHeadlines("in", 1)
        news.enqueue(object : Callback<News?> {
            override fun onResponse(call: Call<News?>, response: Response<News?>) {
                val news = response.body()
                if (news != null) {

                    d("Baibhav", news.toString())
                    adapter = CustomAdapter(this@MainActivity, news.articles)

                    binding.newsList.adapter = adapter
                    binding.newsList.layoutManager = LinearLayoutManager(this@MainActivity)



                }
            }

            override fun onFailure(call: Call<News?>, t: Throwable) {
                d("Baibhav", "on failure" , t)
            }
        })
    }

}
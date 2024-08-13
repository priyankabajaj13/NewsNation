package com.example.newsnation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    val TAG="RetrofitDemo"
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: NewsAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    var newsList = mutableListOf<Result>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter= NewsAdapter(newsList)
        recyclerView= findViewById<RecyclerView>(R.id.rv_newsList)
        linearLayoutManager= LinearLayoutManager(this)
        recyclerView.layoutManager= linearLayoutManager
        recyclerView.adapter= adapter
        fetchNews()
    }
    fun fetchNews(){
        // we will make the api hit here
        val news:Call<NewsResult> = NewsService.newsMethods.getLatestNews("in","en")
        news.enqueue(object : Callback<NewsResult>{
            override fun onResponse(p0: Call<NewsResult>, p1: Response<NewsResult>) {
                if(p1.body()!=null)
                {
                    val result= p1.body()
                    if(result!=null)
                    {
                        newsList.addAll(result.results)
                        adapter.notifyDataSetChanged()

                    }

                }
            }

            override fun onFailure(p0: Call<NewsResult>, p1: Throwable) {
                Log.d(TAG,"error found")
            }
        })
    }
}

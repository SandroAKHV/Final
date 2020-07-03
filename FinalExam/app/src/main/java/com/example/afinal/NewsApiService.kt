package com.example.afinal

import retrofit2.Call
import retrofit2.http.GET

interface NewsApiService {

    @GET("latest-news?=language=us&apiKey=Ofv84k_GbpKKejpw--UcNbA-NnY8N2ZMRrCoaDXSsdaGt7kV")
    fun getNews() : Call<NewsArr<List<News>>>

}


package com.example.mytest2.web_service

import com.example.mytest2.response.Astro
import kotlinx.coroutines.Deferred
import retrofit2.http.GET



interface GetDataService {

    @GET("/planetary/apod?api_key=WGFry1kwkw8ZloxavIgonTuEjthJZsQRl8EeOzH7&start_date=2018-06-01&end_date=2018-06-15")
    fun astros():  Deferred<List<Astro>>
}

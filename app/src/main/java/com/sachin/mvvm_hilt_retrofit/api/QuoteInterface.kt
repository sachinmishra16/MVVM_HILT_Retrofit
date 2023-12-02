package com.sachin.mvvm_hilt_retrofit.api

import com.sachin.mvvm_hilt_retrofit.model.QuoteResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteInterface
{
    @GET("quotes")
     suspend fun getQuotes(@Query("page") page:Int):Response<QuoteResponse>
}
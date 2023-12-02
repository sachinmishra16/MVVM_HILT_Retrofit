package com.sachin.mvvm_hilt_retrofit.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sachin.mvvm_hilt_retrofit.api.QuoteInterface
import com.sachin.mvvm_hilt_retrofit.model.QuoteResponse
import javax.inject.Inject

class QuoteRepository @Inject constructor(var quoteInterface: QuoteInterface)
{
    var repMutableLivedata=MutableLiveData<QuoteResponse>()

    var repLiveData:LiveData<QuoteResponse>?=null
        get() = repMutableLivedata

   suspend fun getQuotesRepo(page:Int)
    {
        var result=quoteInterface.getQuotes(page)
        if (result.body()!=null)
        {
            repMutableLivedata.postValue(result.body())
        }
    }
}
package com.sachin.mvvm_hilt_retrofit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sachin.mvvm_hilt_retrofit.model.QuoteResponse
import com.sachin.mvvm_hilt_retrofit.repository.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(var quoteRepository: QuoteRepository):ViewModel()
{
    init {
        viewModelScope.launch {
            quoteRepository.getQuotesRepo(1)

        }
    }
    var viewmodelLiveData:LiveData<QuoteResponse>?=null
        get()=quoteRepository.repLiveData



}
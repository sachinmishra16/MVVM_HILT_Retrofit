package com.sachin.mvvm_hilt_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sachin.mvvm_hilt_retrofit.adapter.QuotesAdapter
import com.sachin.mvvm_hilt_retrofit.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var quoteViewModel: QuoteViewModel
    lateinit var rvQuotes:RecyclerView
    lateinit var quotesAdapter: QuotesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvQuotes=findViewById(R.id.rvQuotes)
        rvQuotes.layoutManager=LinearLayoutManager(this)

       quoteViewModel=ViewModelProvider(this).get(QuoteViewModel::class.java)
        quoteViewModel.viewmodelLiveData?.observe(this, Observer {
            Log.d("quoteData",it.toString())
            quotesAdapter=QuotesAdapter(it.results)
            rvQuotes.adapter=quotesAdapter

        })


    }
}
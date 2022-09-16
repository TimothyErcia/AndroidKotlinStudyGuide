package com.example.androidkotlinstudyguided.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidkotlinstudyguided.R
import com.example.androidkotlinstudyguided.adapter.Fragment3RecyclerViewAdapter
import com.example.androidkotlinstudyguided.model.Photos
import com.example.androidkotlinstudyguided.model.PhotosAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

class Fragment_3 : Fragment() {

    lateinit var photosArray: ArrayList<Photos>

    init {
        initializeRetrofit()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_3, container, false)
        val recyclerView2: RecyclerView = view.findViewById(R.id.recyclerView2)
        val adapter = Fragment3RecyclerViewAdapter(view.context, photosArray)

        recyclerView2.layoutManager = GridLayoutManager(view.context, 2)
        recyclerView2.adapter = adapter

        return view
    }

    fun initializeRetrofit() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val photosAPI = retrofit.create(PhotosAPI::class.java)
        val call = photosAPI.getPhotos()
        call.enqueue(object: Callback<List<Photos>> {
            override fun onResponse(call: Call<List<Photos>>, response: Response<List<Photos>>) {
                if(response.isSuccessful) {
                    val res: List<Photos>? = response.body()
                    if(res != null) {
                        photosArray = res as ArrayList<Photos>
                        Log.i("COUNT 2", "${photosArray.size}")
                    }
                } else {
                    Log.i("FAILED", "FAILED")
                }
            }

            override fun onFailure(call: Call<List<Photos>>, t: Throwable) {
                Log.i("FAILED", "FAILED")
            }
        })
    }
}

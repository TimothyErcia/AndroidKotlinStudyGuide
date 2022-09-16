package com.example.androidkotlinstudyguided.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidkotlinstudyguided.R
import com.example.androidkotlinstudyguided.adapter.Fragment2RecyclerViewAdapater
import com.example.androidkotlinstudyguided.model.Car

class Fragment_2 : Fragment() {

    private var carArrayList: ArrayList<Car> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_2, container, false)
        val recyclerView1 : RecyclerView = view.findViewById(R.id.recyclerView1)
        initializeCarData()
        val adapter = Fragment2RecyclerViewAdapater(carArrayList)

        recyclerView1.layoutManager = LinearLayoutManager(view.context)
        recyclerView1.adapter = adapter

        return view
    }

    private fun initializeCarData() {
        carArrayList.add(Car("Honda", "Honda", 2))
        carArrayList.add(Car("Toyota", "Honda", 3))
        carArrayList.add(Car("Honda", "Honda", 4))
        carArrayList.add(Car("BMW", "Honda", 10))
        carArrayList.add(Car("Honda", "Honda", 2))
    }
}
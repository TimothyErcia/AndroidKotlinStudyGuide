package com.example.androidkotlinstudyguided.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidkotlinstudyguided.R
import com.example.androidkotlinstudyguided.model.Car

class Fragment2RecyclerViewAdapater(_carArrayList: ArrayList<Car>) :
    RecyclerView.Adapter<Fragment2RecyclerViewAdapater.mViewHolder>() {

    private var carArrayList: ArrayList<Car> = _carArrayList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.car_list_item, parent, false)
        return mViewHolder(view)
    }

    override fun onBindViewHolder(holder: mViewHolder, position: Int) {
        holder.carName.text = carArrayList[position]._carName
        holder.carBrandName.text = carArrayList[position]._carBrand
        holder.carQuantity.text = carArrayList[position]._carQuantity.toString()
    }

    override fun getItemCount(): Int {
        return carArrayList.size
    }

    class mViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val carName: TextView = itemView.findViewById(R.id.carNameTextView)
        val carBrandName: TextView = itemView.findViewById(R.id.carBrandTextView)
        val carQuantity: TextView = itemView.findViewById(R.id.carQuanntityTextView)
    }
}
package com.juaraandroid.brande.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.juaraandroid.brande.R
import com.juaraandroid.brande.model.CarBrandsData

class ListCarBrandsAdapter(private val listCarBrandsData: ArrayList<CarBrandsData>) : RecyclerView.Adapter<ListCarBrandsAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_row_car_brands, parent, false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (
            carBrandLogo,
            carBrandName,
            carBrandFounded,
            carBrandCountry
        ) = listCarBrandsData[position]

        holder.apply {
            imageItemCarBrandLogo.setImageResource(carBrandLogo)
            textItemCarBrandName.text = carBrandName
            textItemCarBrandFounded.text = carBrandFounded
            imageItemCarBrandCountry.setImageResource(carBrandCountry)
        }
    }

    override fun getItemCount(): Int = listCarBrandsData.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageItemCarBrandLogo: ImageView = itemView.findViewById(R.id.image_item_car_brand_logo)
        var textItemCarBrandName: TextView = itemView.findViewById(R.id.text_item_car_brand_name)
        var textItemCarBrandFounded: TextView = itemView.findViewById(R.id.text_item_car_brand_founded)
        var imageItemCarBrandCountry: ImageView = itemView.findViewById(R.id.image_item_car_brand_country)
    }
}
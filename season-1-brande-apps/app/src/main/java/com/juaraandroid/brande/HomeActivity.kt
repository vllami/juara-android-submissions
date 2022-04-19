package com.juaraandroid.brande

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.juaraandroid.brande.adapter.ListCarBrandsAdapter
import com.juaraandroid.brande.databinding.ActivityHomeBinding
import com.juaraandroid.brande.model.CarBrandsData

class HomeActivity : AppCompatActivity() {
    private lateinit var activityHomeBinding: ActivityHomeBinding

    private val carBrandsList = ArrayList<CarBrandsData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(activityHomeBinding.root)

        activityHomeBinding.apply {
            setSupportActionBar(toolbarMainTitle)

            recyclerviewMainCarBrands.setHasFixedSize(true)

            carBrandsList.addAll(listCarBrandsData)
            showRecyclerViewCarBrands()
        }
    }

    private val listCarBrandsData: ArrayList<CarBrandsData>
        @SuppressLint("Recycle")
        get() {
            val dataCarBrandsLogo = resources.obtainTypedArray(R.array.car_brands_logo)
            val dataCarBrandsName = resources.getStringArray(R.array.car_brands_name)
            val dataCarBrandsFounded = resources.getStringArray(R.array.car_brands_founded)
            val dataCarBrandsCountry = resources.obtainTypedArray(R.array.car_brands_country)
            val listCarBrands = ArrayList<CarBrandsData>()

            for (i in dataCarBrandsName.indices) {
                val carBrands = CarBrandsData(
                    dataCarBrandsLogo.getResourceId(i, -1),
                    dataCarBrandsName[i],
                    dataCarBrandsFounded[i],
                    dataCarBrandsCountry.getResourceId(i, -1)
                )

                listCarBrands.add(carBrands)
            }

            return listCarBrands
        }

    private fun showRecyclerViewCarBrands() {
        activityHomeBinding.apply {
            recyclerviewMainCarBrands.layoutManager = LinearLayoutManager(this@HomeActivity)

            val carBrandsAdapter = ListCarBrandsAdapter(carBrandsList)
            recyclerviewMainCarBrands.adapter = carBrandsAdapter
        }
    }
}
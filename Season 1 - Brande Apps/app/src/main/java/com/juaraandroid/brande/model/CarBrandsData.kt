package com.juaraandroid.brande.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CarBrandsData(
    var carBrandsLogo: Int,
    var carBrandsName: String,
    var carBrandsFounded: String,
    var carBrandsCountry: Int
): Parcelable
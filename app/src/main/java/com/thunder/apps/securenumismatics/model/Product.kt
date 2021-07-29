package com.thunder.apps.securenumismatics.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product (
    val user_id : String = "",
    val user_name : String = "",
    val title : String = "",
    val price : String = "",
    val description: String = "",
    val continent: String = "",
    val country: String = "",
    val stock_quantity : String = "",
    val image : String = "",
    var product_id : String = ""

        ) : Parcelable
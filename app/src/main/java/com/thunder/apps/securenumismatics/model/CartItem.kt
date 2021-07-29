package com.thunder.apps.securenumismatics.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CartItem (
    val user_id : String = "",
    val product_owner_id :String = "",
    val product_id : String = "",
    val title : String = "",
    val price : String = "",
    val image : String = "",
    val continent : String = "",
    val country : String = "",
    var cart_quantity : String = "",
    var stock_quantity : String = "",
    var id : String = ""
        ) : Parcelable
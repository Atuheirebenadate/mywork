package com.devbenadate.workout

import com.google.gson.annotations.SerializedName

data class exerciseCategory(
    @SerializedName("cateory_id") var categoryId:String,
    @SerializedName("category_name")var categoryName:String,
)

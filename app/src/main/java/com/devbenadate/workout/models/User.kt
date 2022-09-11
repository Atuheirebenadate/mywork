package com.devbenadate.workout.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("first_name")var firstName:String,
    @SerializedName("last_name")  var lastName: String,
    var email:String,
   @SerializedName("user_id") var userId:String

)

package com.devbenadate.workout.models

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    var message:String,
    @SerializedName("access_token")var UserId:String,
    @SerializedName("user_id") var email:String,
    @SerializedName("profile_id")  var profile_id:String,
    @SerializedName("access_token") var accessToken:String,


)

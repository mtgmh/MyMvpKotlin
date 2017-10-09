package com.wangfei.com.mymvpkotlin.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by asus on 2017/9/25.
 */
const val BASE_URL = "https://api.github.com/"

data class Repo(@SerializedName("full_name") var name: String,
                var description: String,
                @SerializedName("stargazers_count") var stargazers: Int)
data class Users(var items: List<User>)

data class User(@SerializedName("login") var name: String, var avatar_url: String,
                var html_url: String, var score: Double, var repos_url: String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readDouble(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(avatar_url)
        parcel.writeString(html_url)
        parcel.writeDouble(score)
        parcel.writeString(repos_url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }


}
package com.example.myapplication1.ui.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi

fun Context.showToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun Context.isOnline(): Boolean {
    val connectivityManager =
        this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
   if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
       val capabilities =
           connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
       if (capabilities != null) {
           when {
               capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                   return true
               }
               capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                   return true
               }
               capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                   return true
               }
           }
       }
   } else {
       val activityNetworkInfo = connectivityManager.activeNetworkInfo
       if (activityNetworkInfo != null && activityNetworkInfo.isConnected) {
           return true
       }
   }
    return false
}
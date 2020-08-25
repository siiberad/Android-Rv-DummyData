package com.siiberad.rupi.login.viewmodel

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel

class LoginViewModel(app : Application) : AndroidViewModel(app){

    val s: SharedPreferences = app.getSharedPreferences("USER", Context.MODE_PRIVATE)

    fun getData(username: String, email:String){
        val editor: SharedPreferences.Editor = s.edit()
        editor.putString("username", username)
        editor.putString("email", email)
        editor.apply()
    }

}
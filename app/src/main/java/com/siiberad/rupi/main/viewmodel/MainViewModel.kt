package com.siiberad.rupi.main.viewmodel

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.siiberad.rupi.main.MainActivity
import com.siiberad.rupi.main.model.RvDataModel

class MainViewModel(app: Application) : AndroidViewModel(app) {
    val s: SharedPreferences = app.getSharedPreferences("USER", Context.MODE_PRIVATE)
    val currentPage = MutableLiveData<MainPage>()
    val data = MutableLiveData<List<RvDataModel>>()
    val username = s.getString("username", "")
    val email = s.getString("email", "")

    fun setPage(page: MainPage) {
        if (currentPage.value != page)
            currentPage.value = page
    }

    enum class MainPage {
        HOME,
        ACCOUNT
    }

    fun getData(): LiveData<List<RvDataModel>> {
        return data
    }

}
package com.siiberad.rupi.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.siiberad.rupi.R
import com.siiberad.rupi.main.fragment.AkunFragment
import com.siiberad.rupi.main.fragment.HomeFragment
import com.siiberad.rupi.main.model.RvDataModel
import com.siiberad.rupi.main.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        fun show(source: Activity) {
            source.startActivity(Intent(source, MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            })
        }
        fun dummyRv() = listOf(
            RvDataModel("data 1", "detail 1", R.drawable.ic_baseline_account_box_24),
            RvDataModel("data 2", "detail 2", R.drawable.ic_baseline_account_box_24),
            RvDataModel("data 3", "detail 3", R.drawable.ic_baseline_account_box_24),
            RvDataModel("data 4", "detail 4", R.drawable.ic_baseline_account_box_24),
            RvDataModel("data 5", "detail 5", R.drawable.ic_baseline_account_box_24),
            RvDataModel("data 6", "detail 6", R.drawable.ic_baseline_account_box_24),
        )
    }

    lateinit var vm: MainViewModel
    private var currentPage: MainViewModel.MainPage? = null
    private var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vm = ViewModelProvider(this).get(MainViewModel::class.java)
        vm.data.postValue(dummyRv())
        vm.setPage(MainViewModel.MainPage.HOME)
        bottom_nav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_home -> vm.setPage(MainViewModel.MainPage.HOME)
                R.id.action_account -> vm.setPage(MainViewModel.MainPage.ACCOUNT)
            }
            return@setOnNavigationItemSelectedListener true
        }
        observeInit()
    }
    private fun observeInit(){
        vm.currentPage.observe(this, Observer {
            if (it != null) {
                changePage(it)
                currentPage = it
                handleBottomNav(it)
            }
        })
    }

    private fun handleBottomNav(page: MainViewModel.MainPage) {
        when (page) {
            MainViewModel.MainPage.HOME -> bottom_nav.selectedItemId = R.id.action_home
            MainViewModel.MainPage.ACCOUNT -> bottom_nav.selectedItemId = R.id.action_account
        }
    }

    private fun changePage(page: MainViewModel.MainPage) {
        if (page == currentPage) return

        val f: Fragment = when (page) {
            MainViewModel.MainPage.HOME -> HomeFragment.getInstance()
            MainViewModel.MainPage.ACCOUNT -> AkunFragment.getInstance()
        }
        val trx = supportFragmentManager.beginTransaction()
        trx.apply {
            if (page != MainViewModel.MainPage.HOME) addToBackStack(null)
            replace(R.id.vFrameMain, f, f.tag)
        }.commit()

        currentFragment = f
    }
}
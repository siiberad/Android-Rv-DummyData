package com.siiberad.rupi.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.siiberad.rupi.R
import com.siiberad.rupi.main.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_akun.*

class AkunFragment : Fragment() {
    lateinit var vm: MainViewModel
    companion object {
        fun getInstance() = AkunFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_akun, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm = ViewModelProvider(this).get(MainViewModel::class.java)
        txt_username_account.text = vm.username
        txt_email_account.text = vm.email
        btn_logout.setOnClickListener {activity?.finish()}
    }
}
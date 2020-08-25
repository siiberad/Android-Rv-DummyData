package com.siiberad.rupi.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.siiberad.rupi.R
import com.siiberad.rupi.login.viewmodel.LoginViewModel
import com.siiberad.rupi.main.MainActivity
import com.siiberad.rupi.utils.Util
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    lateinit var vm: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        vm = ViewModelProvider(this).get(LoginViewModel::class.java)
        supportActionBar?.hide()
        btn_registration.setOnClickListener {
            if (isValid()){
                vm.getData(txt_username.text.toString(), txt_email.text.toString())
                MainActivity.show(this)
            }
        }
    }

    private fun isValid(): Boolean {
        val ret = true
        if (txt_username.text?.isEmpty()!!) {
            txt_username.error = "Username Harus Diisi"
            return false
        }

        if (!Util.isEmailValid(txt_email.text.toString())) {
            txt_email.error = "Harus Email"
            return false
        }

        if (txt_password.text?.isEmpty()!!) {
            txt_password.error = "Password Harus Diisi"
            return false
        }
        return ret
    }
}
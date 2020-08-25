package com.siiberad.rupi.utils

import android.os.Build
import android.util.Patterns

class Util {
    companion object{
        fun isEmailValid(email: String): Boolean {
            return Patterns.EMAIL_ADDRESS.toRegex().matches(email);
        }
        fun isLollipopOrAbove(): Boolean{
            return (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        }
    }
}
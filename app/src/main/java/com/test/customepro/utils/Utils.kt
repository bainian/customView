package com.test.customepro.utils

import android.util.Log

/**
 * Created by sage on 17-8-29.
 */

object Utils {
    fun Any.log(msg: String) {
//        Toast.makeText(App.instance.appContext, msg, Toast.LENGTH_SHORT).show()
        Log.d("log", msg)
    }
}

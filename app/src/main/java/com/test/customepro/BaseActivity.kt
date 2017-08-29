package com.test.customepro

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by sage on 17-8-29.
 */

class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.baseactivity_layout)

    }
}
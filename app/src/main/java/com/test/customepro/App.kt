package com.test.customepro

import android.app.Application
import android.content.Context

/**
 * Created by sage on 17-8-29.
 */

class App : Application() {
    internal var appContext: Context? = null

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this.applicationContext
        instance = this

    }
}

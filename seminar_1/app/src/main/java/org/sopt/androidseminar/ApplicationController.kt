package org.sopt.androidseminar

import android.app.Application
import org.sopt.androidseminar.data.SoptUserAuthStorage.initPreferences

class ApplicationController : Application() {

    override fun onCreate() {
        super.onCreate()
        initPreferences(this)
    }
}
package com.example.sampletheme

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.paperdb.Paper

@HiltAndroidApp
class ThemeApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Paper.init(this)
    }
}
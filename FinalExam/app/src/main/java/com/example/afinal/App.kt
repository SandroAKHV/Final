package com.example.afinal

import android.app.Application

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        RetrofitClient.initClient()
    }
}
package com.fixkar.app

import android.app.Application
import com.google.firebase.FirebaseApp
import dagger.hilt.android.HiltAndroidApp

/**
 * Application class — first thing that runs when the app starts.
 *
 * Responsibilities:
 *  - Initialize Hilt (DI container)
 *  - Initialize Firebase
 *
 * Hilt needs the @HiltAndroidApp annotation on the Application class to
 * generate the base DI component used by every other @AndroidEntryPoint.
 */
@HiltAndroidApp
class FixKarApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // Firebase auto-init is fine, but calling explicitly makes failures obvious
        // early at startup instead of at first-use.
        FirebaseApp.initializeApp(this)
    }
}

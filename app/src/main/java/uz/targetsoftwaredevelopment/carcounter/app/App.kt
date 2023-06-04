package uz.targetsoftwaredevelopment.carcounter.app

import android.app.Application

/**
 * Date: 04/06/2023
 * Developer: Abdulaziz Akhmedov
 */

class App : Application() {
    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}

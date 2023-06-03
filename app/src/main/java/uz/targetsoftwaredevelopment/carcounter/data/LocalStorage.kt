package uz.targetsoftwaredevelopment.carcounter.data

import com.securepreferences.SecurePreferences
import uz.targetsoftwaredevelopment.carcounter.app.App
import uz.targetsoftwaredevelopment.carcounter.utils.IntPreference

class LocalStorage {
    private val KEY = "sdedwdwefejhdjshdkfjhdkjfhdsjkhfkjsdfkhkjsdhjfdh"
    private val pref = SecurePreferences(App.instance, KEY, "language_preference.xml")

    companion object {
        private lateinit var instance: LocalStorage

        fun getInstance(): LocalStorage {
            if (!::instance.isInitialized) {
                instance = LocalStorage()
            }
            return instance
        }
    }

    var carA: Int by IntPreference(pref)
    var carB: Int by IntPreference(pref)

    var miniBusA: Int by IntPreference(pref)
    var miniBusB: Int by IntPreference(pref)

    var busA: Int by IntPreference(pref)
    var busB: Int by IntPreference(pref)

    var truckUpTo3A: Int by IntPreference(pref)
    var truckUpTo3B: Int by IntPreference(pref)

    var truckUpTo12A: Int by IntPreference(pref)
    var truckUpTo12B: Int by IntPreference(pref)

    var truckAbove12A: Int by IntPreference(pref)
    var truckAbove12B: Int by IntPreference(pref)

    var roadTrainsA: Int by IntPreference(pref)
    var roadTrainsB: Int by IntPreference(pref)

    var otherA: Int by IntPreference(pref)
    var otherB: Int by IntPreference(pref)
}

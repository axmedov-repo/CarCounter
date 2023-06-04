package uz.targetsoftwaredevelopment.carcounter.data

import com.securepreferences.SecurePreferences
import uz.targetsoftwaredevelopment.carcounter.app.App
import uz.targetsoftwaredevelopment.carcounter.utils.IntPreference
import uz.targetsoftwaredevelopment.carcounter.utils.StringPreference

class LocalStorage private constructor() {
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

    var carA: Int by IntPreference(pref, 0)
    var carB : Int by IntPreference(pref, 0)

    var miniBusA: Int by IntPreference(pref, 0)
    var miniBusB: Int by IntPreference(pref, 0)

    var busA: Int by IntPreference(pref, 0)
    var busB: Int by IntPreference(pref, 0)

    var truckUpTo3A: Int by IntPreference(pref, 0)
    var truckUpTo3B: Int by IntPreference(pref, 0)

    var truckUpTo12A: Int by IntPreference(pref, 0)
    var truckUpTo12B: Int by IntPreference(pref, 0)

    var truckAbove12A: Int by IntPreference(pref, 0)
    var truckAbove12B: Int by IntPreference(pref, 0)

    var roadTrainsA: Int by IntPreference(pref, 0)
    var roadTrainsB: Int by IntPreference(pref, 0)

    var otherA: Int by IntPreference(pref, 0)
    var otherB: Int by IntPreference(pref, 0)

    var allData: String by StringPreference(pref)
}

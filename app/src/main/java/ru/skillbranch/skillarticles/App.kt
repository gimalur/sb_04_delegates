package ru.skillbranch.skillarticles

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import ru.skillbranch.skillarticles.data.PrefManager

class App : Application() {

    companion object {
        private lateinit var instance: App

        fun applicationContext(): Context {
            return instance.applicationContext
        }
    }

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        val pref = PrefManager()
        val nightMode = if (pref.isDarkMode) {
            AppCompatDelegate.MODE_NIGHT_YES
        } else {
            AppCompatDelegate.MODE_NIGHT_NO
        }
        AppCompatDelegate.setDefaultNightMode(nightMode)

//        testPrefs(pref)
    }

    private fun testPrefs(pref: PrefManager) {
        Log.e("App", "pref.testBoolean ${pref.testBoolean}")
        pref.testBoolean = true
        Log.e("App", "pref.testBoolean ${pref.testBoolean}")

        Log.e("App", "pref.testDouble ${pref.testDouble}")
        pref.testDouble = Double.MIN_VALUE
        Log.e("App", "pref.testDouble ${pref.testDouble}")

        Log.e("App", "pref.testString ${pref.testString}")
        pref.testString = "test string value"
        Log.e("App", "pref.testString ${pref.testString}")

        Log.e("App", "pref.testFloat ${pref.testFloat}")
        pref.testFloat = Float.MIN_VALUE
        Log.e("App", "pref.testFloat ${pref.testFloat}")

        Log.e("App", "pref.testInt ${pref.testInt}")
        pref.testInt = Int.MIN_VALUE
        Log.e("App", "pref.testInt ${pref.testInt}")

        Log.e("App", "pref.testLong ${pref.testLong}")
        pref.testLong = Long.MIN_VALUE
        Log.e("App", "pref.testLong ${pref.testLong}")
    }

}

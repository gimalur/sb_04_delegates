package ru.skillbranch.skillarticles

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import ru.skillbranch.skillarticles.data.PrefManager
import ru.skillbranch.skillarticles.data.local.User

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
//        testUser(pref)
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

    private fun testUser(pref: PrefManager) {
        val user1 = User(
            id = "test_id",
            name = "user_name",
            avatar = "non_null_avatar",
            rating = 5,
            respect = 6,
            about = "non_null_adapter"
        )

        pref.testUser = null
        Log.e("App", "pref.user1 ${pref.testUser}")
        pref.testUser = user1
        Log.e("App", "pref.user1 ${pref.testUser}")
        Log.e("App", "equals ${pref.testUser == user1}")

        val user2 = User(
            id = "id2",
            name = "name2",
            avatar = null,
            rating = 7,
            respect = 62,
            about = null
        )
        pref.testUser = null
        Log.e("App", "pref.user2 ${pref.testUser}")
        pref.testUser = user2
        Log.e("App", "pref.user2 ${pref.testUser}")
        Log.e("App", "equals ${pref.testUser == user2}")

    }

}

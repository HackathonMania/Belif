package hackathon.belif.belif.base

import android.app.Application
import android.content.Context
import androidx.multidex.BuildConfig
import androidx.multidex.MultiDex
import hackathon.belif.belif.utils.PreferenceUtils
import timber.log.Timber

class App : Application(){

    lateinit var sp: PreferenceUtils

    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }


    fun getToken(): String {
        return sp.get(String::class, "token", "") as String
    }

    fun isLogin(): Boolean {
        return sp.get(Boolean::class, "is_login", false) as Boolean
    }

    fun logout() {
        sp.clear()
    }
}
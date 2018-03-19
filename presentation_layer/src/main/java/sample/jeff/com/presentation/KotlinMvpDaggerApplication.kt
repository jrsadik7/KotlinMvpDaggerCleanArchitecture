package sample.jeff.com.presentation

import android.content.Context
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication

import com.facebook.stetho.Stetho
import com.singhajit.sherlock.core.Sherlock
import com.tspoon.traceur.Traceur

import sample.jeff.com.presentation.dagger.dagger_components.AppComponent
import sample.jeff.com.presentation.dagger.dagger_components.DaggerAppComponent
import timber.log.Timber
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

/**
 * Created by jaffer on 14/4/17.
 */

class KotlinMvpDaggerApplication : MultiDexApplication() {

    val applicationComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
        if (BuildConfig.DEBUG) {
            initDebugLibs()
        }
        setupDagger()

        Stetho.initializeWithDefaults(this)

        CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/roboto_regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build())

    }

    private fun initDebugLibs() {
        Timber.plant(Timber.DebugTree())
        Sherlock.init(this)
        Traceur.enableLogging()
    }

    private fun setupDagger() {
        if (applicationComponent == null) {

        }

    }


    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    companion object {

        var instance: KotlinMvpDaggerApplication? = null
            private set

        operator fun get(context: Context): KotlinMvpDaggerApplication {
            return context.applicationContext as KotlinMvpDaggerApplication
        }
    }
}

package sample.jeff.com.presentation.dagger.dagger_modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

import dagger.Module
import dagger.Provides

/**
 * Created by jaffer on 24/10/17.
 */

@Module
class PreferenceModule(private val application: Application) {
    internal var PREF_FILE_NAME = "sample_app"

    @Provides
    internal fun provideSharedPrefs(): SharedPreferences {
        return application.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
    }
}

package sample.jeff.com.presentation.dagger.dagger_modules

import android.app.Application
import android.content.Context


import dagger.Module
import dagger.Provides
import sample.jeff.com.presentation.dagger.qualifiers.ApplicationContext

/**
 * Created by jaffer on 23/10/17.
 */

@Module
class AppModule(private val application: Application) {

    @Provides
    @ApplicationContext
    internal fun provideContext(): Context {
        return application
    }
}
package sample.jeff.com.presentation.dagger.dagger_components

import dagger.Component
import sample.jeff.com.presentation.dagger.dagger_modules.AppModule
import javax.inject.Singleton

/**
 * Created by  on 16/3/18.
 */

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
}
package sample.jeff.com.presentation.features.onboard.di

import dagger.Module
import sample.jeff.com.presentation.dagger.dagger_modules.NetworkModule

/**
 * Created by  on 18/3/18.
 */
@Module(includes = arrayOf(NetworkModule::class))
class OnBoardActivityModule {
}
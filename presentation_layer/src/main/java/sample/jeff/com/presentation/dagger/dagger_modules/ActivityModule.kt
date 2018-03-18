package sample.jeff.com.presentation.dagger.dagger_modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import sample.jeff.com.presentation.features.onboard.OnBoardActivity
import sample.jeff.com.presentation.features.onboard.di.OnBoardActivityModule

/**
 * Created by shivam on 20/7/17.
 */

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [OnBoardActivityModule::class])
    abstract fun bindOnBoard(): OnBoardActivity

}
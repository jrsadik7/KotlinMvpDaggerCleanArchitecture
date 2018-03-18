package sample.jeff.com.presentation.dagger.dagger_components

import dagger.Component
import sample.jeff.com.presentation.dagger.dagger_modules.ActivityModule
import sample.jeff.com.presentation.dagger.scopes.PerActivity

/**
 * Created by  on 16/3/18.
 */
@PerActivity
@Component(dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

}
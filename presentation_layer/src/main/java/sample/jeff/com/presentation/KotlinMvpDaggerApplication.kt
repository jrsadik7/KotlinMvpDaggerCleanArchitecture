package sample.jeff.com.presentation

import android.content.Context
import android.support.multidex.MultiDexApplication
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

/**
 * Created by  on 15/3/18.
 */
class KotlinMvpDaggerApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        CalligraphyConfig.initDefault(
                CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/roboto_regular.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        )
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(base))
    }
}
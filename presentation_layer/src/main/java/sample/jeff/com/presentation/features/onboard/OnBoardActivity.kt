package sample.jeff.com.presentation.features.onboard

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.setContentView

/**
 * Created by  on 15/3/18.
 */
class OnBoardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        OnBoardView().setContentView(this)
    }
}
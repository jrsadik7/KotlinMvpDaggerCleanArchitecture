package sample.jeff.com.presentation.features.onboard

import android.graphics.Color
import android.view.Gravity
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class OnBoardView : AnkoComponent<OnBoardActivity> {
    override fun createView(ui: AnkoContext<OnBoardActivity>) = with(ui) {
        verticalLayout {
            gravity = Gravity.CENTER
            padding = dip(20)

            textView {
                gravity = Gravity.CENTER
                text = "Enter your request"
                textColor = Color.BLACK
                textSize = 24f
            }.lparams(width = matchParent) {
                margin = dip(20)
            }

            val name = editText {
                hint = "What is your name?"
                lines =1
            }

            editText {
                hint = "What is your message?"
                lines = 1
            }

            button("Enter") {
                onClick {
                    toast("Hey ${name.text}! Thank you for contacting us. We will get in touch with you soon.")
                }
            }.lparams(dip(280), sp(80))

        }
    }

}

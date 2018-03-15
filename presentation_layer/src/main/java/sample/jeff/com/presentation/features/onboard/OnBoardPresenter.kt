package sample.jeff.com.presentation.features.onboard

import sample.jeff.com.data.SampleData
import sample.jeff.com.domain.SampleDomain


/**
 * Created by  on 15/3/18.
 */
class OnBoardPresenter {

    fun nothing() {
        SampleData.getDataString()
        SampleDomain.getDomainString()
    }
}
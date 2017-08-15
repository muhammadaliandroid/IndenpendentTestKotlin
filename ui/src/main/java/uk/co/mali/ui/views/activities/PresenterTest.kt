package uk.co.mali.ui.views.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import uk.co.mali.kotlinpractice.R
import uk.co.mali.ui.presenter.Presenter

class PresenterTest : AppCompatActivity() {

    var presenter: Presenter = Presenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_presenter_test)
        presenter.initializeDataList()
    }
}

package uk.co.mali.ui.injector.component

import dagger.Component
import uk.co.mali.data.injector.component.AppComponent
import uk.co.mali.data.injector.repository.DataRepository
import uk.co.mali.ui.injector.module.DataRepositoryModule
import uk.co.mali.ui.injector.scope.DataScope
import uk.co.mali.ui.presenter.Presenter

/**
 * Created by alig2 on 15/08/2017.
 */
@DataScope
@Component(modules = arrayOf(DataRepositoryModule::class), dependencies = arrayOf(AppComponent::class))
interface DataRespositoryComponent {

    fun inject(presenter: Presenter)
    fun dataRepository(): DataRepository
}

package uk.co.mali.data.injector.component

import dagger.Component
import uk.co.mali.data.injector.module.DataRepositoryModule
import uk.co.mali.data.injector.repository.DataRepository
import uk.co.mali.data.injector.scope.DataScope

/**
 * Created by alig2 on 15/08/2017.
 */
@DataScope
@Component(modules = arrayOf(DataRepositoryModule::class), dependencies = arrayOf(AppComponent::class))
interface DataRespositoryComponent {

    fun inject(dataRepository: DataRepository)
    fun dataRepository(): DataRepository
}

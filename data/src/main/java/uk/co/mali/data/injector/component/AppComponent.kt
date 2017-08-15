package uk.co.mali.data.injector.component

import dagger.Component
import uk.co.mali.data.injector.module.NetModule
import uk.co.mali.data.injector.module.RestApiServiceModule
import uk.co.mali.data.injector.module.RxModule
import uk.co.mali.data.injector.scope.AppScope
import uk.co.mali.data.util.scheduler.IRxSchedulers
import uk.co.mali.independenttest.model.api.RestApi

/**
 * Created by alig2 on 14/08/2017.
 */

@AppScope
@Component(modules = arrayOf(NetModule::class,RxModule::class,RestApiServiceModule::class))
interface AppComponent {
    fun iRxSchedulers(): IRxSchedulers
    fun restApiService():RestApi
}
package uk.co.mali.data

import android.app.Application
import uk.co.mali.data.injector.component.AppComponent
import uk.co.mali.data.injector.module.NetModule
import uk.co.mali.data.injector.module.RestApiServiceModule
import uk.co.mali.data.injector.module.RxModule

/**
 * Created by alig2 on 14/08/2017.
 */
class IndependentApplication : Application() {

    object IndependentApplication{
        var appComponent: AppComponent? = null

        fun initDaggerAppComponent() {
            appComponent = DaggerAppComponent.builder()
                    .netModule(NetModule())
                    .rxModule(RxModule())
                    .restApiServiceModule(RestApiServiceModule()).build()

        }
    }



    override fun onCreate() {
        super.onCreate()



    }




}
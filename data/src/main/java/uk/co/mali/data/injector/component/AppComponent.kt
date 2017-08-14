package uk.co.mali.data.injector.component

import android.app.Application
import dagger.Component
import uk.co.mali.data.injector.module.AppModule
import uk.co.mali.data.injector.scope.AppScope

/**
 * Created by alig2 on 14/08/2017.
 */

@AppScope
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun inject(application: Application)

}
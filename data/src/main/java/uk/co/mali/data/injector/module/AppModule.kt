package uk.co.mali.data.injector.module

import android.app.Application
import dagger.Module
import dagger.Provides
import uk.co.mali.data.injector.scope.AppScope

/**
 * Created by alig2 on 14/08/2017.
 */
@Module
class AppModule(private var application:Application) {


    @AppScope
    @Provides
    fun provideAppContext():Application{
        return application
    }



}
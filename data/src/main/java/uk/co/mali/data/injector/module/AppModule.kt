package uk.co.mali.data.injector.module

import android.content.Context
import dagger.Module
import dagger.Provides
import uk.co.mali.data.injector.scope.AppScope

/**
 * Created by alig2 on 14/08/2017.
 */

@Module
class AppModule(private val context: Context) {


    @AppScope
    @Provides
    fun provideAppContext(): Context {
        return context
    }



}
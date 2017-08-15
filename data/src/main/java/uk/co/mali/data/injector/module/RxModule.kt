package uk.co.mali.data.injector.module

import dagger.Module
import dagger.Provides
import uk.co.mali.data.util.scheduler.IRxSchedulers
import uk.co.mali.data.util.scheduler.RxSchedulers

/**
 * Created by alig2 on 15/08/2017.
 */
@Module
class RxModule {

    @Provides
    fun provideIRxSchedulers(): IRxSchedulers {
        return RxSchedulers

    }
}

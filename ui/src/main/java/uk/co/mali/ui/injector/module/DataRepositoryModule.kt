package uk.co.mali.ui.injector.module

import dagger.Module
import dagger.Provides
import uk.co.mali.data.injector.repository.DataRepository
import uk.co.mali.ui.injector.scope.DataScope

/**
 * Created by alig2 on 15/08/2017.
 */
@Module
class DataRepositoryModule {

    @DataScope
    @Provides
    fun provideDataRepository():DataRepository{
        return DataRepository()
    }

}
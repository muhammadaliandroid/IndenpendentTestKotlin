package uk.co.mali.data.injector.repository

import io.reactivex.Observable
import uk.co.mali.data.IndependentApplication
import uk.co.mali.data.util.scheduler.IRxSchedulers
import uk.co.mali.independenttest.model.api.RestApi
import uk.co.mali.independenttest.model.pojo.kotlin.Data
import javax.inject.Inject

/**
 * Created by alig2 on 15/08/2017.
 */

class DataRepository(){

    @Inject lateinit var iRxSchedulers : IRxSchedulers
    @Inject lateinit var restApi: RestApi
    init {
        IndependentApplication.appComponent.inject(this)
    }

    fun getDataObservable(): Observable<Data> {

        return restApi.getHomePageRestData()


    }


}
package uk.co.mali.independenttest.model.api

import io.reactivex.Observable
import retrofit2.http.GET
import uk.co.mali.independenttest.model.constants.Constants
import uk.co.mali.independenttest.model.pojo.kotlin.Data

/**
 * Created by alig2 on 12/08/2017.
 */
interface RestApi {

    @GET(Constants.Constants.URL_BASE_HOME)
    fun getHomePageRestData(): Observable<Data>

}
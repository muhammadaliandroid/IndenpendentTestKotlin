package uk.co.mali.data.injector.module

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import uk.co.mali.data.injector.scope.AppScope
import uk.co.mali.independenttest.model.api.RestApi
import uk.co.mali.independenttest.model.constants.Constants

/**
 * Created by alig2 on 15/08/2017.
 */
@Module
class RestApiServiceModule{

    @AppScope
    @Provides
    fun provideRestApiService(client:OkHttpClient, gson: GsonConverterFactory, rxAdapter: RxJava2CallAdapterFactory): RestApi{
        var retrofit: Retrofit = Retrofit.Builder().client(client).baseUrl(Constants.Constants.URL_BASE).addConverterFactory(gson).addCallAdapterFactory(rxAdapter).build()

        return retrofit.create(RestApi::class.java)

    }
}
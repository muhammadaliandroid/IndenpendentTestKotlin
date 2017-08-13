package uk.co.mali.independenttest.views.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import uk.co.mali.independenttest.model.api.RestApi
import uk.co.mali.independenttest.model.constants.Constants
import uk.co.mali.independenttest.model.pojo.kotlin.Data

/**
 * Created by alig2 on 12/08/2017.
 */
class RestTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var service: Retrofit = restService()

        var restService: RestApi = service.create(RestApi::class.java)

        var dataObservable: Observable<Data> = restService.getHomePageRestData()


        var subscribeOn = dataObservable
                        .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object:DisposableObserver<Data>(){
                    override fun onNext(t: Data) {
                        System.out.println("Data Arrived: "+t.toString())
                    }

                    override fun onError(e: Throwable) {

                        System.out.println("Error: "+ e.message)
                    }

                    override fun onComplete() {
                        System.out.println("Completed")

                    }
                })



    }

    fun restService(): Retrofit{

        System.out.println("Retrofit Object Creation");

            val gson = GsonBuilder()
                    .setLenient()
                    .create()

            val retrofit = Retrofit.Builder()
                    .client(OkHttpClient())
                    .baseUrl(Constants.Constants.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

            return retrofit

    }
}



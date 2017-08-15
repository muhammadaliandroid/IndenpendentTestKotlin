package uk.co.mali.ui.presenter

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import uk.co.mali.data.IndependentApplication
import uk.co.mali.data.injector.component.DaggerDataRespositoryComponent
import uk.co.mali.data.injector.module.DataRepositoryModule
import uk.co.mali.data.injector.repository.DataRepository
import uk.co.mali.independenttest.model.pojo.kotlin.Data
import javax.inject.Inject

/**
 * Created by alig2 on 15/08/2017.
 */
class Presenter {

    @Inject lateinit var dataRepository : DataRepository

    init {
                DaggerDataRespositoryComponent.builder()
                .appComponent(IndependentApplication.IndependentApplication.appComponent)
                .dataRepositoryModule(DataRepositoryModule()).build()
                .inject(dataRepository)

    }


    fun initializeDataList() {

       var dataObservable: Observable<Data>?= dataRepository.getDataObservable()

        var subscribeOn = dataObservable?.subscribeOn(Schedulers.newThread())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(object: DisposableObserver<Data>(){
                    override fun onNext(t: Data) {
                        println("Presenter: onNext() Data Arrived: "+t.toString())
                    }

                    override fun onError(e: Throwable) {

                        println("Presenter: Error: "+ e.message)
                    }

                    override fun onComplete() {
                       println("Presenter: Completed")

                    }
                })



    }

}
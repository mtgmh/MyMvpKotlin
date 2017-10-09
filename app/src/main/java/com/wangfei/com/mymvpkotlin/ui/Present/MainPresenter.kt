package com.wangfei.com.mymvpkotlin.ui.Present

import com.wangfei.com.mymvpkotlin.data.source.DataManager
import com.wangfei.com.mymvpkotlin.ui.Model.MainViews
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by asus on 2017/9/25.
 */
class MainPresenter(val views: MainViews, val dataManager: DataManager){
    fun getUsers(key:String){
        dataManager.getUsers(key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { views.startLoading() }
                .doOnError { views.stopLoading() }
                .subscribe{views.showUsers(it)}

    }
}
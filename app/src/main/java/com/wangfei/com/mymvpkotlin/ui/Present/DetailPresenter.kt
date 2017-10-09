package com.wangfei.com.mymvpkotlin.ui.Present
import com.wangfei.com.mymvpkotlin.data.source.DataManager
import com.wangfei.com.mymvpkotlin.ui.Model.DetailViews
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * 小飞鸟 版权所有
 */
class DetailPresenter(val views: DetailViews, val dataManager: DataManager){

    fun getRepos(path:String){
        dataManager.getRepos(path).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { views.startLoading() }
                .doOnError { views.stopLoading() }
                .subscribe { views.showRepo(it) }
    }
}
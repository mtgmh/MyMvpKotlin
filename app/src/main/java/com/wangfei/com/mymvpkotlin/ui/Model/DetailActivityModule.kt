package com.wangfei.com.mymvpkotlin.ui.Model

import com.dongnao.kotlindy.ui.main.DetailAdapter
import com.wangfei.com.mymvpkotlin.data.source.DataManager
import com.wangfei.com.mymvpkotlin.ui.ActivityScope
import com.wangfei.com.mymvpkotlin.ui.Present.DetailPresenter
import com.wangfei.com.mymvpkotlin.ui.View.DetailActivity
import dagger.Module
import dagger.Provides

/**
 * 小飞鸟 版权所有
 */
@Module
class DetailActivityModule(val views: DetailActivity){

    @ActivityScope
    @Provides
    fun provideAdapter():DetailAdapter{
        return DetailAdapter(views)
    }

    @ActivityScope
    @Provides
    fun providePresenter(dataManager: DataManager): DetailPresenter {
        return DetailPresenter(views, dataManager)
    }
}
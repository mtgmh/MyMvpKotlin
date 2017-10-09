package com.wangfei.com.mymvpkotlin.ui.Model

import com.wangfei.com.mymvpkotlin.data.source.DataManager
import com.wangfei.com.mymvpkotlin.ui.ActivityScope
import com.wangfei.com.mymvpkotlin.ui.Present.MainPresenter
import com.wangfei.com.mymvpkotlin.ui.View.Adapter.MainAdapter
import com.wangfei.com.mymvpkotlin.ui.View.MainActivity
import dagger.Module
import dagger.Provides

/**
 * 小飞鸟 版权所有
 */
@Module
class MainActivityModule(val view: MainActivity){
    @ActivityScope
    @Provides
    fun providePresenter(dataManager: DataManager): MainPresenter {
        return MainPresenter(view, dataManager)
    }
    @ActivityScope
    @Provides
    fun provideAdapter(): MainAdapter {
        return MainAdapter(view)
    }
}
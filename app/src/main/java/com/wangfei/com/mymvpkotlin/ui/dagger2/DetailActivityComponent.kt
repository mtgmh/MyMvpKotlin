package com.wangfei.com.mymvpkotlin.ui.dagger2

import com.wangfei.com.mymvpkotlin.AppComponent
import com.wangfei.com.mymvpkotlin.ui.ActivityScope
import com.wangfei.com.mymvpkotlin.ui.View.DetailActivity
import com.wangfei.com.mymvpkotlin.ui.Model.DetailActivityModule
import dagger.Component

/**
 * 小飞鸟 版权所有
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),modules = arrayOf(DetailActivityModule::class) )
interface DetailActivityComponent {
    fun inject(activity: DetailActivity)
}
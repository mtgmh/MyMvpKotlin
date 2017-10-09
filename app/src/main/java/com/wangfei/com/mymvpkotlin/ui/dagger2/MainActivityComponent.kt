package com.wangfei.com.mymvpkotlin.ui.dagger2

import com.wangfei.com.mymvpkotlin.AppComponent
import com.wangfei.com.mymvpkotlin.ui.ActivityScope
import com.wangfei.com.mymvpkotlin.ui.View.MainActivity
import com.wangfei.com.mymvpkotlin.ui.Model.MainActivityModule
import dagger.Component

/**
 * 小飞鸟 版权所有
 */
@ActivityScope
@Component(modules = arrayOf(MainActivityModule::class),dependencies = arrayOf(AppComponent::class))
interface MainActivityComponent{
fun inject(activity: MainActivity)
}
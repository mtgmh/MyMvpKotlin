package com.wangfei.com.mymvpkotlin

import android.app.Application
import com.wangfei.com.mymvpkotlin.data.source.DataSourceModule

/**
 * 小飞鸟 版权所有
 */
class MyApplication:Application(){

    /**
     * 提供全局注入器的获得
     */
    lateinit  private var appComponent:AppComponent
    companion object {//kotlin 创建单例模式 用半生函数
        lateinit private var app:MyApplication
        fun getApplication():MyApplication{
            return app
        }

    }

    override fun onCreate() {
        super.onCreate()
        app=this
        appComponent = DaggerAppComponent.builder().dataSourceModule(DataSourceModule()).build()

    }

    fun getAppComponent():AppComponent = appComponent

}
package com.wangfei.com.mymvpkotlin

import com.wangfei.com.mymvpkotlin.data.source.DataManager
import com.wangfei.com.mymvpkotlin.data.source.DataSourceModule
import dagger.Component
import javax.inject.Singleton

/**
 * 小飞鸟 版权所有
 */
/**
 * 注入器
 */
@Singleton
@Component(modules = arrayOf(DataSourceModule::class)) //注入器的对象提供工厂
interface AppComponent{
    /**
     * 全局注入器能够提供的对象
     */
    fun dataManager(): DataManager
}
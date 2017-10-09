package com.wangfei.com.mymvpkotlin.data.source

import com.wangfei.com.mymvpkotlin.api.GithubService
import com.wangfei.com.mymvpkotlin.data.BASE_URL
import com.wangfei.com.mymvpkotlin.data.source.local.Local
import com.wangfei.com.mymvpkotlin.data.source.local.LocalDataSource
import com.wangfei.com.mymvpkotlin.data.source.remote.Remote
import com.wangfei.com.mymvpkotlin.data.source.remote.RemoteDataSoutce
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/**
 * 小飞鸟 版权所有
 */
@Module
class DataSourceModule {
    @Singleton
    @Provides
    fun provideGitHubService():GithubService{
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL).build().create(GithubService::class.java)
    }

    // @Named("11")
    @Singleton
    @Remote
    @Provides
    fun provideRemote(service: GithubService): IDataSource {
        return RemoteDataSoutce(service)
    }
    @Singleton
    @Local
    @Provides
    fun provideLocal(): IDataSource {
        return LocalDataSource()

    }
    @Singleton
    @Provides
    fun provideDataManager(@Remote remote: IDataSource, @Local local: IDataSource): DataManager {
        return DataManager(remote, local)
    }
}
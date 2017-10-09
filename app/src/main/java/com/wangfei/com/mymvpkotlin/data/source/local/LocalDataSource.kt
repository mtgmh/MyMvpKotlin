package com.wangfei.com.mymvpkotlin.data.source.local

import com.wangfei.com.mymvpkotlin.data.Repo
import com.wangfei.com.mymvpkotlin.data.Users
import com.wangfei.com.mymvpkotlin.data.source.IDataSource
import io.reactivex.Flowable

/**
* 小飞鸟 版权所有
*/
class LocalDataSource:IDataSource{
    override fun getUsers(key: String): Flowable<Users> {
        return Flowable.just(Users(arrayListOf()))
    }
    override fun getRepos(path: String): Flowable<List<Repo>> {
        return Flowable.just(arrayListOf())
    }
}
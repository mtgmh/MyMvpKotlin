package com.wangfei.com.mymvpkotlin.data.source.remote

import com.wangfei.com.mymvpkotlin.data.Users
import com.wangfei.com.mymvpkotlin.data.source.IDataSource
import com.wangfei.com.mymvpkotlin.api.GithubService
import com.wangfei.com.mymvpkotlin.data.Repo
import io.reactivex.Flowable

/**
* 小飞鸟 版权所有
*/
class RemoteDataSoutce(val service:GithubService):IDataSource{
    override fun getUsers(key: String): Flowable<Users> =service.getUsers(key)
    override fun getRepos(path: String): Flowable<List<Repo>> = service.getRepos(path)
}
package com.wangfei.com.mymvpkotlin.data.source

import com.wangfei.com.mymvpkotlin.data.Repo
import com.wangfei.com.mymvpkotlin.data.User
import io.reactivex.Flowable

/**
 * Created by asus on 2017/9/25.
 */
class DataManager(val remote: IDataSource, val local: IDataSource){

    fun getUsers(key:String):Flowable<List<User>>{

        return remote.getUsers(key).onErrorResumeNext (local.getUsers(key)).map { it.items }
    }
    fun getRepos(path:String): Flowable<List<Repo>> {
        return remote.getRepos(path).onErrorResumeNext(local.getRepos(path))
    }
}
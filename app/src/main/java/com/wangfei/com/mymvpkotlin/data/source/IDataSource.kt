package com.wangfei.com.mymvpkotlin.data.source

import com.wangfei.com.mymvpkotlin.data.Repo
import com.wangfei.com.mymvpkotlin.data.Users
import io.reactivex.Flowable

/**
 * Created by asus on 2017/9/25.
 */
interface IDataSource{
    fun getUsers(key:String): Flowable<Users>

    fun getRepos(path:String):Flowable<List<Repo>>

}
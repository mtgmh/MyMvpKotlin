package com.wangfei.com.mymvpkotlin.api

import com.wangfei.com.mymvpkotlin.data.Repo
import com.wangfei.com.mymvpkotlin.data.Users
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

/**
 * 小飞鸟 版权所有
 */
interface GithubService{
    @GET("search/users")
    fun getUsers(@Query("q")key:String):Flowable<Users>
    @GET
    fun getRepos(@Url path:String):Flowable<List<Repo>>
}
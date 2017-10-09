package com.wangfei.com.mymvpkotlin.ui.Model

import com.wangfei.com.mymvpkotlin.data.Repo
import com.wangfei.com.mymvpkotlin.ui.IViews

/**
 * 小飞鸟 版权所有
 */
interface DetailViews:IViews{
    fun showRepo(repos:List<Repo>)
}
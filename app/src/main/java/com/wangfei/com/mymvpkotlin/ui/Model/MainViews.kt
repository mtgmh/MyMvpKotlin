package com.wangfei.com.mymvpkotlin.ui.Model

import com.wangfei.com.mymvpkotlin.data.User
import com.wangfei.com.mymvpkotlin.ui.IViews

/**
 * 小飞鸟 版权所有
 */
interface MainViews: IViews {
    fun showUsers(users:List<User>)
}
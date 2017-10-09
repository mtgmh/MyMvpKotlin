package com.wangfei.com.mymvpkotlin.data.source.local

import javax.inject.Qualifier

/**
 * 小飞鸟 版权所有
 */
/**
 * 限定符，
 * 当出现多个provide方法返回同样的类型的对象的时候，
 * 在需要由dagger2来注入对象的地方不知道该使用哪个provide方法
 * 这时候使用相同限定符声明的对象与提供对象的方法就可以了
 */
@Qualifier
annotation class Local
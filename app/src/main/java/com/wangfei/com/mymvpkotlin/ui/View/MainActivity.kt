package com.wangfei.com.mymvpkotlin.ui.View

import android.support.v7.widget.LinearLayoutManager
import com.wangfei.com.mymvpkotlin.AppComponent
import com.wangfei.com.mymvpkotlin.BaseActivity
import com.wangfei.com.mymvpkotlin.R
import com.wangfei.com.mymvpkotlin.data.User
import com.wangfei.com.mymvpkotlin.ui.Model.MainActivityModule
import com.wangfei.com.mymvpkotlin.ui.Model.MainViews
import com.wangfei.com.mymvpkotlin.ui.Present.MainPresenter
import com.wangfei.com.mymvpkotlin.ui.View.Adapter.MainAdapter
import com.wangfei.com.mymvpkotlin.ui.dagger2.DaggerMainActivityComponent
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk25.coroutines.onClick
import javax.inject.Inject

/**
 *  * Retrofit2+RxJava2+Dagger2 Mvp Kotlin项目
 *
 * Retrofit2 : restful url 网络请求库
 * RxJava2  ： 响应式函数编程库
 * Dagger2  ： 依赖注入库
 */
class MainActivity : BaseActivity(), MainViews, MainAdapter.OnItemClickListener {
    //需要注入的对象
    @Inject
    lateinit var persenter: MainPresenter
    @Inject
    lateinit var adapter: MainAdapter

    override fun attachLayoutId(): Int = R.layout.activity_main
    override fun initViews() {
        mainRecyclerView.layoutManager=LinearLayoutManager(this)
        mainRecyclerView.adapter=adapter
        adapter.onItemClick=this
        mainSearch.onClick {
            var key=mainEdit.text.toString()
            persenter.getUsers(key)//获取数据
        }
    }
    override fun onItemClick(user: User) {
        startActivity(intentFor<DetailActivity>("user" to user))

    }

    override fun showUsers(users: List<User>) {
        stopLoading()
        adapter.notifyDataSetChanged(users)
    }
    /**
     * 初始化dagger2注入器
     */
    override fun setUpComponent(appComponent: AppComponent) {
        DaggerMainActivityComponent.builder()
                .appComponent(appComponent)
                .mainActivityModule(MainActivityModule(this))
                .build()
                .inject(this)
    }

}

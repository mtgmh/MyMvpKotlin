package com.wangfei.com.mymvpkotlin.ui.View

import android.support.v7.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.dongnao.kotlindy.ui.main.DetailAdapter
import com.wangfei.com.mymvpkotlin.AppComponent
import com.wangfei.com.mymvpkotlin.BaseActivity
import com.wangfei.com.mymvpkotlin.R
import com.wangfei.com.mymvpkotlin.data.Repo
import com.wangfei.com.mymvpkotlin.data.User
import com.wangfei.com.mymvpkotlin.ui.Model.DetailActivityModule
import com.wangfei.com.mymvpkotlin.ui.Model.DetailViews
import com.wangfei.com.mymvpkotlin.ui.Present.DetailPresenter
import com.wangfei.com.mymvpkotlin.ui.dagger2.DaggerDetailActivityComponent

import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailActivity : BaseActivity(), DetailViews {

    @Inject
    lateinit var presenter: DetailPresenter
    @Inject
    lateinit var adapter: DetailAdapter

    override fun attachLayoutId(): Int = R.layout.activity_detail

    override fun initViews() {
        val user = intent.getParcelableExtra<User>("user")
        Glide.with(this).load(user.avatar_url).into(detail_avatar)
        detail_name.text = user.name
        detailRecyclerView.layoutManager = LinearLayoutManager(this)
        detailRecyclerView.adapter = adapter
        presenter.getRepos(user.repos_url)
    }

    override fun showRepo(repos: List<Repo>) {
        stopLoading()
        adapter.notifyDataSetChanged(repos)
    }

    override fun setUpComponent(appComponent: AppComponent) {
        DaggerDetailActivityComponent.builder().appComponent(appComponent)
                .detailActivityModule(DetailActivityModule(this)).build().inject(this)
    }

}

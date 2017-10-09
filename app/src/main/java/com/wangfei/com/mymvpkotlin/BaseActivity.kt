package com.wangfei.com.mymvpkotlin

import android.app.ProgressDialog
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.indeterminateProgressDialog

/**
 * Created by asus on 2017/9/25.
 */
abstract class BaseActivity:AppCompatActivity(){
    var progressDialog:ProgressDialog?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(attachLayoutId())
        setUpComponent(MyApplication.getApplication().getAppComponent())
        initViews()
    }

    abstract fun attachLayoutId():Int
    abstract fun initViews()
    abstract fun setUpComponent(appComponent:AppComponent)
    open fun startLoading() {
        if(null===progressDialog){
            progressDialog=indeterminateProgressDialog ("正在加载...")

        }else{
            progressDialog?.show()
        }
    }

    open fun stopLoading() {
        progressDialog?.dismiss()
    }

    override fun onDestroy() {
        super.onDestroy()
        progressDialog?.dismiss()
    }
}
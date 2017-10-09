package com.wangfei.com.mymvpkotlin.ui.View.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.wangfei.com.mymvpkotlin.R
import com.wangfei.com.mymvpkotlin.data.User
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * 小飞鸟 版权所有
 */

class MainAdapter(val ctx: Context) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private val data: ArrayList<User> = arrayListOf()

    var onItemClick : OnItemClickListener? = null
        set(value)  {
            field = value
        }

    override fun getItemCount(): Int = data.size

    fun notifyDataSetChanged(users: List<User>) {
        data.clear()
        data.addAll(users)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val itemView = android.view.LayoutInflater.from(ctx).inflate(R.layout.adapter_user_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val user = data[position]
        Glide.with(ctx).load(user.avatar_url).into(holder?.user_avatar)
        holder?.user_name?.text = user.name
        holder?.user_scope?.text = "${user.score}"
        holder?.user_home?.text = user.html_url
        holder?.itemView?.onClick {
            onItemClick?.onItemClick(user)
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val user_avatar: ImageView = itemView.find(R.id.user_avatar)
        val user_name: TextView = itemView.find(R.id.user_name)
        val user_scope: TextView = itemView.find(R.id.user_scope)
        val user_home: TextView = itemView.find(R.id.user_home)

    }

    interface OnItemClickListener{

        fun onItemClick(user: User)
    }


}
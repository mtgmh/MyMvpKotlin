package com.dongnao.kotlindy.ui.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.wangfei.com.mymvpkotlin.R
import com.wangfei.com.mymvpkotlin.data.Repo
import org.jetbrains.anko.find

/**
 *
 *
 */


class DetailAdapter(val ctx: Context) : RecyclerView.Adapter<DetailAdapter.ViewHolder>() {


    private val data: ArrayList<Repo> = arrayListOf()


    fun notifyDataSetChanged(repos: List<Repo>) {
        data.clear()
        data.addAll(repos)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(ctx).inflate(R.layout.adapter_repo_item, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val repo = data[position]
        holder?.repo_name?.text = repo.name
        holder?.repo_description?.text = repo.description
        holder?.repo_starts?.text = "${repo.stargazers}"
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val repo_name: TextView = itemView.find(R.id.repo_name)
        val repo_description: TextView = itemView.find(R.id.repo_description)
        val repo_starts: TextView = itemView.find(R.id.repo_starts)
    }

}
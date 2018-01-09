package com.example.framgiatongxuanan.viblo_kolin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.framgiatongxuanan.viblo_kolin.R
import com.example.framgiatongxuanan.viblo_kolin.data.local.AndroidVersion
import kotlinx.android.synthetic.main.item_android_version.view.*

/**
 * Created by FRAMGIA\tong.xuan.an on 08/01/2018.
 */
class AndroidVersionAdapter(private val androidVersionList: List<AndroidVersion>) : RecyclerView.Adapter<AndroidVersionAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_android_version, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = androidVersionList.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(androidVersionList[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(android: AndroidVersion) {
            itemView.tv_name.text = android.name
            itemView.tv_version.text = android.ver
            itemView.tv_api_level.text = android.api

        }
    }
}
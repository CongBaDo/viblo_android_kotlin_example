package com.example.framgiatongxuanan.viblokolin.features.sharedata.master

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.framgiatongxuanan.viblokolin.base.BaseSelectionListAdapter
import com.example.framgiatongxuanan.viblokolin.features.sharedata.master.MasterAdapter.ItemViewHolder


/**
 * Created by FRAMGIA\tong.xuan.an on 18/01/2018.
 */
class MasterAdapter(private val mContext: Context, private val listener: (Int, String) -> Unit)
    : BaseSelectionListAdapter<String, ItemViewHolder>(listener) {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ItemViewHolder {
        Log.e("onCreateViewHolder", "check")
        val view = LayoutInflater.from(parent?.context).inflate(android.R.layout.simple_list_item_1, parent, false);
        return ItemViewHolder(view, listener)
    }

    inner class ItemViewHolder(view: View,
                               itemClickListener: (Int, String) -> Unit) : BaseRecyclerViewHolder<String>(view,
            itemClickListener) {
        override fun bind(model: String, isSelected: Boolean) {
            with(itemView) {
                Log.e("sssItemViewHolder", "" + model)
                var txt1: TextView = itemView.findViewById(android.R.id.text1) as TextView
                txt1.text = model
            }

        }
    }
}
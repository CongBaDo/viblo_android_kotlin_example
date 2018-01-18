package com.example.framgiatongxuanan.viblokolin.features.sharedata.master

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.framgiatongxuanan.viblokolin.base.BaseSelectionListAdapter


/**
 * Created by FRAMGIA\tong.xuan.an on 18/01/2018.
 */
class MasterAdapter(private val mContext: Context, private val listener: (String) -> Unit) : BaseSelectionListAdapter<> {


    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView?.findViewById(android.R.id.text1) as TextView
        fun bind(name: String) {
            textView.text = name
        }
    }

    fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
        itemView.setOnClickListener {
            event.invoke(getAdapterPosition(), getItemViewType())
        }
        return this
    }

    inner class ItemViewHodel(view: View, itemClickListener: (Int, String) -> Unit)
        : BaseSelectionListAdapter.BaseRecyclerViewHolder<String>(view, itemClickListener) {

    }
}
package com.example.framgiatongxuanan.viblokolin.base

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View

/**
 * Created by ltquang on 11/9/17.
 */
abstract class BaseSelectionListAdapter<in T, VH>(
        private val mItemClickListener: (Int, String) -> Unit )
    : RecyclerView.Adapter<VH>() where VH : BaseSelectionListAdapter<T, VH>.BaseRecyclerViewHolder<T> {

    private val mDataSource = mutableListOf<T>()
    private var mCurrentPosition = NONE
    private var mOldPosition = NONE
    private var mIsFirstClicked: Boolean = false

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.fetchData(mDataSource[position], position == mCurrentPosition)
    }

    override fun getItemCount(): Int {
        Log.e("getItemCount: ",mDataSource.size.toString())
     return   mDataSource.size
    }

    fun updateData(dataSource: List<T>) {
        clearSelection()
        mDataSource.clear()
        mDataSource.addAll(dataSource)
        notifyDataSetChanged()
    }

    private fun updateByPosition() {
        if (mCurrentPosition > -1)
            notifyItemChanged(mCurrentPosition)
    }

    fun updateSelectedItem(position: Int) {
        updateByPosition()
        mCurrentPosition = position
        updateByPosition()
    }

    fun clearSelection() {
        mCurrentPosition = NONE
        mOldPosition = NONE
    }

    companion object {
        private val NONE = -1
    }

    inner abstract class BaseRecyclerViewHolder<in T>(
            v: View, private val itemClickListener: ((Int, T) -> Unit)? = null) : RecyclerView.ViewHolder(v) {

        abstract fun bind(model: T, isSelected: Boolean)

        fun fetchData(model: T, isSelected: Boolean) {
            bind(model, isSelected)
            itemView.setOnClickListener { itemClickListener?.invoke(adapterPosition, model) }
        }
    }
}

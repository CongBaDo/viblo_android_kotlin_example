package com.example.framgiatongxuanan.viblokolin.features.sharedata.master


import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.graphics.drawable.ClipDrawable.VERTICAL
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.framgiatongxuanan.viblokolin.R
import kotlinx.android.synthetic.main.activity_share_data.*
import kotlinx.android.synthetic.main.fragment_master.*

/**
 * Created by FRAMGIA\tong.xuan.an on 18/01/2018.
 */
class MasterFragment : Fragment(), LifecycleOwner {
    private var mViewModel: MasterViewModel? = null
    private val mAdapter: MasterAdapter by lazy {
        MasterAdapter(context, { positon, string ->
            mAdapter.updateSelectedItem(positon)
            mViewModel?.setSelectedItem(string)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProviders.of(activity).get(MasterViewModel::class.java)
        mViewModel!!.getData().observe(this, Observer<List<String>> { t ->
            t?.let { mAdapter?.updateData(it) }
        })
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_master, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        val dividerItemDecoration = DividerItemDecoration(recyclerview.context, VERTICAL)
        recyclerview.adapter = mAdapter
        recyclerview.addItemDecoration(dividerItemDecoration)
    }

}
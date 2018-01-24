package com.example.framgiatongxuanan.viblokolin.features.sharedata.master


import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.framgiatongxuanan.viblokolin.R
import kotlinx.android.synthetic.main.fragment_master.*

/**
 * Created by FRAMGIA\tong.xuan.an on 18/01/2018.
 */
class MasterFragment : Fragment(), LifecycleOwner {
    private var mViewModel: MasterViewModel? = null
    private val mAdapter: MasterAdapter by lazy {
        MasterAdapter(context, { position, string ->
            mAdapter.updateSelectedItem(position)
            mViewModel?.setSelectedItem(string)
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
        recyclerview.layoutManager = LinearLayoutManager(context)
//        val dividerItemDecoration = DividerItemDecoration(recyclerview.context, VERTICAL)
        recyclerview.adapter = mAdapter
        mViewModel = ViewModelProviders.of(activity).get(MasterViewModel::class.java)
        mViewModel?.getData()?.observe(this, Observer<List<String>> { t ->
            t?.also {
                Log.e("updateData", "" + t.size)
                mAdapter?.updateData(it)
            }
        })
        //  recyclerview.addItemDecoration(dividerItemDecoration)
    }

}
package com.example.framgiatongxuanan.viblokolin.features.sharedata.detail

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.framgiatongxuanan.viblokolin.R
import com.example.framgiatongxuanan.viblokolin.features.sharedata.master.MasterViewModel
import kotlinx.android.synthetic.main.activity_share_data.*
import kotlinx.android.synthetic.main.fragment_detail.*

/**
 * Created by FRAMGIA\tong.xuan.an on 19/01/2018.
 */
class DetailFragment : Fragment(), LifecycleOwner {
    lateinit var mViewModel: MasterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProviders.of(activity).get(MasterViewModel::class.java)
        mViewModel.getSelectedItem().observe(this, Observer<String> { item ->
            text_user_name.text = item
        })
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_detail, container, false)
    }
}
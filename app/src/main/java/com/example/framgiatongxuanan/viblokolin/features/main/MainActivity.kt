package com.example.framgiatongxuanan.viblokolin.features.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.framgiatongxuanan.viblokolin.R
import com.example.framgiatongxuanan.viblokolin.data.local.AndroidVersion
import com.example.framgiatongxuanan.viblokolin.features.androidversion.ListAndroidVersionActivity
import com.example.framgiatongxuanan.viblokolin.features.countnumber.CountNumberActivity
import com.example.framgiatongxuanan.viblokolin.features.sharedata.ShareDataActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by FRAMGIA\tong.xuan.an on 19/01/2018.
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        btnAndroidVersion.setOnClickListener(this)
        btnCountNumber.setOnClickListener(this)
        btnShareData.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btnAndroidVersion -> {
                startActivity(Intent(this, ListAndroidVersionActivity::class.java))
            }
            R.id.btnCountNumber -> {
                startActivity(Intent(this, CountNumberActivity::class.java))
            }
            R.id.btnShareData -> {
                startActivity(Intent(this, ShareDataActivity::class.java))
            }
        }
    }

}
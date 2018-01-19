package com.example.framgiatongxuanan.viblokolin.features.sharedata


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.framgiatongxuanan.viblokolin.R
import com.example.framgiatongxuanan.viblokolin.features.sharedata.detail.DetailFragment
import com.example.framgiatongxuanan.viblokolin.features.sharedata.master.MasterFragment
import kotlinx.android.synthetic.main.activity_share_data.*

/**
 * Created by FRAMGIA\tong.xuan.an on 19/01/2018.
 */
class ShareDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_data)
//        supportFragmentManager.beginTransaction().replace(R.id.fragment_master, MasterFragment(), "master").commit()
//        supportFragmentManager.beginTransaction().replace(R.id.fragment_detail, DetailFragment(), "detail").commit()
    }
}
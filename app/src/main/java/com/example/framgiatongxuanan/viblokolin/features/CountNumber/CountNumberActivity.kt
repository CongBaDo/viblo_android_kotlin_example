package com.example.framgiatongxuanan.viblokolin.features.CountNumber

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.example.framgiatongxuanan.viblokolin.R
import kotlinx.android.synthetic.main.count_number.*

/**
 * Created by FRAMGIA\tong.xuan.an on 15/01/2018.
 */
class CountNumberActivity : AppCompatActivity(), LifecycleOwner, View.OnClickListener {

    private lateinit var mCountNumberViewModel: CountNumberViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.count_number)
        initView()
        mCountNumberViewModel = ViewModelProviders.of(this).get(CountNumberViewModel::class.java)
        registerLiveDataListenner()
    }

    private fun initView() {
        btnA3.setOnClickListener(this)
        btnA4.setOnClickListener(this)
        btnA5.setOnClickListener(this)
        btnB3.setOnClickListener(this)
        btnB4.setOnClickListener(this)
        btnB5.setOnClickListener(this)
    }

    private fun registerLiveDataListenner() {
        mCountNumberViewModel.getScoreTeamA().observe(this, Observer<Int> { integer ->
            txtCountA.text = integer.toString()
        })
        mCountNumberViewModel.getScoreTeamB().observe(this, Observer<Int> { integer ->
            txtCountB.text = integer.toString()
        })
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btnA3 -> {
                Log.e("mCountNumberViewModel", "btnClick")
                mCountNumberViewModel.increaseScoreTeamA(3)

            }
            R.id.btnA4 -> {
                mCountNumberViewModel.increaseScoreTeamA(4)

            }
            R.id.btnA5 -> {
                mCountNumberViewModel.increaseScoreTeamA(5)

            }
            R.id.btnB3 -> {
                mCountNumberViewModel.increaseScoreTeamB(3)

            }
            R.id.btnB4 -> {
                mCountNumberViewModel.increaseScoreTeamB(4)

            }
            R.id.btnB5 -> {
                mCountNumberViewModel.increaseScoreTeamB(5)

            }
        }
    }
}
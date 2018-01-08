package com.example.framgiatongxuanan.viblo_kolin.features.rxjavaandretrofit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.framgiatongxuanan.viblo_kolin.ApiService
import com.example.framgiatongxuanan.viblo_kolin.R
import com.example.framgiatongxuanan.viblo_kolin.data.local.AndroidVersion
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by FRAMGIA\tong.xuan.an on 08/01/2018.
 */
class LAndroidVersionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestLogin()
    }

    private fun requestLogin() {
        Repository.createService(ApiService::class.java).androidVersion()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ result ->
                    run {
                        result.forEach { android: AndroidVersion -> Log.e("android: ", "" + android.toString()) }
                    }
                }, { error ->
                    run {
                        Log.e("requestLogin", "" + error.toString())
                    }
                })
    }
}
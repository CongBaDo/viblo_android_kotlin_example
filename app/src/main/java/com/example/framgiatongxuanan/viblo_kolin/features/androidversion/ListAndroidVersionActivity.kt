package com.example.framgiatongxuanan.viblo_kolin.features.androidversion

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.example.framgiatongxuanan.viblo_kolin.ApiService
import com.example.framgiatongxuanan.viblo_kolin.R
import com.example.framgiatongxuanan.viblo_kolin.adapter.AndroidVersionAdapter
import com.example.framgiatongxuanan.viblo_kolin.data.local.AndroidVersion
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_android_version.*

/**
 * Created by FRAMGIA\tong.xuan.an on 08/01/2018.
 */
class ListAndroidVersionActivity : AppCompatActivity() {
    private val TAG = ListAndroidVersionActivity::class.java.simpleName
    private var mCompositeDisposable: CompositeDisposable? = null
    private var mAdapter: AndroidVersionAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_version)
        mCompositeDisposable = CompositeDisposable()
        initRecyclerView()
        requestLogin()
    }

    private fun initRecyclerView() {
        rv_android_list.setHasFixedSize(true)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        rv_android_list.layoutManager = layoutManager
    }

    private fun requestLogin() {
        Repository.createService(ApiService::class.java).getAndroidVersion()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ result ->
                    handleSuccessAndroidVersion(result)
                }, { error ->
                    handlerErrorAndroidVersion(error)
                })
    }

    private fun handleSuccessAndroidVersion(result: List<AndroidVersion>) {
        mAdapter = AndroidVersionAdapter(result)
        rv_android_list.adapter = mAdapter
    }

    private fun handlerErrorAndroidVersion(error: Throwable) {
        Log.e(TAG, "handlerErrorAndroidVersion: ${error.localizedMessage}")
        Toast.makeText(this, "Error ${error.localizedMessage}", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        mCompositeDisposable?.clear()
    }
}
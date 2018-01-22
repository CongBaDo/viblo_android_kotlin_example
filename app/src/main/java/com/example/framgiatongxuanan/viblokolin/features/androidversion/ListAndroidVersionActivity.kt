package com.example.framgiatongxuanan.viblokolin.features.androidversion

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.example.framgiatongxuanan.viblokolin.ApiService
import com.example.framgiatongxuanan.viblokolin.R
import com.example.framgiatongxuanan.viblokolin.adapter.AndroidVersionAdapter
import com.example.framgiatongxuanan.viblokolin.data.local.AndroidVersion
import com.example.framgiatongxuanan.viblokolin.features.countnumber.CountNumberActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_android_version.*

/**
 * Created by FRAMGIA\tong.xuan.an on 08/01/2018.
 */
class ListAndroidVersionActivity : AppCompatActivity() {
    private val TAG = ListAndroidVersionActivity::class.java.simpleName
    private var mAdapter: AndroidVersionAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_version)
        initRecyclerView()
        requestAndroidVersion()
        handlerBtnClick()
    }

    // khởi tao recyclerview
    private fun initRecyclerView() {
        rv_android_list.setHasFixedSize(true)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        rv_android_list.layoutManager = layoutManager
    }

    // request data tu server
    private fun requestAndroidVersion() {
        Repository.createService(ApiService::class.java).getAndroidVersion()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        //cú pháp của rxjava trong kotlin
                        { result ->
                            //request thành công
                            handleSuccessAndroidVersion(result)
                        },
                        { error ->
                            //request thất bai
                            handlerErrorAndroidVersion(error)
                        }
                )
    }

    //Xử lí dữ liệu khi request thành công
    private fun handleSuccessAndroidVersion(result: List<AndroidVersion>) {
        mAdapter = AndroidVersionAdapter(result)
        rv_android_list.adapter = mAdapter
    }

    //Xử lí dữ l request thất bại
    private fun handlerErrorAndroidVersion(error: Throwable) {
        Log.e(TAG, "handlerErrorAndroidVersion: ${error.localizedMessage}")
        Toast.makeText(this, "Error ${error.localizedMessage}", Toast.LENGTH_SHORT).show()
    }

    //btn click
    fun handlerBtnClick() {
        button.setOnClickListener {
            startActivity(Intent(this, CountNumberActivity::class.java))
        }
    }
}
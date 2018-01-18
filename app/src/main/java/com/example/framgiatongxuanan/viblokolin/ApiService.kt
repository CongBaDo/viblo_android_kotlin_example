package com.example.framgiatongxuanan.viblokolin

import com.example.framgiatongxuanan.viblokolin.data.local.AndroidVersion
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by FRAMGIA\tong.xuan.an on 08/01/2018.
 */
interface ApiService {
    @GET("android/jsonarray/")
    fun getAndroidVersion(): Observable<List<AndroidVersion>>
}
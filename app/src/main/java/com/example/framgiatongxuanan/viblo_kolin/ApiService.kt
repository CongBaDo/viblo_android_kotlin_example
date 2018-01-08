package com.example.framgiatongxuanan.viblo_kolin

import com.example.framgiatongxuanan.viblo_kolin.data.local.AndroidVersion
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by FRAMGIA\tong.xuan.an on 08/01/2018.
 */
interface ApiService {
    @GET("android/jsonarray/")
    fun androidVersion(): Observable<List<AndroidVersion>>
}
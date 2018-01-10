package com.example.framgiatongxuanan.viblo_kolin.features.androidversion

/**
 * Created by FRAMGIA\tong.xuan.an on 08/01/2018.
 */
import com.example.framgiatongxuanan.viblo_kolin.Constants
import okhttp3.Interceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.Response

class Repository {
    companion object {
        private var retrofit: Retrofit? = null
        private var builder: Retrofit.Builder = Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        private val httpClient = OkHttpClient.Builder()
        fun <S> createService(serviceClass: Class<S>): S {
            return createService(serviceClass, null)
        }

        fun <S> createService(serviceClass: Class<S>, authToken: Map<String, String>?): S {
            if (authToken != null) {
                var interceptor = AuthenticationInterceptor(authToken!!)
                if (!httpClient.interceptors().contains(interceptor)) {
                    httpClient.addInterceptor(interceptor)
                    builder.client(httpClient.build())
                    retrofit = builder.build()
                }
            }
            retrofit = builder.build()
            return retrofit!!.create(serviceClass)
        }

    }

    //định nghĩa headers của request nếu có
    class AuthenticationInterceptor(private val authToken: Map<String, String>) : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val original = chain.request()
            val builder = original.newBuilder()
            for (key in authToken.keys) {
                builder.header(key, authToken.getValue(key))
            }
            val request = builder.build()
            return chain.proceed(request)
        }
    }

}
package com.example.framgiatongxuanan.viblokolin.features.countnumber

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData

/**
 * Created by FRAMGIA\tong.xuan.an on 15/01/2018.
 */
class CountNumberViewModel(application: Application) : AndroidViewModel(application) {
    private val mScoreTeamA = MutableLiveData<Int>()
    private val mScoreTeamB = MutableLiveData<Int>()

    init {
        mScoreTeamA.value = 0
        mScoreTeamB.value = 0
    }

    fun increaseScoreTeamA(score: Int) {
        mScoreTeamA.value = mScoreTeamA.value?.plus(score)
    }

    fun increaseScoreTeamB(score: Int) {
        mScoreTeamB.value = mScoreTeamB.value?.plus(score)
    }

    fun getScoreTeamA(): MutableLiveData<Int> {
        return mScoreTeamA
    }

    fun getScoreTeamB(): MutableLiveData<Int> {
        return mScoreTeamB
    }
}
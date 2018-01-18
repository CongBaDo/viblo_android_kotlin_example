package com.example.framgiatongxuanan.viblokolin.features.sharedata.master

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData

/**
 * Created by FRAMGIA\tong.xuan.an on 18/01/2018.
 */
public class MasterViewModel(application: Application) : AndroidViewModel(application) {
    private val mData = MutableLiveData<List<String>>()
    private val mSelectedItem = MutableLiveData<String>()
    fun getData(): MutableLiveData<List<String>> {
        return mData
    }
    fun initData():List<String>{
        var result=ArrayList<String>()
        result.add("Susanna Mcmillian")
        result.add("Cheryl Stockman")
        result.add("Jesus Pitts")
        result.add("Shirly Grado")
        result.add("Stevie Kucera")
        result.add("Oneida Lafrance")
        result.add("Ashli Kenna")
        result.add("Madlyn Keasey")
        result.add("Sharonda Wisneski")
        result.add("Eliz Hildebrand")
        result.add("Tod Kellerhouse")
        result.add("Sung Farnan")
        result.add("Elenor Darrow")
        result.add("Max Garlick")
        result.add("Yolanda Digirolamo")
        result.add("Liane Scoby")
        result.add("Jed Hunger")
        result.add("Hilario Schreffler")
        result.add("Shanda Eadie")
        result.add("Londa Shelnutt")
        return  result
    }

    fun getSelectedItem(): MutableLiveData<String> {
        return mSelectedItem
    }

    fun setSelectedItem(selectedItem: String) {
        mSelectedItem.value = selectedItem
    }


}
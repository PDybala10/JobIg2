package com.ndesigne.jobig2


import android.widget.Button
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){


    val counter : MutableLiveData<Int> = MutableLiveData()

    init {
        counter.value = 0
    }

    fun OnclickButton() {

        counter.value = (counter.value?: 0) + 1
    }
}
package com.example.martin.viewmodel_livedataex

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val usd_to_can_rate =1.32f
    private var dollarText = ""
    private var result: MutableLiveData<Float> = MutableLiveData()

    fun setAmount(value: String) {
        this.dollarText = value
        result.setValue(value.toFloat() * usd_to_can_rate)
    }

        fun getResult(): MutableLiveData<Float> {
        return result
    }

}

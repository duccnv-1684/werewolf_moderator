package com.ducnguyen2102.werewolfmoderator.ui

import androidx.lifecycle.MutableLiveData
import com.ducnguyen2102.werewolfmoderator.base.BaseViewModel

class MainSharedViewModel : BaseViewModel() {
    val numberPlayers = MutableLiveData<Int>().apply { postValue(0) }
}
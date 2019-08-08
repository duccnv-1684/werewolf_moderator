package com.ducnguyen2102.werewolfmoderator.ui.gameplay

import androidx.lifecycle.MutableLiveData
import com.ducnguyen2102.werewolfmoderator.R
import com.ducnguyen2102.werewolfmoderator.base.BaseViewModel
import com.ducnguyen2102.werewolfmoderator.rx.SchedulerProvider

class GamePlayViewModel(
        private val schedulerProvider: SchedulerProvider
) : BaseViewModel() {
    val currentNight = MutableLiveData<Int>().apply { postValue(1) }
    val currentCharacterImage = MutableLiveData<Int>().apply { value = R.drawable.logo }
    val currentCharacterName = MutableLiveData<Int>().apply { value  = R.string.waiting }
}
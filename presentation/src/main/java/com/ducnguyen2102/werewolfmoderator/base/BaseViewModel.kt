package com.ducnguyen2102.werewolfmoderator.base

import androidx.lifecycle.ViewModel
import com.ducnguyen2102.werewolfmoderator.domain.usecase.UseCase
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel constructor(
        private vararg val useCases: UseCase<*, *>?
) : ViewModel() {

    var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        useCases.let { userCases ->
            if (userCases.isNotEmpty()) userCases.forEach { it?.onCleared() }
        }
        super.onCleared()
    }
}

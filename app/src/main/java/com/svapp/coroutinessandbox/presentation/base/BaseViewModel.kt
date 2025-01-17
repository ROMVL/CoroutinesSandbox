package com.svapp.coroutinessandbox.presentation.base

import androidx.lifecycle.ViewModel
import com.svapp.coroutinessandbox.data.ResultListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext = SupervisorJob() + Dispatchers.Main

    override fun onCleared() {
        coroutineContext.cancel()
        super.onCleared()
    }

    fun <T : Any> ResultListener<T>.handleResult(
        onLoading: (Boolean) -> Unit = this@BaseViewModel::handleLoading,
        onError: (Throwable) -> Unit = this@BaseViewModel::handleError,
        onSuccess: (T) -> Unit
    ) {
        when (this) {
            is ResultListener.Success<T> -> onSuccess(result)
            is ResultListener.Loading -> onLoading(isLoading)
            is ResultListener.Error -> onError(throwable)
        }
    }

    protected open fun handleError(throwable: Throwable) {
    }

    protected open fun handleLoading(isLoading: Boolean) {
    }
}
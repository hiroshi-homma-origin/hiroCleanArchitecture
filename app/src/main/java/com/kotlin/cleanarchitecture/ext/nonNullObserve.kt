package com.kotlin.cleanarchitecture.ext

import androidx.lifecycle.LiveData

fun <T> LiveData<T>.nonNullObserve(observer: (t: T) -> Unit) {
    this.observeForever {
        it?.let(observer)
    }
}

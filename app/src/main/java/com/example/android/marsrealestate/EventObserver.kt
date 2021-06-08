package com.example.android.marsrealestate

import androidx.lifecycle.Observer

class EventObserver<T>(val onUnhandledEvent: (T) -> Unit) : Observer<Event<T>> {
    override fun onChanged(t: Event<T>) {
        t?.getContentIfUnhandled()?.let { onUnhandledEvent(it) }
    }

}
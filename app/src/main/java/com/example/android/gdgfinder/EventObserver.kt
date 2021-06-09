package com.example.android.gdgfinder

import androidx.lifecycle.Observer

class EventObserver<T>(private val onEventUnhandled: (T) -> Unit) : Observer<Event<T>> {
    override fun onChanged(t: Event<T>?) {
        t?.getContentIfUnhandled()?.let { onEventUnhandled(it) }
    }
}
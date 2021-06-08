package com.example.android.trackmysleepquality

import androidx.lifecycle.Observer

class EventObserver<T>(private val onEventUnhandled: (T) -> Unit) : Observer<EventWrap<T>> {
    override fun onChanged(t: EventWrap<T>?) {
        t?.returnContentIfNotHandle()?.let { value ->
            onEventUnhandled(value)
        }
    }
}
package com.example.android.trackmysleepquality

open class EventWrap<out T>(private val content: T) {

    var hasBeenHandled = false
        private set

    fun returnContentIfNotHandle(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    fun peekContent(): T = content
}
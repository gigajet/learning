package com.example.android.marsrealestate

class Event<out T>(private val content: T) {
    var handled = false

    fun getContentIfUnhandled(): T? {
        return if (handled) {
            null
        } else {
            handled = true
            content
        }
    }

    fun peekContent(): T = content
}
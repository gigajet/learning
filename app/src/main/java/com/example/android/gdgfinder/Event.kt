package com.example.android.gdgfinder

open class Event<out T>(private val content: T) {
    var handled = false
        private set

    fun peekContent(): T = content


    fun getContentIfUnhandled(): T? {
        return if (handled) {
            null
        } else {
            handled = true
            content
        }
    }

}
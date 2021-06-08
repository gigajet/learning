package com.example.android.guesstheword

open class Event<out T>(private val content: T) {

    var hasBeenHandled = false
        private set

    fun peekContent(): T = content

    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }
}
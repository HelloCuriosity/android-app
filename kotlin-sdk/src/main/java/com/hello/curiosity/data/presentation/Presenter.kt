package com.hello.curiosity.data.presentation

interface Presenter<in T> {
    fun bind(view: T)

    fun unbind()
}

package com.hello.curiosity.common

interface Presenter<in T> {
    fun bind(view: T): Unit

    fun unbind(): Unit
}

package com.hello.curiosity.template.common

interface Presenter<in T> {
    fun bind(view: T): Unit

    fun unbind(): Unit
}

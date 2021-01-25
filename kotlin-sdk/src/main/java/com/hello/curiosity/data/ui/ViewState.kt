package com.hello.curiosity.data.ui

sealed class ViewState<out V> {
    data class Value<V>(val value: V) : ViewState<V>()
    class Loading<V> : ViewState<V>()
    data class Error<V>(val error: Throwable, val title: Int? = null, val message: Int? = null) : ViewState<V>()
    class Empty<V>() : ViewState<V>()

    fun isLoading(): Boolean = this is Loading<V>
    fun value(): V? = if (this is Value<V>) value else null
    fun error(): Throwable? = if (this is Error<V>) error else null
}

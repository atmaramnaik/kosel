@file:JvmName("PerformKt")

package io.github.atmaramnaik.kosel

fun <T> slow(value: Long,block:()->T):T{
    val ret=block()
    Thread.sleep(value)
    return ret;
}
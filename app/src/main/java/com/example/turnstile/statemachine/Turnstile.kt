package com.example.turnstile.statemachine

interface Turnstile {
    fun lock()
    fun unlock()
    fun thanks()
    fun alarm()
}
package com.example.turnstile.statemachine

interface TurnstileStateMachine {
    fun handleEvent(event: TurnstileEvent)
}
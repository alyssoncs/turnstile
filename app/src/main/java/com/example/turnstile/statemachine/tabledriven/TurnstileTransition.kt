package com.example.turnstile.statemachine.tabledriven

import com.example.turnstile.statemachine.Turnstile
import com.example.turnstile.statemachine.TurnstileEvent

data class TurnstileTransition(
    val currentState: TurnstileState,
    val event: TurnstileEvent,
    val nextState: TurnstileState,
    val action: Turnstile.() -> Unit,
)

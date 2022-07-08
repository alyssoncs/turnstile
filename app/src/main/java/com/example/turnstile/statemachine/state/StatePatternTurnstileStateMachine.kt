package com.example.turnstile.statemachine.state

import com.example.turnstile.statemachine.Turnstile
import com.example.turnstile.statemachine.TurnstileEvent
import com.example.turnstile.statemachine.TurnstileStateMachine

class StatePatternTurnstileStateMachine(private val turnstile: Turnstile) : TurnstileStateMachine {
    var currentState: TurnstileState = EnumTurnstileState.LOCKED

    override fun handleEvent(event: TurnstileEvent) {
        when (event) {
            TurnstileEvent.COIN -> currentState.coin(turnstile, this)
            TurnstileEvent.PASS -> currentState.pass(turnstile, this)
        }
    }
}
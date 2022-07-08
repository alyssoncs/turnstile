package com.example.turnstile.statemachine.tabledriven

import com.example.turnstile.statemachine.Turnstile
import com.example.turnstile.statemachine.TurnstileEvent
import com.example.turnstile.statemachine.TurnstileEvent.*
import com.example.turnstile.statemachine.TurnstileStateMachine
import com.example.turnstile.statemachine.tabledriven.TurnstileState.*

class TableDrivenTurnstileStateMachine(private val turnstile: Turnstile): TurnstileStateMachine {
    private val transitions = listOf(
        TurnstileTransition(LOCKED, COIN, UNLOCKED, Turnstile::unlock),
        TurnstileTransition(LOCKED, PASS, LOCKED, Turnstile::alarm),
        TurnstileTransition(UNLOCKED, COIN, UNLOCKED, Turnstile::thanks),
        TurnstileTransition(UNLOCKED, PASS, LOCKED, Turnstile::lock),
    )

    private var state: TurnstileState = LOCKED

    override fun handleEvent(event: TurnstileEvent) {
        val transition = transitions.find { it.currentState == state && it.event == event }
        if (transition != null) {
            state = transition.nextState
            transition.action(turnstile)
        }
    }
}
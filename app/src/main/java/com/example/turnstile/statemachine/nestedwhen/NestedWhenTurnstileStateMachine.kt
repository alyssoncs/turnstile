package com.example.turnstile.statemachine.nestedwhen

import com.example.turnstile.statemachine.Turnstile
import com.example.turnstile.statemachine.TurnstileEvent
import com.example.turnstile.statemachine.TurnstileEvent.*
import com.example.turnstile.statemachine.TurnstileStateMachine
import com.example.turnstile.statemachine.nestedwhen.TurnstileState.*

class NestedWhenTurnstileStateMachine(private val turnstile: Turnstile): TurnstileStateMachine {
    private var state: TurnstileState = LOCKED

    override fun handleEvent(event: TurnstileEvent) {
        when (state) {
            LOCKED -> {
                when (event) {
                    COIN -> {
                        turnstile.unlock()
                        state = UNLOCKED
                    }
                    PASS -> {
                        turnstile.alarm()
                    }
                }
            }
            UNLOCKED -> {
                when (event) {
                    COIN -> {
                        turnstile.thanks()
                    }
                    PASS -> {
                        turnstile.lock()
                        state = LOCKED
                    }
                }
            }
        }
    }
}
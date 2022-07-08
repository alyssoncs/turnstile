package com.example.turnstile.statemachine.state

import com.example.turnstile.statemachine.Turnstile

interface TurnstileState {
    fun coin(turnstile: Turnstile, stateMachine: StatePatternTurnstileStateMachine)
    fun pass(turnstile: Turnstile, stateMachine: StatePatternTurnstileStateMachine)
}

enum class EnumTurnstileState : TurnstileState {
    LOCKED {
        override fun coin(turnstile: Turnstile, stateMachine: StatePatternTurnstileStateMachine) {
            turnstile.unlock()
            stateMachine.currentState = UNLOCKED
        }

        override fun pass(turnstile: Turnstile, stateMachine: StatePatternTurnstileStateMachine) {
            turnstile.alarm()
            stateMachine.currentState = this
        }
    },
    UNLOCKED {
        override fun coin(turnstile: Turnstile, stateMachine: StatePatternTurnstileStateMachine) {
            turnstile.thanks()
            stateMachine.currentState = this
        }

        override fun pass(turnstile: Turnstile, stateMachine: StatePatternTurnstileStateMachine) {
            turnstile.lock()
            stateMachine.currentState = LOCKED
        }
    },
}

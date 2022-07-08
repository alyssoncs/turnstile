package com.example.turnstile.statemachine.state

import com.example.turnstile.statemachine.Turnstile
import com.example.turnstile.statemachine.TurnstileStateMachine
import com.example.turnstile.statemachine.TurnstileStateMachineTest

class StatePatternTurnstileStateMachineTest : TurnstileStateMachineTest() {
    override fun createStateMachine(turnstile: Turnstile): TurnstileStateMachine {
        return StatePatternTurnstileStateMachine(turnstile)
    }
}
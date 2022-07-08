package com.example.turnstile.statemachine.nestedwhen

import com.example.turnstile.statemachine.Turnstile
import com.example.turnstile.statemachine.TurnstileStateMachine
import com.example.turnstile.statemachine.TurnstileStateMachineTest

class NestWhenTurnstileStateMachineTest : TurnstileStateMachineTest() {
    override fun createStateMachine(turnstile: Turnstile): TurnstileStateMachine {
        return NestedWhenTurnstileStateMachine(turnstile)
    }
}


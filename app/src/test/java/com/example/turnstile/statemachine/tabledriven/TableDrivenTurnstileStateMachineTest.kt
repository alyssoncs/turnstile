package com.example.turnstile.statemachine.tabledriven

import com.example.turnstile.statemachine.Turnstile
import com.example.turnstile.statemachine.TurnstileStateMachine
import com.example.turnstile.statemachine.TurnstileStateMachineTest

class TableDrivenTurnstileStateMachineTest : TurnstileStateMachineTest() {
    override fun createStateMachine(turnstile: Turnstile): TurnstileStateMachine {
        return TableDrivenTurnstileStateMachine(turnstile)
    }
}
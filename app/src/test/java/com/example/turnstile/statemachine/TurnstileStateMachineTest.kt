package com.example.turnstile.statemachine

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

abstract class TurnstileStateMachineTest : Turnstile {
    private lateinit var stateMachine: TurnstileStateMachine

    abstract fun createStateMachine(turnstile: Turnstile): TurnstileStateMachine

    @Before
    fun setUp() {
        stateMachine = createStateMachine(this)
    }

    @Test
    fun `single coin`() {
        stateMachine.handleEvent(TurnstileEvent.COIN)

        assertEquals("U", interactions)
    }

    @Test
    fun `two coins`() {
        stateMachine.handleEvent(TurnstileEvent.COIN)
        stateMachine.handleEvent(TurnstileEvent.COIN)

        assertEquals("UT", interactions)
    }

    @Test
    fun `many coins`() {
        repeat(5) {
            stateMachine.handleEvent(TurnstileEvent.COIN)
        }

        assertEquals("UTTTT", interactions)
    }

    @Test
    fun `force pass`() {
        stateMachine.handleEvent(TurnstileEvent.PASS)

        assertEquals("A", interactions)
    }

    @Test
    fun `coin followed by pass`() {
        stateMachine.handleEvent(TurnstileEvent.COIN)
        stateMachine.handleEvent(TurnstileEvent.PASS)

        assertEquals("UL", interactions)
    }

    @Test
    fun `normal operation`() {
        stateMachine.handleEvent(TurnstileEvent.COIN) //U
        stateMachine.handleEvent(TurnstileEvent.PASS) //L
        stateMachine.handleEvent(TurnstileEvent.PASS) //A
        stateMachine.handleEvent(TurnstileEvent.COIN) //U
        stateMachine.handleEvent(TurnstileEvent.COIN) //T
        stateMachine.handleEvent(TurnstileEvent.PASS) //L

        assertEquals("ULAUTL", interactions)
    }

    private var interactions: String = ""
    override fun lock() {
        interactions += "L"
    }

    override fun unlock() {
        interactions += "U"
    }

    override fun thanks() {
        interactions += "T"
    }

    override fun alarm() {
        interactions += "A"
    }
}


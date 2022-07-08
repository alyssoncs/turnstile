package com.example.turnstile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.turnstile.databinding.ActivityMainBinding
import com.example.turnstile.statemachine.Turnstile
import com.example.turnstile.statemachine.TurnstileEvent
import com.example.turnstile.statemachine.tabledriven.TableDrivenTurnstileStateMachine

class MainActivity : AppCompatActivity(), Turnstile {

    private lateinit var binding: ActivityMainBinding
    private lateinit var stateMachine: TableDrivenTurnstileStateMachine

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        stateMachine = TableDrivenTurnstileStateMachine(this)
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.coinButton.setOnClickListener {
            stateMachine.handleEvent(TurnstileEvent.COIN)
        }

        binding.passButton.setOnClickListener {
            stateMachine.handleEvent(TurnstileEvent.PASS)
        }
    }

    private fun output(message: String) {
        binding.output.text = message
    }

    override fun lock() {
        output("the turnstile is now locked")
    }

    override fun unlock() {
        output("you can pass now")
    }

    override fun thanks() {
        output("thank you")
    }

    override fun alarm() {
        output("the security has been notified")
    }
}
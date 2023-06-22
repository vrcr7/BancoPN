package com.example.bancopn
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Toast
import com.example.bancopn.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var balance: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener {
            when (binding.radioGroup.checkedRadioButtonId) {
                binding.radioButtonVerSaldo.id -> mostrarSaldo()
                binding.radioButtonIngresarDinero.id -> ingresarDinero()
                binding.radioButtonSacarDinero.id -> sacarDinero()
                binding.radioButtonSalir.id -> finish()
            }
        }
    }

    private fun mostrarSaldo() {
        val saldo = "Saldo actual: $balance"
        Toast.makeText(this, saldo, Toast.LENGTH_SHORT).show()
    }

    private fun ingresarDinero() {
        val amount = binding.editTextAmount.text.toString().toDoubleOrNull()
        if (amount != null) {
            balance += amount
            val mensaje = "Se ha ingresado $amount al saldo"
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Ingrese un monto válido", Toast.LENGTH_SHORT).show()
        }
    }

    private fun sacarDinero() {
        val amount = binding.editTextAmount.text.toString().toDoubleOrNull()
        if (amount != null) {
            if (amount <= balance) {
                balance -= amount
                val mensaje = "Se ha retirado $amount del saldo"
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Saldo insuficiente", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Ingrese un monto válido", Toast.LENGTH_SHORT).show()
        }
    }
}

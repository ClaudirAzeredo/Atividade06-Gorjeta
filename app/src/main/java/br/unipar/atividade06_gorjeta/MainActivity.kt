package br.unipar.atividade06_gorjeta

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextValorConta: EditText
    private lateinit var editTextPercentualGorjeta: EditText
    private lateinit var buttonCalcularGorjeta: Button
    private lateinit var textViewResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextValorConta = findViewById(R.id.editTextValorConta)
        editTextPercentualGorjeta = findViewById(R.id.editTextPercentualGorjeta)
        buttonCalcularGorjeta = findViewById(R.id.buttonCalcularGorjeta)
        textViewResultado = findViewById(R.id.textViewResultado)

        buttonCalcularGorjeta.setOnClickListener {
            calcularGorjeta()
        }
    }

    private fun calcularGorjeta() {
        val valorContaStr = editTextValorConta.text.toString()
        val percentualGorjetaStr = editTextPercentualGorjeta.text.toString()

        if (valorContaStr.isEmpty() || percentualGorjetaStr.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha todos os campos!", Toast.LENGTH_SHORT).show()
            return
        }

        val valorConta = valorContaStr.toDoubleOrNull()
        val percentualGorjeta = percentualGorjetaStr.toDoubleOrNull()


        if (valorConta == null || percentualGorjeta == null || valorConta <= 0 || percentualGorjeta <= 0) {
            Toast.makeText(this, "Por favor, insira valores válidos!", Toast.LENGTH_SHORT).show()
            return
        }

        val valorGorjeta = valorConta * (percentualGorjeta / 100)
        val totalConta = valorConta + valorGorjeta


        textViewResultado.text = "Gorjeta: R$ %.2f\nTotal com Gorjeta: R$ %.2f".format(valorGorjeta, totalConta)
    }
}
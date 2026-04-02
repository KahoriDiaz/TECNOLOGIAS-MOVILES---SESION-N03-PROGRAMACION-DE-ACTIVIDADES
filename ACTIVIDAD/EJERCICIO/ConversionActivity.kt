package com.example.seguimiento

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ConversionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversion)

        val input = findViewById<EditText>(R.id.txtMonto)
        val btn = findViewById<Button>(R.id.btnConvertir)
        val resultado = findViewById<TextView>(R.id.txtResultado)

        btn.setOnClickListener {
            val monto = input.text.toString().toDoubleOrNull()

            if (monto != null) {
                val convertido = monto * 3.8 // Ejemplo: dólares a soles
                resultado.text = "Resultado: S/ $convertido"
            } else {
                resultado.text = "Ingrese un valor válido"
            }
        }
    }
}

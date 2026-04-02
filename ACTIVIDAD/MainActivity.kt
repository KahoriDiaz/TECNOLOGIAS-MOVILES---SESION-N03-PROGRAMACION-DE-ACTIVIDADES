package com.example.seguimiento

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button
class MainActivity : AppCompatActivity() {

    private val eti = "Ciclo de Vida"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(eti, "onCreate()")

        val btn = findViewById<Button>(R.id.btnMostrar1)

        btn.setOnClickListener {
            val intent = Intent(this, SegundaActividad::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(eti, "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(eti, "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(eti, "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(eti, "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(eti, "onDestroy()")
    }
}

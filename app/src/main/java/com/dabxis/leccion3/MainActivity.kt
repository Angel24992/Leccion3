package com.dabxis.leccion3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dabxis.leccion3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.boton1.setOnClickListener{
            determinar()
        }

    }

    private fun determinar() {
        val notaIngresada = binding.nota.text.toString()

        if (notaIngresada.isNotEmpty()) {
            val notaFinal = notaIngresada.toIntOrNull()

            if (notaFinal != null && notaFinal in 0..100) {
                val notaLetra = when (notaFinal) {
                    in 90..100 -> "A"
                    in 80..89 -> "B"
                    in 70..79 -> "C"
                    in 60..69 -> "D"
                    else -> "F"
                }

                binding.letra.text = notaLetra
            } else {
                binding.letra.text = "Ingrese un número entre 0 y 100"
            }
        } else {
            binding.letra.text = "Ingrese una calificación"
        }
    }
}
package com.kevin.examen

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.kevin.examen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClickConvertidor(view: View) {
        val Entrada = binding.Label.text.toString().toDoubleOrNull() ?: return

        val resultado = when (view.id) {
            R.id.KilometrosButton -> convertirKm(Entrada)
            R.id.CentimetrosButton -> convertirCm(Entrada)
            R.id.MilimetrosButton -> convertirMl(Entrada)
            R.id.DecametrosButton -> convertirDm(Entrada)
            else -> return
        }

        binding.valorSalida.setText(resultado.toString())
    }

    private fun convertirKm(valorMetros: Double): Double {
        return valorMetros / 1000.0
    }

    private fun convertirCm(valorMetros: Double): Double {
        return valorMetros * 100.0
    }

    private fun convertirMl(valorMetros: Double): Double {
        return valorMetros * 1000.0
    }
    private fun convertirDm(valorMetros: Double): Double {
        return valorMetros * 0.1
    }
}

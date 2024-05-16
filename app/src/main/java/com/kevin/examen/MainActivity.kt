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

    fun onClickConvertir(view: View) {
        val valorEntrada = binding.valorEntrada.text.toString().toDoubleOrNull() ?: return

        val resultado = when (view.id) {
            R.id.convertirAKilometrosButton -> convertirAKilometros(valorEntrada)
            R.id.convertirACentimetrosButton -> convertirACentimetros(valorEntrada)
            R.id.convertirAMilimetrosButton -> convertirAMilimetros(valorEntrada)
            else -> return
        }

        binding.valorSalida.setText(resultado.toString())
    }

    private fun convertirAKilometros(valorMetros: Double): Double {
        return valorMetros / 1000.0
    }

    private fun convertirACentimetros(valorMetros: Double): Double {
        return valorMetros * 100.0
    }

    private fun convertirAMilimetros(valorMetros: Double): Double {
        return valorMetros * 1000.0
    }
}

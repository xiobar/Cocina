package com.imd.cocina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.imd.cocina.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calcularBoton.setOnClickListener(){calcularMedida()}
    }

    fun calcularMedida(){
        val cajonMedida = binding.medidaEdit.text.toString()
        val medidaEntera = cajonMedida.toDoubleOrNull()
        if (medidaEntera == null){
            binding.resultadoPeso.text=""
            return
        }
        val calculo = when(binding.pesoOpcion.checkedRadioButtonId){
            R.id.libra_boton -> 0.453592
            R.id.gramo_boton -> 0.00220462
            else -> 150.00
        }

        var calculoMedida = medidaEntera * calculo
        if (binding.redondearValor.isChecked){
            calculoMedida =kotlin.math.ceil(calculoMedida)
        }
        binding.resultadoPeso.text = calculoMedida.toString()

    }
}
package com.sebastiaovinicius.imc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sebastiaovinicius.imc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener(this)

    }

    override fun onClick(v: View) {

        if(v.id==R.id.button_calculate) {
            calculaIMC()
        }

    }
    private fun calculaIMC(){
        var altura= binding.editTextAltura.text.toString().toDouble()
        var peso= binding.editTextPeso.text.toString().toDouble()
        var IMC= peso/ Math.pow((altura),2.00)
        marcarFaixa(IMC)
        binding.textViewIMC.text=IMC.toString()
    }

    private fun marcarFaixa( imc:Double){

        if(imc<18.5){
            binding.textViewAbaixoDoPeso.setTextColor(Color.RED)
            binding.textViewAbaixoPesoNormal.setTextColor(Color.BLACK)
            binding.textViewAbaixoSobrePeso.setTextColor(Color.BLACK)
            binding.textViewAbaixoObesidadeGrauI.setTextColor(Color.BLACK)
            binding.textViewAbaixoObesidadeGrauII.setTextColor(Color.BLACK)
            binding.textViewAbaixoObesidadeGrauIII.setTextColor(Color.BLACK)

        }
        if(imc in 18.5..24.9) {
            binding.textViewAbaixoPesoNormal.setTextColor(Color.RED)
            binding.textViewAbaixoDoPeso.setTextColor(Color.BLACK)
            binding.textViewAbaixoSobrePeso.setTextColor(Color.BLACK)
            binding.textViewAbaixoObesidadeGrauI.setTextColor(Color.BLACK)
            binding.textViewAbaixoObesidadeGrauII.setTextColor(Color.BLACK)
            binding.textViewAbaixoObesidadeGrauIII.setTextColor(Color.BLACK)

        }
        if(imc in 24.9..29.9){
            binding.textViewAbaixoSobrePeso.setTextColor(Color.RED)
            binding.textViewAbaixoPesoNormal.setTextColor(Color.BLACK)
            binding.textViewAbaixoDoPeso.setTextColor(Color.BLACK)
            binding.textViewAbaixoObesidadeGrauI.setTextColor(Color.BLACK)
            binding.textViewAbaixoObesidadeGrauII.setTextColor(Color.BLACK)
            binding.textViewAbaixoObesidadeGrauIII.setTextColor(Color.BLACK)

        }
        if(imc in 30.0..34.9){
            binding.textViewAbaixoObesidadeGrauI.setTextColor(Color.RED)
            binding.textViewAbaixoSobrePeso.setTextColor(Color.BLACK)
            binding.textViewAbaixoPesoNormal.setTextColor(Color.BLACK)
            binding.textViewAbaixoDoPeso.setTextColor(Color.BLACK)
            binding.textViewAbaixoObesidadeGrauII.setTextColor(Color.BLACK)
            binding.textViewAbaixoObesidadeGrauIII.setTextColor(Color.BLACK)

        }
        if(imc in 35.0..39.9){
            binding.textViewAbaixoObesidadeGrauII.setTextColor(Color.RED)
            binding.textViewAbaixoObesidadeGrauI.setTextColor(Color.BLACK)
            binding.textViewAbaixoSobrePeso.setTextColor(Color.BLACK)
            binding.textViewAbaixoPesoNormal.setTextColor(Color.BLACK)
            binding.textViewAbaixoDoPeso.setTextColor(Color.BLACK)
            binding.textViewAbaixoObesidadeGrauIII.setTextColor(Color.BLACK)
        }
        if(imc >=40.0){
            binding.textViewAbaixoObesidadeGrauIII.setTextColor(Color.RED)

            binding.textViewAbaixoObesidadeGrauII.setTextColor(Color.BLACK)
            binding.textViewAbaixoObesidadeGrauI.setTextColor(Color.BLACK)
            binding.textViewAbaixoSobrePeso.setTextColor(Color.BLACK)
            binding.textViewAbaixoPesoNormal.setTextColor(Color.BLACK)
            binding.textViewAbaixoDoPeso.setTextColor(Color.BLACK)

        }

    }
}
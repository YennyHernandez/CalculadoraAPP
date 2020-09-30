package com.yennyh.micalculadora

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object{
        private const val suma = 1
        private const val resta = 2
        private const val por = 3
        private const val divisor = 4
        //private const val multiplicacion ="*"
        //private const val division ="/"

     }
    private var operacionuno: Double = 0.0
    private var operaciondos: Double = 0.0
    private var signooperacion: Int = 0
    private var signooperacionactual: Int = 0
    private var contadorsigno: Int = 0
    private var var_resultado: Double  = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        siete_button.setOnClickListener { numeroseleccionado("7") }
        ocho_button.setOnClickListener { numeroseleccionado("8") }
        nueve_button.setOnClickListener { numeroseleccionado("9") }
        cuatro_button.setOnClickListener { numeroseleccionado("4") }
        cinco_button.setOnClickListener { numeroseleccionado("5") }
        seis_button.setOnClickListener { numeroseleccionado("6") }
        uno_button.setOnClickListener { numeroseleccionado("1") }
        dos_button.setOnClickListener { numeroseleccionado("2") }
        tres_button.setOnClickListener { numeroseleccionado("3") }
        punto_button.setOnClickListener { numeroseleccionado(".") }
        cero_button.setOnClickListener { numeroseleccionado("0") }

        mas_button.setOnClickListener{operacionseleccionada(operacion = 1)}
        menos_button.setOnClickListener{operacionseleccionada(operacion = 2)}
        por_button.setOnClickListener{operacionseleccionada(operacion = 3)}
        divisor_button.setOnClickListener{operacionseleccionada(operacion = 4)}

        igual_button.setOnClickListener{
            operacionacalcular()
            ingreso_ditTextNumber.text = operacionuno.toString()}
        borrar_button.setOnClickListener{
             operacionuno= 0.0
             operaciondos= 0.0
             signooperacion= 0
             contadorsigno = 0
             var_resultado  = 0.0
            ingreso_ditTextNumber.text = "0"
        }
    }
    @SuppressLint("SetTextI18n")
    private fun numeroseleccionado(numero:String){

        ingreso_ditTextNumber.text = "${ingreso_ditTextNumber.text}$numero"
        if(signooperacion == 0){
            operacionuno = ingreso_ditTextNumber.text.toString().toDouble()
        }

        else{
            operaciondos = ingreso_ditTextNumber.text.toString().toDouble()
        }

    }

    private fun operacionseleccionada(operacion: Int){
         contadorsigno = contadorsigno +1
         signooperacionactual = operacion

         //DEBO PASAR A WHEN  DE OPERCALCULAR -> SIGNO OPERACION  PERO NO EL ACTUALIZADO SI NO EL ANTERIOR
        ingreso_ditTextNumber.text = " "
        if(contadorsigno>1){

            operacionacalcular()}
        else{
            signooperacion = operacion
        }



    }
    private fun operacionacalcular(){
        val resultado = when(signooperacion){
            suma -> operacionuno + operaciondos
            resta -> operacionuno -  operaciondos
            por -> operacionuno *  operaciondos
            divisor -> operacionuno /  operaciondos
            else -> 0
        }

        operacionuno = resultado as Double
        signooperacion = signooperacionactual


    }
}
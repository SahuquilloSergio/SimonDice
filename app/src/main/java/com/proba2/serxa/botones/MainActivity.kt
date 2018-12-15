package com.proba2.serxa.botones

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.Toast
import java.util.*


class MainActivity : AppCompatActivity() {


    //Declaramos los botones


    var iluminaciones = 2


    var secuencia = mutableListOf<String>() //Declaramos un ArrayList para guardar la variable que decide que boton se ilumina

    lateinit var brojo: Button
    lateinit var bazul: Button
    lateinit var bamarillo: Button
    lateinit var bverde: Button
    lateinit var bjugar: Button
    lateinit var texto: Toast    //Declaramos un Toas texto
    lateinit var textoFin: Toast
    lateinit var textoIni: Toast
    lateinit var textoAcertar: Toast
    lateinit var textoFallar: Toast


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("ESTADO", "CREANDOSE")


        brojo = findViewById(R.id.buttonRojo)
        bazul = findViewById(R.id.buttonAzul)
        bamarillo = findViewById(R.id.buttonAmarillo)
        bverde = findViewById(R.id.buttonVerde)
        bjugar = findViewById(R.id.buttonJugar)


        //Cambiamos el color de fondo de los botones
        brojo.setBackgroundColor(Color.RED)
        bazul.setBackgroundColor(Color.BLUE)
        bamarillo.setBackgroundColor(Color.YELLOW)
        bverde.setBackgroundColor(Color.GREEN)

        texto = Toast.makeText(applicationContext, "Bienvenido a Simon Crash", Toast.LENGTH_SHORT)
        texto.show()

        textoIni = Toast.makeText(applicationContext, "Empezando", Toast.LENGTH_SHORT)

        textoFin = Toast.makeText(applicationContext, "Has Fallado, Fin del Juego", Toast.LENGTH_SHORT)

        textoAcertar = Toast.makeText(applicationContext, "Has Acertado", Toast.LENGTH_SHORT)
        textoFallar = Toast.makeText(applicationContext, "Has fallado", Toast.LENGTH_SHORT)

        //Eventos que ocurren al pulsar los botones
        bjugar.setOnClickListener {
            habilitarBotones()
            textoIni.show()

            iluminaciones ++

            encender(iluminaciones)
        }

        brojo.setOnClickListener {
            comprobar("rojo")
        }

        bazul.setOnClickListener {
            comprobar("azul")
        }

        bamarillo.setOnClickListener {
            comprobar("amarillo")
        }

        bverde.setOnClickListener {
            comprobar("verde")
        }
    }


    fun encender(encendidas: Int) {
        val random = Random()
        var aleatorio = 0
        var delay = 1000L




        for (i in 1..encendidas) {
            val aleatorio = Random().nextInt(4)
            delay += 2500L

            when (aleatorio) {
                0 -> {
                    Handler().postDelayed({
                        //Delay a posteriori(Recibe la accion a realizar(en este caso cambiar el color), y el delay
                        brojo.setBackgroundColor(Color.argb(80, 255, 0, 0))    //Hacemos que se "ilumine"(se hace mas transparente)
                        brojo.setText("Dojo")  //Cambiamos el texto(solo para comprobar)

                        Handler().postDelayed({
                            //Recibe el cambio al color original y delay, que es el tiempo que se retrasa
                            brojo.setBackgroundColor(Color.RED) //Le devolvemos el color original al boton
                        }, 1000)    //Le añadimos 1 segundo al delay
                    }, delay)
                    secuencia.add("rojo")
                }

                1 -> {
                    Handler().postDelayed({
                        bazul.setBackgroundColor(Color.argb(80, 62, 95, 138))
                        bazul.setText("Aful")

                        Handler().postDelayed({
                            bazul.setBackgroundColor(Color.BLUE)
                        }, 1000)
                    }, delay)
                    secuencia.add("azul")
                }

                2 -> {
                    Handler().postDelayed({
                        bamarillo.setBackgroundColor(Color.argb(80, 255, 255, 0))
                        bamarillo.setText("Madillo")

                        Handler().postDelayed({
                            bamarillo.setBackgroundColor(Color.YELLOW)
                        }, 1000)
                    }, delay)
                    secuencia.add("amarillo")
                }

                3 -> {
                    Handler().postDelayed({
                        bverde.setBackgroundColor(Color.argb(80, 255, 255, 0))
                        bverde.setText("Velde")

                        Handler().postDelayed({
                            bverde.setBackgroundColor(Color.GREEN)
                        }, 1000)
                    }, delay)
                    secuencia.add("verde")
                }
            }
        }
    }

    fun comprobar(color: String) {     //Recibe el boton que se pulsa
        if (secuencia.isEmpty() != true) {
            if(secuencia.get(0).equals(color)){
                secuencia.removeAt(0)
                textoAcertar.show()
            }else{
                textoFallar.show()
                deshabilitarBotones()
                iluminaciones = 0
            }


        } else {
            iluminaciones++
            encender(iluminaciones)

        }
    }


    fun habilitarBotones() {
        brojo.isClickable = true
        brojo.isClickable = true
        bazul.isClickable = true
        bamarillo.isClickable = true
        bverde.isClickable = true
    }


    fun deshabilitarBotones() {
        brojo.isClickable = false
        brojo.isClickable = false
        bazul.isClickable = false
        bamarillo.isClickable = false
        bverde.isClickable = false
    }

}

//Funcion juego que ilumina los botones aleatoriamente
   // fun juego() {

      //  var delay: Long = 2000; //Delay para que no se muestren todos a la vez

      //  for (i in 0..ronda step 1) {    //Bucle for, incrementa en 1 cada vez

       //     val x = Random().nextInt(4)
       //     when (x) {  //SwitchCase

         //       0 -> {
           //         Handler().postDelayed({
             //           //Delay a posteriori(Recibe la accion a realizar(en este caso cambiar el color), y el delay
               //         buttonRojo.setBackgroundColor(Color.argb(80, 255, 0, 0))    //Hacemos que se "ilumine"(se hace mas transparente)
                 //       buttonRojo.setText("Dojo")  //Cambiamos el texto(solo para comprobar)

//                        Handler().postDelayed({
  //                          //Recibe el cambio al color original y delay, que es el tiempo que se retrasa
    //                        buttonRojo.setBackgroundColor(Color.RED) //Le devolvemos el color original al boton
      //                  }, 1000)    //Le añadimos 1 segundo al delay
        //            }, delay)
          //      }


            //    1 -> {

              //      Handler().postDelayed({
                //        buttonAzul.setBackgroundColor(Color.argb(80, 191, 255, 0))
                  //      buttonAzul.setText("Aful")
//
  //                      Handler().postDelayed({
    //                        buttonAzul.setBackgroundColor(Color.BLUE)
      //                  }, 1000)
        //            }, delay)
          //      }


            //    2 -> {
              //      Handler().postDelayed({
                //        buttonAmarillo.setBackgroundColor(Color.argb(80, 255, 255, 0))
                  //      buttonAmarillo.setText("Madillo")
//
  //                      Handler().postDelayed({
    //                        buttonAmarillo.setBackgroundColor(Color.YELLOW)
      //                  }, 1000)
        //            }, delay)
          //      }
//
  //              3 -> {
    //                Handler().postDelayed({
      //                  buttonAmarillo.setBackgroundColor(Color.argb(80, 255, 255, 0))
        //                buttonAmarillo.setText("Madillo")
//
  //                      Handler().postDelayed({
    //                        buttonAmarillo.setBackgroundColor(Color.YELLOW)
      //                  }, 1000)
        //            }, delay)
          //      }
            //}
            //secuencia.add("x")    //Añadimos todos los numeros de la secuencia al ArrayList
            //delay += 2000;
        //}
    //}


    //Funcion para comprobar si se pulsan los botones correctamente


        //if(secuencia.get(maquina) == nBoton) {
        //Si la el get de la secuencia de usuario, es igual al boton pulsado
       // texto.setText("Correcto")
       // maquina++
      //  ronda++
      //  }else
       //  {
      //  texto.setText("Error")
   // }
   // texto.show()

   // fun acabarJuego(){
     //   textoFin.show()
   // }



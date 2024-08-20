package pe.edu.upeu.calxml

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var txtResultado:EditText
    private var valAnt=0.0
    private var valAct=0.0
    private var operador=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        txtResultado=findViewById(R.id.txtResult)
        botones();

    }

    fun botones(){
        var buttons= arrayOf(R.id.btn7, R.id.btn8, R.id.btn9,
            R.id.btnClear, R.id.btnraiz, R.id.btnmul, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btnsum, R.id.btn7,R.id.btn8, R.id.btn9,R.id.btnpot, R.id.btnInv, R.id.btnPi,R.id.btnigual)
        for (button in buttons){
            var btn=findViewById<Button>(button)
            btn.setOnClickListener { onClikListener(btn) }
        }
    }

    fun onClikListener(view: View) {
        val botonX = findViewById<Button>(view.id)
        when (view.id) {
            R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9 -> {
                appentContent(botonX.text.toString())
            }
            R.id.btnmul, R.id.btnsum, R.id.btnpot -> {
                setOperador(botonX.text.toString())
            }
            R.id.btnraiz -> {
                calcularRaizCuadrada()
            }
            R.id.btnInv-> {
                calcularInverso()
            }
            R.id.btnPi -> {
                mostrarPi()
            }
            R.id.btnigual -> {
                operacion()
            }
            R.id.btnClear -> {
                // Limpia el campo de texto y restablece el estado de la calculadora
                clear()
            }

        }
    }

    fun appentContent(valor:String){
        txtResultado.append(valor)
    }

    fun setOperador(oper:String){
        operador=oper
        valAnt=txtResultado.text.toString().toDouble()
        txtResultado.text.clear()
    }

    fun operacion() {
        valAct = txtResultado.text.toString().toDouble()
        val resultx = when (operador) {
            "*" -> valAnt * valAct
            "+" -> valAnt + valAct
            "^" -> Math.pow(valAnt, valAct)
            else -> valAct
        }
        txtResultado.setText(resultx.toString())
        operador = ""
    }

    fun calcularRaizCuadrada() {
        val numero = txtResultado.text.toString().toDouble()
        val resultado = Math.sqrt(numero)
        txtResultado.setText(resultado.toString())
    }

    private fun calcularInverso() {
        val numero = txtResultado.text.toString().toDoubleOrNull() ?: 0.0
        if (numero != 0.0) {
            val resultado = 1 / numero
            txtResultado.setText(resultado.toString())
        } else {
            txtResultado.setText("Error")
        }
    }
    private fun clear() {
        txtResultado.text.clear()
        operador = ""
        valAnt = 0.0
        valAct = 0.0
    }

    fun mostrarPi() {
        val resultado = Math.PI
        txtResultado.setText(resultado.toString())
    }
}
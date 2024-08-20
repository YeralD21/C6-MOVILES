package pe.edu.upeu.calxml

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var textResultado:EditText
    private var valAnt=0.0
    private var valActual=0.0
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
        textResultado=findViewById(R.id.txtResult)
        botones()

    }
    fun botones(){
        var button= arrayOf(R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btnmul, R.id.btnsum, R.id.btnigual)
        for (button in buttons){
            var btn=findViewById<Button>
        }
    }

    fun onClickListener(view:View){
        when(view.id){
            R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9 -> {
                var botonX=findViewById<Button>(view.id)
                appentContent(botonX.text.toString())}

        }
    }

    fun appentContent(valor:String){
        textResultado.append(valor)
    }

    fun setOperador(oper:String){
        operador=oper
        valAnt=textResultado.text.toString().toDouble()
        textResultado.text.clear()
    }

    fun operacion(){
        valActual=textResultado.text.toString().toDouble()
        var resultx=when(operador){
            "*"->valAnt*valActual
            "+"->valAnt+valActual
            else->valActual
        }
        textResultado.setText(resultx.toString())
        operador=""
    }

}
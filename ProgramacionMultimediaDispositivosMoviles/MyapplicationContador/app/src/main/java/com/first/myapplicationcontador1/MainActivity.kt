package com.first.myapplicationcontador1

//import android.R
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


/*class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        /*setContent {
            MyApplicationContador1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }*/
    }
}*/
class MainActivity : AppCompatActivity() {
    private var textoContador: TextView? = null
    private var btnContador: Button? = null
    private var contador: Int =0;

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Establecemos el layout que debe cargar esta Activity
        setContentView(R.layout.activity_main)
        
        // Una vez cargado el layout, ya podemos acceder a sus elementos
        textoContador = findViewById(R.id.TextDisplayContador)
        btnContador = findViewById(R.id.ButtomSumarContador)
        btnContador?.setOnClickListener { incrementarContador() }
    }
    fun incrementarContador(){
        contador++
        textoContador!!.setText("Clicks: $contador");
    }
   /*  private void incrementarContador(View v) {
        // Actualizamos el valor del contador
        contador++;
        // Actualizamos el texto que muestra la cuenta
        textoContador.setText("Has clickado " + contador + " veces");
    }*/
}

/*@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationContador1Theme {
        Greeting("Android")
    }
}
*/

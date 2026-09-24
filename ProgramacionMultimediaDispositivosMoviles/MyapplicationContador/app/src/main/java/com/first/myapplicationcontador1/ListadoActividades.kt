package com.first.myapplicationcontador1

import android.app.Activity
import android.os.Bundle

class ListadoActividades: Activity(){
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Establecemos el layout que debe cargar esta Activity
        setContentView(R.layout.actividades_listado)

        // Una vez cargado el layout, ya podemos acceder a sus elementos
    }
}
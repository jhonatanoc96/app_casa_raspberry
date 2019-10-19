package com.jhonatan.bombillos;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
//El main activity solo inicia y detiene el servidor, no hace nada mas. Pues el estado del LED será manejado por el servicio REST desde internet

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Iniciar el servidor
        RESTfulService.startServer(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Detener el servidor
        RESTfulService.stopServer(this);
    }
}

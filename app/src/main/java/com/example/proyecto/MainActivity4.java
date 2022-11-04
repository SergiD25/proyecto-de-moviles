package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    private TextView salida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        salida = (TextView) findViewById(R.id.salida);
        String nombre1 =getIntent().getStringExtra("nombre1");
        salida.setText("Listo " + nombre1 +" en poco tiempo nos pondremos en contacto contigo");


    }
}
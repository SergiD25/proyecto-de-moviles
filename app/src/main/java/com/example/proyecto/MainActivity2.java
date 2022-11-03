package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity2 extends AppCompatActivity {

    Spinner spLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        spLista = (Spinner)findViewById(R.id.tipodocumento);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.lista, android.R.layout.simple_list_item_1);
        spLista.setAdapter(adapter);

    }
}
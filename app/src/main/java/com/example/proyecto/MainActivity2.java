package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity2 extends AppCompatActivity {

    Spinner spLista;
    private EditText nombre1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        spLista = (Spinner)findViewById(R.id.tipodocumento);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.lista, android.R.layout.simple_list_item_1);
        spLista.setAdapter(adapter);

        nombre1 = (EditText)findViewById(R.id.nombre1);
    }

    public void completado(View view)
    {
        Intent completado= new Intent(this,MainActivity4.class);

        completado.putExtra("nombre1",nombre1.getText().toString());
        startActivity(completado);
    }
}
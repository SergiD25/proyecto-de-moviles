package com.example.proyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        /*
        Intent menuslide = new Intent(getApplicationContext(),Menu_de_navegacion.class);
        startActivity(menuslide);*/
    }

    public void registro(View view)
    {
        Intent registro= new Intent(this,MainActivity2.class);
        startActivity(registro);
    }

    public void revision(View view)
    {
        Intent revision= new Intent(this,Noticias.class);
        startActivity(revision);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


}
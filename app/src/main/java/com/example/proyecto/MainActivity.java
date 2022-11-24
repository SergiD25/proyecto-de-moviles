package com.example.proyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity  {


    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private MenuItem item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navview);




    }



    public void registro(View view)
    {
        Intent registro= new Intent(this,MainActivity3.class);
        startActivity(registro);
    }

    public void revision(View view)
    {
        Intent revision= new Intent(this,Consulta.class);
        startActivity(revision);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }




    public void Noticias(View view)
    {
        Intent Noticias= new Intent(this,Noticias.class);
        startActivity(Noticias);
    }

    public void Conocenos(View view)
    {
        Intent Conocenos= new Intent(this,conocenos.class);
        startActivity(Conocenos);
    }


}
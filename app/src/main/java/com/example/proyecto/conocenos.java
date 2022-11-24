package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class conocenos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conocenos);



        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("https://www.uniagustiniana.edu.co/la-universidad");
    }

    public void regresar(View view)
    {
        Intent regreso= new Intent(this,MainActivity.class);
        startActivity(regreso);
    }
}
package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity {



    public EditText nombre1,nombre2,apellido1,apellido2,numdocumento;
    private Button botoncontinuar;
    private Spinner spLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


         nombre1 = (EditText)findViewById(R.id.nombre1);
          nombre2 = (EditText)findViewById(R.id.nombre2);
          apellido1 = (EditText)findViewById(R.id.apellido1);
          apellido2 = (EditText)findViewById(R.id.apellido2);
          numdocumento = (EditText)findViewById(R.id.numdocumento);
         spLista = (Spinner) findViewById(R.id.tipodocumento);

         botoncontinuar = (Button)findViewById(R.id.button);

        //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.lista, android.R.layout.simple_list_item_1);
        //spLista.setAdapter(adapter);
        botoncontinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    ejecutarServicio("http://studi-html.infinityfreeapp.com/registrar.php");

            }
        });


    }

    public void anterior(View view)
    {
        Intent revision= new Intent(this,MainActivity.class);
        startActivity(revision);
    }




    /*
    public void registrar(View v)
    {
        ejecutarServicio("http://studi-html.infinityfreeapp.com/registrar.php");
    }

    private void ejecutarServicio(String URL)
    {
        StringRequest stringRequest= new StringRequest(Request.Method.POST,URL,new  Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "operacion exitosa", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();

            }
        } ){
            @Override
            public Map<String, String> getParams() throws AuthFailureError{
                Map<String,String> parametros = new HashMap<String,String>();
                parametros.put("nombre1",nombre1.getText().toString());
                parametros.put("nombre2",nombre2.getText().toString());
                parametros.put("apellido1",apellido1.getText().toString());
                parametros.put("apellido2",apellido2.getText().toString());
                parametros.put("numdocumento",numdocumento.getText().toString());

                return parametros;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
*/

    private void ejecutarServicio(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),"Operacion realizada",Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError{
                Map<String,String> parametros = new HashMap<String,String>();
                parametros.put("nombre1",nombre1.getText().toString());
                parametros.put("nombre2",nombre2.getText().toString());
                parametros.put("apellido1",apellido1.getText().toString());
                parametros.put("apellido2",apellido2.getText().toString());
                parametros.put("numdocumento",numdocumento.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue( this);
        requestQueue.add(stringRequest);
    }





}
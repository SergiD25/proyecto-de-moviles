package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity3 extends AppCompatActivity {

    public EditText nombre1,nombre2,apellido1,apellido2,numdocumento,telefono,correo,direccion;
    private Button finalizar;
    private Spinner spLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        nombre1 = (EditText)findViewById(R.id.nombre1);
        nombre2 = (EditText)findViewById(R.id.nombre2);
        apellido1 = (EditText)findViewById(R.id.apellido1);
        apellido2 = (EditText)findViewById(R.id.apellido2);
        numdocumento = (EditText)findViewById(R.id.numdocumento);
        spLista = (Spinner) findViewById(R.id.tipodocumento);
        direccion = (EditText)findViewById(R.id.direccion);
        correo = (EditText)findViewById(R.id.correo);
        telefono = (EditText)findViewById(R.id.telefono);

        finalizar = (Button) findViewById(R.id.finalizar);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.lista, android.R.layout.simple_list_item_1);
        spLista.setAdapter(adapter);

        finalizar.setOnClickListener(new View.OnClickListener() {
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
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<String,String>();
                parametros.put("tipo_doc",spLista.getSelectedItem().toString());
                parametros.put("nro_documento",numdocumento.getText().toString());
                parametros.put("primer_nombre",nombre1.getText().toString());
                parametros.put("segundo_nombre",nombre2.getText().toString());
                parametros.put("primer_apellido",apellido1.getText().toString());
                parametros.put("segundo_apellido",apellido2.getText().toString());
                parametros.put("telefono",telefono.getText().toString());
                parametros.put("direccion",direccion.getText().toString());
                parametros.put("correo",correo.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue( this);
        requestQueue.add(stringRequest);
    }
}
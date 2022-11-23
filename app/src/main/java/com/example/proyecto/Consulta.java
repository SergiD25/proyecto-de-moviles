package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Consulta extends AppCompatActivity {



      EditText consultar, nombreconsulta,apellidoconsulta,telefonoconsulta;
     Button generarconsulta;
     RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

       nombreconsulta = (EditText) findViewById(R.id.nombreconsulta);
        apellidoconsulta = (EditText) findViewById(R.id.apellidoconsulta);
        telefonoconsulta = (EditText) findViewById(R.id.telefonoconsulta);
        consultar = (EditText) findViewById(R.id.consulta);
       generarconsulta = (Button) findViewById(R.id.gen_consulta);


       generarconsulta.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               buscar("http://studi-html.infinityfreeapp.com/select.php"+consultar.getText()+"");
           }
       });


    }

    private void buscar (String URL)
    {
        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject=null;
                for(int i= 0; i<response.length();i++){
                    try {
                        jsonObject=response.getJSONObject(i);
                        telefonoconsulta.setText(jsonObject.getString("nro_documento"));
                        nombreconsulta.setText(jsonObject.getString("primer_nombre"));
                        apellidoconsulta.setText(jsonObject.getString("segundo_apellido"));
                    }catch (JSONException e){
                        Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error de conexion", Toast.LENGTH_SHORT).show();
            }

        }
        );
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }
}
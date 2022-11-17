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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class MainActivity2 extends AppCompatActivity {


    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        final EditText nombre1 = (EditText)findViewById(R.id.nombre1);
        final EditText nombre2 = (EditText)findViewById(R.id.nombre2);
        final EditText apellido1 = (EditText)findViewById(R.id.apellido1);
        final EditText apellido2 = (EditText)findViewById(R.id.apellido2);
        final EditText numdedocumento = (EditText)findViewById(R.id.numdocumento);
        final Spinner spLista = (Spinner) findViewById(R.id.tipodocumento);
        final Button botoncontinuar = (Button) findViewById(R.id.button);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.lista, android.R.layout.simple_list_item_1);
        spLista.setAdapter(adapter);

        botoncontinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
                {

                    String nombre_1 = nombre1.getText().toString();
                    String nombre_2 = nombre2.getText().toString();
                    String apellido_1 = apellido1.getText().toString();
                    String apellido_2 = apellido2.getText().toString();
                    String num_de_documento = numdedocumento.getText().toString();
                    String lista = spLista.toString();

                    /*completado.putExtra("nombre1",nombre1.getText().toString());
                    completado.putExtra("nombre2",nombre2.getText().toString());
                    completado.putExtra("apellido1",apellido1.getText().toString());
                    completado.putExtra("apellido2",apellido2.getText().toString());
                    completado.putExtra("tipodocumento",spLista.toString());
                    completado.putExtra("numdocumento",nombre1.getText().toString());
                    startActivity(completado);*/
                    new DescargarImagen(MainActivity2.this).execute(nombre_1,nombre_2,apellido_1,apellido_2,num_de_documento);
                }

        });


        
    }




    public void anterior(View view)
    {
        Intent revision= new Intent(this,MainActivity.class);
        startActivity(revision);
    }

    public static class DescargarImagen extends AsyncTask<String,Void,String>
    {
        private WeakReference<Context> context;

        public DescargarImagen(Context context)
        {
            this.context = new WeakReference<>(context);
        }

        protected String doInBackground(String... params)
        {
            String registrar_url = "http://studi-html.infinityfreeapp.com/registrar.php";
            String resultado;

            try
            {
                URL url = new URL(registrar_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));

                String nombre1 = params[0];
                String nombre2 = params[1];
                String apellido1 = params[2];
                String apellido2 = params[3];
                String tipo_de_documento = params[4];
                String numdocumento = params[5];

                String data = URLEncoder.encode("nombre1","UTF-8")+ "=" + URLEncoder.encode(nombre1,"UTF-8")
                        + "&" + URLEncoder.encode("nombre2","UTF-8") + "=" + URLEncoder.encode(nombre2,"UTF-8")
                        + "&" + URLEncoder.encode("apellido1","UTF-8") + "=" + URLEncoder.encode(apellido1,"UTF-8")
                        + "&" + URLEncoder.encode("apellido2","UTF-8") + "=" + URLEncoder.encode(apellido2,"UTF-8")
                        + "&" + URLEncoder.encode("tipo_de_documento","UTF-8") + "=" + URLEncoder.encode(tipo_de_documento,"UTF-8")
                        + "&" + URLEncoder.encode("numdocumento","UTF-8") + "=" + URLEncoder.encode(numdocumento,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,StandardCharsets.UTF_8));
                StringBuilder stringBuilder = new StringBuilder();

                String line;
                while  ((line = bufferedReader.readLine()) != null)
                {
                    stringBuilder.append(line);
                }
                resultado = stringBuilder.toString();

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

            } catch (MalformedURLException e) {
                Log.d("MiAPP", "Se ha utilizado una URL con formato incorrecto");
                resultado = "Se ha producido un Error";
            } catch (IOException e) {
                Log.d("MiAPP","Error inesperado!, posibles problemas de conexion de red");
                resultado= "Se ha producido un Error, comprueba tu conexion a Internet";
            }
            return resultado;
        }

        protected void onPostExecute (String resultado)
        {
            Toast.makeText(context.get(),resultado,Toast.LENGTH_LONG).show();
        }
    }
}
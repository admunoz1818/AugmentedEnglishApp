package com.example.familyteam.augmentedenglishapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.familyteam.augmentedenglishapp.adapters.PalabraAdapter;
import com.example.familyteam.augmentedenglishapp.models.Palabra;
import com.example.familyteam.augmentedenglishapp.net.PalabraCon;
import com.microsoft.windowsazure.mobileservices.ServiceFilterResponse;

import java.util.List;


public class NuevaPalabraActivity extends ActionBarActivity implements PalabraCon.PalabraConI, View.OnClickListener {

    Palabra p;
    PalabraCon pCon;

    EditText nombre;
    EditText traduccion;
    EditText pronunciacion;
    ImageView imagen;
    Button crearPalabra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_palabra);
        nombre = (EditText) findViewById(R.id.txtNombre);
        traduccion = (EditText) findViewById(R.id.txtTraduccion);
        pronunciacion = (EditText) findViewById(R.id.txtPronunciacion);
        imagen = (ImageView) findViewById(R.id.txtImagen);
        crearPalabra = (Button) findViewById(R.id.btnCrearPalabra);

        pCon = new PalabraCon(this,this);
        crearPalabra.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_nueva_palabra, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCompleted(Palabra entity, Exception exception, ServiceFilterResponse response) {

    }

    @Override
    public void onDeleteCompleted(Exception exception, ServiceFilterResponse response) {

    }

    @Override
    public void onReadCompleted(List<Palabra> result, int count, Exception exception, ServiceFilterResponse response) {

    }

    @Override
    public void onClick(View v) {
        p = new Palabra();
        p.setNombre(nombre.getText().toString());
        p.setTraduccion(traduccion.getText().toString());
        p.setPronunciacion(pronunciacion.getText().toString());
        p.setPatron("Aqui debe ir el patron");
        p.setImagen("http://img2.wikia.nocookie.net/__cb20140827124248/monsterhunterespanol/es/images/a/aa/Imagen-no-disponible-282x300.png");

        pCon.insert(p);

        Toast.makeText(getApplicationContext(), "¡Palabra ingresada!",
                Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, PalabrasActivity.class);
        startActivity(intent);
    }
}
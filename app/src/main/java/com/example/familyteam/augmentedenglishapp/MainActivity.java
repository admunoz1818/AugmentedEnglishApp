package com.example.familyteam.augmentedenglishapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.familyteam.augmentedenglishapp.adapters.UsuarioAdapter;
import com.example.familyteam.augmentedenglishapp.models.Usuario;
import com.example.familyteam.augmentedenglishapp.net.UsuarioCon;
import com.microsoft.windowsazure.mobileservices.ServiceFilterResponse;

import java.util.List;


public class MainActivity extends ActionBarActivity implements UsuarioCon.UsuarioConI {

    Usuario usu;
    EditText txtNombre;
    EditText txtCorreo;
    EditText txtContrasena;
    Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre = (EditText) findViewById(R.id.nombre);
        txtCorreo = (EditText) findViewById(R.id.correo);
        txtContrasena = (EditText) findViewById(R.id.contrasena);

        usu = new Usuario();
        usu.setNombre(txtNombre.toString());
        usu.setCorreo(txtNombre.toString());
        usu.setContrasena(txtContrasena.toString());

    }

    //region OptionMenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
//endregion

    //region Azure Callback
    @Override
    public void onCompleted(Usuario entity, Exception exception, ServiceFilterResponse response) {

    }

    @Override
    public void onDeleteCompleted(Exception exception, ServiceFilterResponse response) {

    }

    @Override
    public void onReadCompleted(List<Usuario> result, int count, Exception exception, ServiceFilterResponse response) {

    }
    //endregion
}

package com.example.familyteam.augmentedenglishapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.familyteam.augmentedenglishapp.adapters.PalabraAdapter;
import com.example.familyteam.augmentedenglishapp.models.Usuario;
import com.example.familyteam.augmentedenglishapp.net.UsuarioCon;
import com.microsoft.windowsazure.mobileservices.ServiceFilterResponse;

import java.util.ArrayList;
import java.util.List;


public class LoginActivity extends ActionBarActivity implements UsuarioCon.UsuarioConI, View.OnClickListener {

    EditText txtCorreo;
    EditText txtContrasena;
    Button btnIniciarSesion;
    Button btnRegistrar;

    List<Usuario> usuarios;
    UsuarioCon usuarioCon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtCorreo = (EditText) findViewById(R.id.correo_registro);
        txtContrasena = (EditText) findViewById(R.id.contrasena_registro);
        btnIniciarSesion = (Button) findViewById(R.id.btnIniciarSesion);
        btnRegistrar = (Button) findViewById(R.id.btnRegistro_registro);
        usuarios = new ArrayList<>();

        usuarioCon = new UsuarioCon(this, this);
        usuarioCon.getAllItems();
        btnIniciarSesion.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
    public void onCompleted(Usuario entity, Exception exception, ServiceFilterResponse response) {

    }

    @Override
    public void onDeleteCompleted(Exception exception, ServiceFilterResponse response) {

    }

    @Override
    public void onReadCompleted(List<Usuario> result, int count, Exception exception, ServiceFilterResponse response) {
        usuarios.clear();
        for (  int i=0;i<result.size();i++){
            usuarios.add(result.get(i));
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnIniciarSesion: {
                for (int i = 0; i < usuarios.size(); i++) {

                    if (usuarios.get(i).getCorreo().toString().contentEquals(txtCorreo.getText().toString())
                            && usuarios.get(i).getContrasena().toString().contentEquals(txtContrasena.getText().toString())
                            ) {

                        Toast.makeText(getApplicationContext(), "Inicio de sesion exitoso!!! =)",
                                Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(this, MenuActivity.class);
                        startActivity(intent);

                        return;
                    }
                }
                Toast.makeText(getApplicationContext(), "Datos incorrectos!!! =(",
                        Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.btnRegistro_registro: {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
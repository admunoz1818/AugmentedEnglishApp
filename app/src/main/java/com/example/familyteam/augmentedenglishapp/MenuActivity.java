package com.example.familyteam.augmentedenglishapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MenuActivity extends ActionBarActivity implements View.OnClickListener {

    Button btnCrea;
    Button btnDescubre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnCrea = (Button) findViewById(R.id.btnCrea);
        btnDescubre = (Button) findViewById(R.id.btnDescubre);

        btnCrea.setOnClickListener(this);
        btnDescubre.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
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
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnCrea:
            {
                Intent intent = new Intent(this, NuevaPalabraActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btnDescubre:
            {
                Intent intent = new Intent(this, PalabrasActivity.class);
                startActivity(intent);
                break;
            }
        }

    }
}

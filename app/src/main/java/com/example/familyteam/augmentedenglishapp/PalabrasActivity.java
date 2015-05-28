package com.example.familyteam.augmentedenglishapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.familyteam.augmentedenglishapp.adapters.PalabraAdapter;
import com.example.familyteam.augmentedenglishapp.models.Palabra;
import com.example.familyteam.augmentedenglishapp.net.PalabraCon;
import com.microsoft.windowsazure.mobileservices.ServiceFilterResponse;

import java.util.ArrayList;
import java.util.List;


public class PalabrasActivity extends ActionBarActivity implements PalabraCon.PalabraConI {


    ListView list;
    List<Palabra> data;
    PalabraAdapter adapter;

    PalabraCon pCon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palabras);

        list = (ListView) findViewById(R.id.lista_palabras);
        data = new ArrayList<>();
        adapter = new PalabraAdapter(this, data);
        list.setAdapter(adapter);

        pCon = new PalabraCon(this,this);
        pCon.getAllItems();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_palabras, menu);
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
        data.clear();
        for (  int i=0;i<result.size();i++){
            data.add(result.get(i));
        }
        adapter.notifyDataSetChanged();
    }
}

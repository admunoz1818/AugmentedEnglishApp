package com.example.familyteam.augmentedenglishapp.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.familyteam.augmentedenglishapp.R;
import com.example.familyteam.augmentedenglishapp.models.Palabra;

import java.util.List;

/**
 * Created by FamilyTeam on 27/05/2015.
 */
public class PalabraAdapter extends BaseAdapter {

    Context context;
    List<Palabra> data;

    public PalabraAdapter(Context context, List<Palabra> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v;
        if(convertView != null)
            v = convertView;
        else
            v=View.inflate(context, R.layout.template_palabras,null);

        Palabra u = (Palabra) getItem(position);

        TextView txt = (TextView) v.findViewById(R.id.nombre);
        txt.setText(u.getNombre());

        txt = (TextView) v.findViewById(R.id.traduccion);
        txt.setText(u.getTraduccion());

        txt = (TextView) v.findViewById(R.id.pronunciacion);
        txt.setText(u.getPronunciacion());

        txt = (TextView) v.findViewById(R.id.patron);
        txt.setText(u.getPatron());

        txt = (TextView) v.findViewById(R.id.imagen);
        txt.setText(u.getImagen());

        return v;
    }
}

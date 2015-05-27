package com.example.familyteam.augmentedenglishapp.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.familyteam.augmentedenglishapp.R;
import com.example.familyteam.augmentedenglishapp.models.Usuario;

import java.util.List;

/**
 * Created by FamilyTeam on 26/05/2015.
 */
public class UsuarioAdapter extends BaseAdapter {

    Context context;
    List<Usuario> data;

    public UsuarioAdapter(Context context, List<Usuario> data) {
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
            v= convertView;
        else
            v=View.inflate(context, R.layout.activity_main,null);

        Usuario u = (Usuario) getItem(position);

        TextView txt = (TextView) v.findViewById(R.id.nombre);
        txt.setText(u.getNombre());

        txt = (TextView) v.findViewById(R.id.correo);
        txt.setText(u.getCorreo());

        txt = (TextView) v.findViewById(R.id.contrasena);
        txt.setText(u.getContrasena());

        return v;
    }
}

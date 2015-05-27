package com.example.familyteam.augmentedenglishapp.net;

import android.content.Context;

import com.example.familyteam.augmentedenglishapp.models.Usuario;
import com.microsoft.windowsazure.mobileservices.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.TableQueryCallback;

import java.util.List;

/**
 * Created by FamilyTeam on 27/05/2015.
 */
public class UsuarioCon extends AzureClient<Usuario> implements TableQueryCallback<Usuario> {

    public interface UsuarioConI{
        void onCompleted(Usuario entity, Exception exception, ServiceFilterResponse response);
        void onDeleteCompleted(Exception exception, ServiceFilterResponse response);
        void onReadCompleted(List<Usuario> result, int count, Exception exception, ServiceFilterResponse response);
    }

    UsuarioConI usuarioConI;

    public UsuarioCon(Context context, UsuarioConI usuarioConI) {
        super(context);
        this.usuarioConI = usuarioConI;
    }

    @Override
    public Class<Usuario> getClassModel() {
        return Usuario.class;
    }

    @Override
    public void onCompleted(Exception exception, ServiceFilterResponse response) {
        usuarioConI.onDeleteCompleted(exception,response);
    }

    @Override
    public void onCompleted(Usuario entity, Exception exception, ServiceFilterResponse response) {
        usuarioConI.onCompleted(entity,exception,response);
    }

    @Override
    public void onCompleted(List<Usuario> result, int count, Exception exception, ServiceFilterResponse response) {
        usuarioConI.onReadCompleted(result,count,exception,response);
    }
}

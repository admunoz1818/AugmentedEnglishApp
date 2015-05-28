package com.example.familyteam.augmentedenglishapp.net;

import android.content.Context;

import com.example.familyteam.augmentedenglishapp.models.Palabra;
import com.microsoft.windowsazure.mobileservices.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.TableQueryCallback;

import java.util.List;

/**
 * Created by FamilyTeam on 27/05/2015.
 */
public class PalabraCon extends AzureClient<Palabra> implements TableQueryCallback<Palabra> {

    public interface PalabraConI{
        void onCompleted(Palabra entity, Exception exception, ServiceFilterResponse response);
        void onDeleteCompleted(Exception exception, ServiceFilterResponse response);
        void onReadCompleted(List<Palabra> result, int count, Exception exception, ServiceFilterResponse response);
    }

    PalabraConI palabraConI;

    public PalabraCon(Context context, PalabraConI palabraConI) {
        super(context);
        this.palabraConI = palabraConI;
    }

    @Override
    public Class<Palabra> getClassModel() {
        return Palabra.class;
    }

    @Override
    public void onCompleted(Palabra entity, Exception exception, ServiceFilterResponse response) {
        palabraConI.onCompleted(entity, exception, response);
    }

    @Override
    public void onCompleted(Exception exception, ServiceFilterResponse response) {
        palabraConI.onDeleteCompleted(exception,response);
    }

    @Override
    public void onCompleted(List<Palabra> result, int count, Exception exception, ServiceFilterResponse response) {
        palabraConI.onReadCompleted(result,count,exception,response);
    }
}

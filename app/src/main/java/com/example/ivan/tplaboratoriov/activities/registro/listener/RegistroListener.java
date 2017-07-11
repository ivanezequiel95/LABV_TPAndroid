package com.example.ivan.tplaboratoriov.activities.registro.listener;

import android.view.View;

/**
 * Created by Ivan on 11/07/2017.
 */

public class RegistroListener implements View.OnClickListener {

    private IRegistro iRegistro;

    public RegistroListener(IRegistro iRegistro) {
        this.iRegistro = iRegistro;
    }

    @Override
    public void onClick(View v) {

        this.iRegistro.registrarUsuario(v);
    }
}

package com.example.ivan.tplaboratoriov.activities.login.listener;

import android.view.View;

import com.example.ivan.tplaboratoriov.clases_datos.Usuario;

/**
 * Created by Ivan on 11/07/2017.
 */

public interface ILogin {

    public void clickBtn(View v);
    public void login(Usuario usuario);
    public void registrar();
}

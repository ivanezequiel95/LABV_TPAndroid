package com.example.ivan.tplaboratoriov.activities.registro.listener;

import android.view.View;

import com.example.ivan.tplaboratoriov.clases_datos.Usuario;

/**
 * Created by Ivan on 11/07/2017.
 */

public interface IRegistro {

    public void clickBtn(View v);
    public void validarUsuario(Usuario usuario);
    public void registrarUsuario(Usuario usuario);

}

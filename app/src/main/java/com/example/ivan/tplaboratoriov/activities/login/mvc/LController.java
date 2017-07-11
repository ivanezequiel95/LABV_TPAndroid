package com.example.ivan.tplaboratoriov.activities.login.mvc;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.ivan.tplaboratoriov.activities.login.listener.ILogin;
import com.example.ivan.tplaboratoriov.activities.login.listener.LoginListener;
import com.example.ivan.tplaboratoriov.activities.menu.MenuActivity;
import com.example.ivan.tplaboratoriov.activities.registro.RegistroActivity;
import com.example.ivan.tplaboratoriov.clases_datos.Usuario;
import com.example.ivan.tplaboratoriov.R;

/**
 * Created by Ivan on 11/07/2017.
 */

public class LController implements ILogin{

    private LView view;
    private LoginListener loginListener;

    public LController(LView view) {
        this.view = view;

        this.loginListener = new LoginListener(this);

        this.view.getbLogin().setOnClickListener(this.loginListener);
        this.view.getbReg().setOnClickListener(this.loginListener);
    }








    @Override
    public void clickBtn(View v) {

        if (v.getId() == R.id.login_b_login) {
            this.login(new Usuario(this.view.getEtMail().getText().toString(), this.view.getEtPass().getText().toString()));
        }
        if (v.getId() == R.id.login_b_reg)
            this.registrar();

    }

    @Override
    public void login(Usuario usuario) {
        if (Usuario.validarUsuario(usuario))
        {
            Toast.makeText(this.view.getActLogin(), "Bienvenido !", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this.view.getActLogin(), MenuActivity.class);
            this.view.getActLogin().startActivity(intent);

        }else
            Toast.makeText(this.view.getActLogin(), "Mala suerte :(", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void registrar() {
        Toast.makeText(this.view.getActLogin(), "A registrarse !", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this.view.getActLogin(), RegistroActivity.class);
        this.view.getActLogin().startActivity(intent);
    }
}

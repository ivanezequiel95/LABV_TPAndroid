package com.example.ivan.tplaboratoriov.activities.login.mvc;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Toast;

import com.example.ivan.tplaboratoriov.activities.login.listener.ILogin;
import com.example.ivan.tplaboratoriov.activities.login.listener.LoginListener;
import com.example.ivan.tplaboratoriov.activities.menu.MenuActivity;
import com.example.ivan.tplaboratoriov.activities.registro.RegistroActivity;
import com.example.ivan.tplaboratoriov.clases_datos.Usuario;
import com.example.ivan.tplaboratoriov.R;
import com.example.ivan.tplaboratoriov.conexion.HiloConnection;
import com.example.ivan.tplaboratoriov.conexion.JSONParser;
import com.example.ivan.tplaboratoriov.validacion.Validacion;

/**
 * Created by Ivan on 11/07/2017.
 */

public class LController implements ILogin, Handler.Callback{

    private LView view;
    private LoginListener loginListener;

    private Handler handler;

    public LController(LView view) {
        this.view = view;

        this.loginListener = new LoginListener(this);

        this.view.getbLogin().setOnClickListener(this.loginListener);
        this.view.getbReg().setOnClickListener(this.loginListener);

        this.handler = new Handler(this);
    }








    @Override
    public void clickBtn(View v) {

        if (v.getId() == R.id.login_b_login) {

            String mail = this.view.getEtMail().getText().toString();
            String pass = this.view.getEtPass().getText().toString();

            if (!Validacion.esVacio(mail) && !Validacion.esVacio(pass))
            {
                if (Validacion.esMail(mail))
                {
                    this.login(new Usuario(mail, pass));
                }else
                    Toast.makeText(this.view.getActLogin(), "Se debe ingresar un MAIL", Toast.LENGTH_SHORT).show();
            }else
                Toast.makeText(this.view.getActLogin(), "Complete TODOS los campos plis xd", Toast.LENGTH_SHORT).show();
        }
        if (v.getId() == R.id.login_b_reg)
            this.registrar();

    }

    @Override
    public void login(Usuario usuario) {

        Usuario.userActual = usuario;

        Thread loginThread = new Thread(new HiloConnection(this.handler, "usuarios/" + usuario.getMail() + "/" + usuario.getPass(), "GET"));
        loginThread.start();

//        if (Usuario.validarUsuario(usuario))
//        {
//            Toast.makeText(this.view.getActLogin(), "Bienvenido !", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(this.view.getActLogin(), MenuActivity.class);
//            this.view.getActLogin().startActivity(intent);
//
//        }else
//            Toast.makeText(this.view.getActLogin(), "Mala suerte :(", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void registrar() {
        Toast.makeText(this.view.getActLogin(), "A registrarse !", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this.view.getActLogin(), RegistroActivity.class);
        this.view.getActLogin().startActivity(intent);
    }

    @Override
    public boolean handleMessage(Message msg) {

        if (msg.arg1 == 1)
        {
            Boolean respuestaParseoLogin = JSONParser.parseRespuestaLogin((String) msg.obj);

            if (respuestaParseoLogin)
            {
                Toast.makeText(this.view.getActLogin(), "Bienvenido !", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this.view.getActLogin(), MenuActivity.class);
                this.view.getActLogin().startActivity(intent);
            }else
            {
                Usuario.userActual = null;

                Toast.makeText(this.view.getActLogin(), "Mala suerte :(", Toast.LENGTH_SHORT).show();
            }
        }
        if (msg.arg1 == 1000)
            Toast.makeText(this.view.getActLogin(), "Error de conexion :(", Toast.LENGTH_SHORT).show();

        return true;
    }
}

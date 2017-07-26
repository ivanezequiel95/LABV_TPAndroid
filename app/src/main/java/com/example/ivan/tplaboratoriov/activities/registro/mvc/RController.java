package com.example.ivan.tplaboratoriov.activities.registro.mvc;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.Toast;

import com.example.ivan.tplaboratoriov.R;
import com.example.ivan.tplaboratoriov.activities.registro.listener.IRegistro;
import com.example.ivan.tplaboratoriov.activities.registro.listener.RegistroListener;
import com.example.ivan.tplaboratoriov.clases_datos.Usuario;
import com.example.ivan.tplaboratoriov.conexion.HiloConnection;
import com.example.ivan.tplaboratoriov.conexion.JSONParser;
import com.example.ivan.tplaboratoriov.validacion.Validacion;

/**
 * Created by Ivan on 11/07/2017.
 */

public class RController implements IRegistro, Handler.Callback{

    private RView view;
    private RegistroListener registroListener;

    private Handler handler;

    private Usuario usuarioNuevo;

    public RController(RView view) {
        this.view = view;
        this.registroListener = new RegistroListener(this);

        this.view.getbRegistrar().setOnClickListener(this.registroListener);

        this.handler = new Handler(this);
    }

    @Override
    public void clickBtn(View v) {

        Integer dni;
        String nombre = this.view.getEtNombre().getText().toString();
        String apellido = this.view.getEtApellido().getText().toString();
        try {
            dni = Integer.parseInt(this.view.getEtDNI().getText().toString());
        }catch (NumberFormatException e)
        {
            dni = -1;
        }
        String mail = this.view.getEtMail().getText().toString();
        String pass = this.view.getEtPass().getText().toString();
        String repass = this.view.getEtRePass().getText().toString();

        if (!Validacion.esVacio(nombre) &&
                !Validacion.esVacio(apellido) &&
                !Validacion.validarDNI(dni) &&
                !Validacion.esVacio(mail) &&
                !Validacion.esVacio(pass) &&
                !Validacion.esVacio(repass))
        {
            if (Validacion.esMail(mail))
            {
                if (Validacion.reingresoPass(pass, repass))
                {
//                    if (Usuario.registrarUsuario(new Usuario(nombre, apellido, dni, mail, pass)))
//                    {
//                        Toast.makeText(this.view.getActRegistro(), this.view.getActRegistro().getResources().getString(R.string.registro_Nuevo), Toast.LENGTH_SHORT).show();
//                        this.view.getActRegistro().finish();
//                    }else
//                        Toast.makeText(this.view.getActRegistro(), this.view.getActRegistro().getResources().getString(R.string.registro_OtroMail), Toast.LENGTH_SHORT).show();
                    usuarioNuevo = new Usuario(nombre, apellido, dni, mail, pass);
                    this.validarUsuario(usuarioNuevo);

                }else
                    Toast.makeText(this.view.getActRegistro(), this.view.getActRegistro().getResources().getString(R.string.registro_ConfirmeClave), Toast.LENGTH_SHORT).show();
            }else
                Toast.makeText(this.view.getActRegistro(), this.view.getActRegistro().getResources().getString(R.string.registro_IngreseMail), Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(this.view.getActRegistro(), this.view.getActRegistro().getResources().getString(R.string.registro_Complete), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void validarUsuario(Usuario usuario) {
        try {
            Thread validacionUsuarioThread = new Thread(new HiloConnection(this.handler, "usuarios/" + usuario.getMail(), "GET"));
            validacionUsuarioThread.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        try {
            String stringJsonPost = "{"+
                    "\"nombre\":"   + "\"" + usuario.getNombre()   + "\"," +
                    "\"apellido\":" + "\"" + usuario.getApellido() + "\"," +
                    "\"dni\":"             + usuario.getDni()      + "," +
                    "\"mail\":"     + "\"" + usuario.getMail()     + "\"," +
                    "\"clave\":"    + "\"" + usuario.getPass()    + "\""  + "}";

            Thread registrarUsuarioThread = new Thread(new HiloConnection(this.handler, "usuarios/nuevo", "POST", stringJsonPost));
            registrarUsuarioThread.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean handleMessage(Message msg) {

        if (msg.arg1 == 1)
        {
            Boolean validacionUsuario = JSONParser.parseRespuestaValidacionUsuario((String) msg.obj);

            if (validacionUsuario)
                this.registrarUsuario(this.usuarioNuevo);
            else
                Toast.makeText(this.view.getActRegistro(), this.view.getActRegistro().getResources().getString(R.string.registro_OtroMail), Toast.LENGTH_SHORT).show();
        }
        if (msg.arg1 == 3)
        {
            if (JSONParser.parseRespuestaRegistroUsuario(new String((String)msg.obj)))
            {
                Toast.makeText(this.view.getActRegistro(), this.view.getActRegistro().getResources().getString(R.string.registro_Nuevo), Toast.LENGTH_SHORT).show();
                this.view.getActRegistro().finish();
            }else
            {
                Toast.makeText(this.view.getActRegistro(), this.view.getActRegistro().getResources().getString(R.string.registro_OtroMail), Toast.LENGTH_SHORT).show();
            }
        }
        return true;
    }
}

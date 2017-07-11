package com.example.ivan.tplaboratoriov.clases_datos;

import android.util.Log;

import java.util.List;

/**
 * Created by Ivan on 11/07/2017.
 */

public class Usuario {

    public static List<Usuario> usuarioList;

    public String nombre;
    public String apellido;
    public Integer dni;
    public String mail;
    public String pass;

    public Usuario(String mail, String pass) {
        this.mail = mail;
        this.pass = pass;
    }

    public Usuario(String nombre, String apellido, Integer dni, String mail, String pass) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.mail = mail;
        this.pass = pass;
    }

    public static boolean validarUsuario(Usuario usuario)
    {
        for (Usuario u : Usuario.usuarioList)
        {
//            if (usuario.mail.equals(u.mail) && usuario.pass.equals(u.pass))
            if (usuario.mail.equals(u.mail) && usuario.pass.equals(u.pass))
                return true;
        }
        return false;
    }

    public static boolean registrarUsuario(Usuario usuario)
    {
        if (Usuario.usuarioList.size() > 0)
        {
            for (Usuario u : Usuario.usuarioList)
            {
                if (usuario.mail.equals(u.mail) || usuario.dni.equals(u.dni))
                    return false;
                else {
                    Usuario.usuarioList.add(usuario);
                    return true;
                }

            }
        }else
        {
            Usuario.usuarioList.add(usuario);
            return true;
        }
        return false;

//        for (Usuario u : Usuario.usuarioList)
//        {
//            if (u != null)
//            {
//                Log.d("NOT NULL","NOT NULL");
//                if (usuario.mail.equals(u.mail))
//                {
//                    Log.d("LALALA","ASDASD");
//                    return false;
//                }else {
//                    Usuario.usuarioList.add(usuario);
//                    return true;
//                }
//            }else {
//                Usuario.usuarioList.add(usuario);
//                return true;
//            }
//        }
//        Log.d("LALALA","ASDASD");
//        return false;
    }
}

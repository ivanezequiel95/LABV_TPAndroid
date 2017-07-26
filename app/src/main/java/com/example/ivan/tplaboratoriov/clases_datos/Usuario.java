package com.example.ivan.tplaboratoriov.clases_datos;

import android.util.Log;

import java.util.List;

/**
 * Created by Ivan on 11/07/2017.
 */

public class Usuario {

    public static List<Usuario> usuarioList;

    private String nombre;
    private String apellido;
    private Integer dni;
    private String mail;
    private String pass;

    public static Usuario userActual;


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

    public String getMail() {
        return mail;
    }

    public String getPass() {
        return pass;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getDni() {
        return dni;
    }

    /*

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
    }*/
}

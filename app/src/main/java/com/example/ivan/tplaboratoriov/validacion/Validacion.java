package com.example.ivan.tplaboratoriov.validacion;

import android.util.Patterns;

import java.util.regex.Pattern;

/**
 * Created by Ivan on 11/07/2017.
 */

public class Validacion {

    public static boolean esVacio(String campo)
    {
        return campo.isEmpty();
    }

    public static boolean esMail(String mail)
    {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(mail).matches();
    }

    public static boolean reingresoPass(String pass1, String pass2)
    {
        return pass1.equals(pass2);
    }

    public static boolean validarDNI(Integer dni)
    {
        if (dni.intValue() == -1)
            return true;
        return false;
    }
}

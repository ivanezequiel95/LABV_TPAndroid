package com.example.ivan.tplaboratoriov.activities.registro.mvc;

/**
 * Created by Ivan on 11/07/2017.
 */

public class RModel {

    private String nombre;
    private String apellido;
    private Integer dni;
    private String mail;
    private String pass1;
    private String pass2;

    public RModel() {
    }

    public RModel(String nombre, String apellido, Integer dni, String mail, String pass1, String pass2) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.mail = mail;
        this.pass1 = pass1;
        this.pass2 = pass2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass1() {
        return pass1;
    }

    public void setPass1(String pass1) {
        this.pass1 = pass1;
    }

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }
}

package com.example.ivan.tplaboratoriov.activities.login.mvc;

/**
 * Created by Ivan on 11/07/2017.
 */

public class LModel {

    private String mail;
    private String pass;

    public LModel() {
//        this.mail = mail;
//        this.pass = pass;
        this.mail = "algo@gmail.com";
        this.pass = "123";
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}


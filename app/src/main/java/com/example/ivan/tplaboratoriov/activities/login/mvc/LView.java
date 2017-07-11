package com.example.ivan.tplaboratoriov.activities.login.mvc;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import com.example.ivan.tplaboratoriov.R;

/**
 * Created by Ivan on 11/07/2017.
 */

public class LView {

    private EditText etMail;
    private EditText etPass;
    private Button bLogin;
    private Button bReg;

    private LModel model;
    private Activity actLogin;

    public LView(LModel model, Activity actLogin) {

        this.model = model;
        this.actLogin = actLogin;

        this.etMail = (EditText) actLogin.findViewById(R.id.login_mail);
        this.etPass = (EditText) actLogin.findViewById(R.id.login_pass);
        this.bLogin = (Button) actLogin.findViewById(R.id.login_b_login);
        this.bReg = (Button) actLogin.findViewById(R.id.login_b_reg);
    }

    public EditText getEtMail() {
        return etMail;
    }

    public EditText getEtPass() {
        return etPass;
    }

    public Button getbLogin() {
        return bLogin;
    }

    public Button getbReg() {
        return bReg;
    }

    public Activity getActLogin() {
        return actLogin;
    }
}

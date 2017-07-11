package com.example.ivan.tplaboratoriov.activities.registro.mvc;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

import com.example.ivan.tplaboratoriov.R;

/**
 * Created by Ivan on 11/07/2017.
 */

public class RView {

    private Activity actRegistro;
    private RModel model;

    private EditText etNombre;
    private EditText etApellido;
    private EditText etDNI;
    private EditText etMail;
    private EditText etPass;
    private EditText etRePass;
    private Button bRegistrar;

    public RView(Activity actRegistro, RModel model) {
        this.actRegistro = actRegistro;
        this.model = model;

        this.etNombre = (EditText) this.actRegistro.findViewById(R.id.registro_nombre);
        this.etApellido = (EditText) this.actRegistro.findViewById(R.id.registro_apellido);
        this.etDNI = (EditText) this.actRegistro.findViewById(R.id.registro_dni);
        this.etMail = (EditText) this.actRegistro.findViewById(R.id.registro_mail);
        this.etPass = (EditText) this.actRegistro.findViewById(R.id.registro_pass);
        this.etRePass  = (EditText) this.actRegistro.findViewById(R.id.registro_re_pass);
        this.bRegistrar = (Button) this.actRegistro.findViewById(R.id.registro_b_reg);
    }

    public Activity getActRegistro() {
        return actRegistro;
    }

    public EditText getEtNombre() {
        return etNombre;
    }

    public EditText getEtApellido() {
        return etApellido;
    }

    public EditText getEtDNI() {
        return etDNI;
    }

    public EditText getEtMail() {
        return etMail;
    }

    public EditText getEtPass() {
        return etPass;
    }

    public EditText getEtRePass() {
        return etRePass;
    }

    public Button getbRegistrar() {
        return bRegistrar;
    }
}

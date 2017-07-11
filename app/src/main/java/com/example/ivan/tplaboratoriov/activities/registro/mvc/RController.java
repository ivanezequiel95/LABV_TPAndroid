package com.example.ivan.tplaboratoriov.activities.registro.mvc;

import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.Toast;

import com.example.ivan.tplaboratoriov.R;
import com.example.ivan.tplaboratoriov.activities.registro.listener.IRegistro;
import com.example.ivan.tplaboratoriov.activities.registro.listener.RegistroListener;
import com.example.ivan.tplaboratoriov.clases_datos.Usuario;
import com.example.ivan.tplaboratoriov.validacion.Validacion;

/**
 * Created by Ivan on 11/07/2017.
 */

public class RController implements IRegistro{

    private RView view;
    private RegistroListener registroListener;

    public RController(RView view) {
        this.view = view;
        this.registroListener = new RegistroListener(this);

        this.view.getbRegistrar().setOnClickListener(this.registroListener);
    }

    @Override
    public void registrarUsuario(View v) {

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
                    if (Usuario.registrarUsuario(new Usuario(nombre, apellido, dni, mail, pass)))
                    {
                        Toast.makeText(this.view.getActRegistro(), this.view.getActRegistro().getResources().getString(R.string.registro_Nuevo), Toast.LENGTH_SHORT).show();
                        this.view.getActRegistro().finish();
                    }else
                        Toast.makeText(this.view.getActRegistro(), this.view.getActRegistro().getResources().getString(R.string.registro_OtroMail), Toast.LENGTH_SHORT).show();

                }else
                    Toast.makeText(this.view.getActRegistro(), this.view.getActRegistro().getResources().getString(R.string.registro_ConfirmeClave), Toast.LENGTH_SHORT).show();
            }else
                Toast.makeText(this.view.getActRegistro(), this.view.getActRegistro().getResources().getString(R.string.registro_IngreseMail), Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(this.view.getActRegistro(), this.view.getActRegistro().getResources().getString(R.string.registro_Complete), Toast.LENGTH_SHORT).show();
    }
}

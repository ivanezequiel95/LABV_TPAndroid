package com.example.ivan.tplaboratoriov.activities.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.ivan.tplaboratoriov.R;
import com.example.ivan.tplaboratoriov.activities.login.mvc.LController;
import com.example.ivan.tplaboratoriov.activities.login.mvc.LModel;
import com.example.ivan.tplaboratoriov.activities.login.mvc.LView;
import com.example.ivan.tplaboratoriov.clases_datos.Usuario;

import java.util.ArrayList;

/**
 * Created by Ivan on 10/07/2017.
 */

public class LoginActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        Toast.makeText(this, "Listo para entrega PRIMER PARCIAL", Toast.LENGTH_SHORT).show();

        getSupportActionBar().hide();


        /**
         *
         * Primer Parcial ( Ya no sirve )
         *
        Usuario.usuarioList = new ArrayList<Usuario>();

        //Lo agrego porque sino cuando recorro la lista se va del bloque "for".
        Usuario def = new Usuario("default", "default", 11111111,"default@default", "default" );
        Usuario.usuarioList.add(def);

        Usuario usuario = new Usuario("Ivan", "Ezequiel", 39266774, "algo@gmail.com", "123");

        Usuario.registrarUsuario(usuario);
         **/

        LModel model = new LModel();
        LView view = new LView(model, this);
        LController controller = new LController(view);
    }
}

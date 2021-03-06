package com.example.ivan.tplaboratoriov.activities.registro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.ivan.tplaboratoriov.R;
import com.example.ivan.tplaboratoriov.activities.registro.mvc.RController;
import com.example.ivan.tplaboratoriov.activities.registro.mvc.RModel;
import com.example.ivan.tplaboratoriov.activities.registro.mvc.RView;

/**
 * Created by Ivan on 10/07/2017.
 */

public class RegistroActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_layout);

        getSupportActionBar().hide();

        RModel model = new RModel();
        RView view = new RView(this, model);
        RController controller= new RController(view);
    }
}

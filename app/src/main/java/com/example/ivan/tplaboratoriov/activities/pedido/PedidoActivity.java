package com.example.ivan.tplaboratoriov.activities.pedido;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.ivan.tplaboratoriov.R;
import com.example.ivan.tplaboratoriov.activities.pedido.mvc.PController;
import com.example.ivan.tplaboratoriov.activities.pedido.mvc.PModel;
import com.example.ivan.tplaboratoriov.activities.pedido.mvc.PView;

/**
 * Created by Ivan on 10/07/2017.
 */

public class PedidoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedido_layout);

        PModel pModel = new PModel();
        PView pView = new PView(pModel, this);
        PController pController= new PController(pView);
    }
}

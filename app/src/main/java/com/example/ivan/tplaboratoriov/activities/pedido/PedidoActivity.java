package com.example.ivan.tplaboratoriov.activities.pedido;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ivan.tplaboratoriov.R;
import com.example.ivan.tplaboratoriov.activities.login.LoginActivity;
import com.example.ivan.tplaboratoriov.activities.pedido.mvc.PController;
import com.example.ivan.tplaboratoriov.activities.pedido.mvc.PModel;
import com.example.ivan.tplaboratoriov.activities.pedido.mvc.PView;
import com.example.ivan.tplaboratoriov.clases_datos.Pedido;

/**
 * Created by Ivan on 10/07/2017.
 */

public class PedidoActivity extends AppCompatActivity {

    PController pController;
    PView pView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedido_layout);

        getSupportActionBar().setTitle(this.getString(R.string.pedido_Titulo));

        PModel pModel = new PModel();
        pView = new PView(pModel, this);
        pController= new PController(pView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.pedidos_options_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.pedido_options_b_enviarPedido)
            this.pController.confirmarPedido();

        if (item.getItemId() == R.id.pedido_options_b_limpiarPedido)
            this.pView.limpiarPedido();

        if (item.getItemId() == R.id.pedido_options_b_Logout)
        {
            pController.logout();
        }
        return super.onOptionsItemSelected(item);
    }
}

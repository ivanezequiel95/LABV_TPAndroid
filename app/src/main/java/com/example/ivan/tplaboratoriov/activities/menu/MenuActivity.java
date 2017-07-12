package com.example.ivan.tplaboratoriov.activities.menu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ivan.tplaboratoriov.R;
import com.example.ivan.tplaboratoriov.activities.menu.mvc.MController;
import com.example.ivan.tplaboratoriov.activities.menu.mvc.MModel;
import com.example.ivan.tplaboratoriov.activities.menu.mvc.MView;
import com.example.ivan.tplaboratoriov.clases_datos.Pedido;
import com.example.ivan.tplaboratoriov.clases_datos.Producto;

import java.util.ArrayList;

/**
 * Created by Ivan on 10/07/2017.
 */

public class MenuActivity extends AppCompatActivity {

    MController mController;
    MView mView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);

        getSupportActionBar().setTitle(this.getString(R.string.menu_Titulo));

        Producto.productoList = new ArrayList<Producto>();

        Producto.productoList.add(new Producto("Porción pizza", 15.00));
        Producto.productoList.add(new Producto("Media pizza", 50.00));
        Producto.productoList.add(new Producto("Pizza completa", 80.00));

        Pedido.pedidoList = new ArrayList<Producto>();
        Pedido.setCantidadProductosPedido(0);
        Pedido.setPrecioTotalPedido(0.00);

        MModel mModel = new MModel();
        mView = new MView(mModel, this);
        mController = new MController(mView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mView.cargarDatos();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_options_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menu_options_b_verPedido)
            mController.enviarPedido();

        if (item.getItemId() == R.id.menu_options_b_Logout)
            mController.logout();

        return super.onOptionsItemSelected(item);
    }
}

package com.example.ivan.tplaboratoriov.activities.menu.mvc;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.example.ivan.tplaboratoriov.R;
import com.example.ivan.tplaboratoriov.activities.menu.recycler.AdapterMenu;
import com.example.ivan.tplaboratoriov.clases_datos.Pedido;
import com.example.ivan.tplaboratoriov.clases_datos.Producto;

/**
 * Created by Ivan on 12/07/2017.
 */

public class MView {

    private MModel model;
    private Activity actMenu;

    private TextView tvPrecio;
    private TextView tvSeleccionados;
    private Button bEnviarPedido;
    private RecyclerView rvMenu;

    public MView(MModel model, Activity actMenu) {
        this.model = model;
        this.actMenu = actMenu;

        this.tvPrecio = (TextView) this.actMenu.findViewById(R.id.tv_precio);
        this.tvSeleccionados = (TextView) this.actMenu.findViewById(R.id.tv_seleccionados);
        this.bEnviarPedido = (Button) this.actMenu.findViewById(R.id.menu_b_enviar_pedido);
        this.rvMenu = (RecyclerView) this.actMenu.findViewById(R.id.menu_recycler);

        cargarDatos();


        LinearLayoutManager layoutManager = new LinearLayoutManager(this.actMenu);
        this.rvMenu.setLayoutManager(layoutManager);


        AdapterMenu adapterMenu = new AdapterMenu(Producto.productoList, this);
        this.rvMenu.setAdapter(adapterMenu);
    }

    public Activity getActMenu() {
        return actMenu;
    }

    public Button getbEnviarPedido() {
        return bEnviarPedido;
    }

    public void cargarDatos()
    {
        this.tvSeleccionados.setText(Pedido.getCantidadProductosPedido().toString());
        this.tvPrecio.setText(Pedido.getPrecioTotalPedido().toString());
    }
}

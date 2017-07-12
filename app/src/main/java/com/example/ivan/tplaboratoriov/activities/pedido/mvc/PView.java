package com.example.ivan.tplaboratoriov.activities.pedido.mvc;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.example.ivan.tplaboratoriov.R;
import com.example.ivan.tplaboratoriov.clases_datos.Pedido;

/**
 * Created by Ivan on 12/07/2017.
 */

public class PView {

    private PModel pModel;
    private Activity actPedido;

    private TextView tvPrecio;
    private TextView tvSeleccionados;
    private Button bEnviarPedido;
    private RecyclerView rvPedido;

    public PView(PModel pModel, Activity actPedido) {
        this.pModel = pModel;
        this.actPedido = actPedido;

        this.tvPrecio = (TextView) this.actPedido.findViewById(R.id.tv_precio);
        this.tvSeleccionados = (TextView) this.actPedido.findViewById(R.id.tv_seleccionados);
        this.bEnviarPedido = (Button) this.actPedido.findViewById(R.id.pedido_b_enviar_pedido);
        this.rvPedido = (RecyclerView) this.actPedido.findViewById(R.id.menu_recycler);

        cargarDatos();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.actPedido);
        this.rvPedido.setLayoutManager(linearLayoutManager);


    }

    public Activity getActPedido() {
        return actPedido;
    }

    public Button getbEnviarPedido() {
        return bEnviarPedido;
    }

    public RecyclerView getRvPedido() {
        return rvPedido;
    }

    public void cargarDatos()
    {
        this.tvSeleccionados.setText(Pedido.getCantidadProductosPedido().toString());
        this.tvPrecio.setText(Pedido.getPrecioTotalPedido().toString());
    }
}

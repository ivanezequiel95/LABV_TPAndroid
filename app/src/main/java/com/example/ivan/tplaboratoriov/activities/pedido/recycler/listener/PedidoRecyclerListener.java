package com.example.ivan.tplaboratoriov.activities.pedido.recycler.listener;

import android.view.View;

/**
 * Created by Ivan on 12/07/2017.
 */

public class PedidoRecyclerListener implements View.OnClickListener {

    IPedidoRecycler iPedidoRecycler;

    public PedidoRecyclerListener(IPedidoRecycler iPedidoRecycler) {
        this.iPedidoRecycler = iPedidoRecycler;
    }

    @Override
    public void onClick(View v) {
        iPedidoRecycler.quitarProductoPedido(v);
    }
}

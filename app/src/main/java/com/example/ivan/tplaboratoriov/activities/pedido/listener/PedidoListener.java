package com.example.ivan.tplaboratoriov.activities.pedido.listener;

import android.view.View;

/**
 * Created by Ivan on 12/07/2017.
 */

public class PedidoListener implements View.OnClickListener {

    private IPedido iPedido;

    public PedidoListener(IPedido iPedido) {
        this.iPedido = iPedido;
    }

    @Override
    public void onClick(View v) {
        this.iPedido.confirmarPedido(v);
    }
}

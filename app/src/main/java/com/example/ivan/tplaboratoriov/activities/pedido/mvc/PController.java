package com.example.ivan.tplaboratoriov.activities.pedido.mvc;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Toast;

import com.example.ivan.tplaboratoriov.R;
import com.example.ivan.tplaboratoriov.activities.pedido.listener.AlertDialogListener;
import com.example.ivan.tplaboratoriov.activities.pedido.listener.IPedido;
import com.example.ivan.tplaboratoriov.activities.pedido.listener.PedidoListener;
import com.example.ivan.tplaboratoriov.clases_datos.Pedido;

/**
 * Created by Ivan on 12/07/2017.
 */

public class PController implements IPedido {

    PView pView;

    public PController(PView pView) {
        this.pView = pView;

        PedidoListener pedidoListener = new PedidoListener(this);
        this.pView.getbEnviarPedido().setOnClickListener(pedidoListener);
    }

    @Override
    public void confirmarPedido(View view) {

        if (Pedido.getCantidadProductosPedido()>0)
        {
            Toast.makeText(this.pView.getActPedido(), this.pView.getActPedido().getString(R.string.pedido_dialogo_PedidoEnviado), Toast.LENGTH_SHORT).show();
            AlertDialog.Builder alertDialog = this.prepararAlertDialog();
            Pedido.unsetPedido();
            alertDialog.show();
        }else
            Toast.makeText(this.pView.getActPedido(), this.pView.getActPedido().getString(R.string.pedido_dialogo_ErrorPedido), Toast.LENGTH_SHORT).show();
    }

    private AlertDialog.Builder prepararAlertDialog(){
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this.pView.getActPedido());
        alertBuilder.setMessage(this.pView.getActPedido().getString(R.string.pedido_dialogo_Seleccionados)
                                +this.pView.getTvSeleccionados().getText().toString()
                                +"\n"
                                +this.pView.getActPedido().getString(R.string.pedido_dialogo_Precio)
                                +this.pView.getTvPrecio().getText().toString())
                .setTitle("Su pedido")
                .setNeutralButton("OK", new AlertDialogListener(this.pView.getActPedido()))
                .create();
        return alertBuilder;
    }
}

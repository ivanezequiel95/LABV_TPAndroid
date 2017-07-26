package com.example.ivan.tplaboratoriov.activities.pedido.mvc;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.ivan.tplaboratoriov.R;
import com.example.ivan.tplaboratoriov.activities.login.LoginActivity;
import com.example.ivan.tplaboratoriov.activities.pedido.listener.AlertDialogListener;
import com.example.ivan.tplaboratoriov.activities.pedido.listener.IPedido;
import com.example.ivan.tplaboratoriov.activities.pedido.listener.PedidoListener;
import com.example.ivan.tplaboratoriov.clases_datos.Pedido;
import com.example.ivan.tplaboratoriov.clases_datos.Producto;
import com.example.ivan.tplaboratoriov.clases_datos.Usuario;
import com.example.ivan.tplaboratoriov.conexion.HiloConnection;

/**
 * Created by Ivan on 12/07/2017.
 */

public class PController implements IPedido, Handler.Callback {

    PView pView;

    Handler handler;

    public PController(PView pView) {
        this.pView = pView;

        PedidoListener pedidoListener = new PedidoListener(this);
        this.pView.getbEnviarPedido().setOnClickListener(pedidoListener);

        this.handler = new Handler(this);
    }

    @Override
    public void click(View view) {
        if (view.getId() == this.pView.getbEnviarPedido().getId())
            if (Pedido.getCantidadProductosPedido()>0)
                confirmarPedido();
            else
                Toast.makeText(this.pView.getActPedido(), this.pView.getActPedido().getString(R.string.pedido_dialogo_ErrorPedido), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void confirmarPedido() {

        String stringJsonPost = "{"+
                "\"usuario\":"   + "\"" + Usuario.userActual.getMail()   + "\"," +
                "\"pedido\":[";


        for (int i=0; i < Pedido.getCantidadProductosPedido(); i++) {

            Producto p = Pedido.pedidoList.get(i);

            String producto = "{"+
                    "\"tipoMenu\":"   + "\""   + "UnTipo"               + "\"," +
                    "\"nombre\":"     + "\""   + p.getDescripcion()     + "\"," +
                    "\"precio\":"              + p.getPrecio()          + ","   ;


            if (i == Pedido.getCantidadProductosPedido()-1) {
                producto = producto.concat("\"imagen\":"     + "\""   + p.getUrlImagen()     + "\""  + "}");
                stringJsonPost = stringJsonPost.concat(producto);
                break;
            }

            producto = producto.concat("\"imagen\":"     + "\""   + p.getUrlImagen()     + "\""  + "},");
            stringJsonPost = stringJsonPost.concat(producto);
        }
        stringJsonPost = stringJsonPost.concat("]}");

        try {
            //Log.d("Mi Pedido:", stringJsonPost);
            Thread enviarPedidoThread = new Thread(new HiloConnection(this.handler, "pedidos/nuevo", "POST", stringJsonPost));
            enviarPedidoThread.start();
        }catch (Exception e){
            e.printStackTrace();
        }
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

    public void logout()
    {
        Pedido.unsetPedido();

        Intent intent = new Intent(this.pView.getActPedido(), LoginActivity.class);
        this.pView.getActPedido().startActivity(intent);
        this.pView.getActPedido().finish();
    }

    @Override
    public boolean handleMessage(Message msg) {


        if (msg.arg1 == 3)
        {
            String respuesta = (String) msg.obj;
            if (respuesta.equals("Se inserto correctamente"))
            {
                this.pView.limpiarPedido();
                Toast.makeText(this.pView.getActPedido(), this.pView.getActPedido().getString(R.string.pedido_dialogo_PedidoEnviado), Toast.LENGTH_SHORT).show();
            }else
                Toast.makeText(this.pView.getActPedido(), this.pView.getActPedido().getString(R.string.pedido_dialogo_ErrorPedido), Toast.LENGTH_SHORT).show();

        }
        if (msg.arg1 == 1000)
            Toast.makeText(this.pView.getActPedido(), "Error de conexion :(", Toast.LENGTH_SHORT).show();

        return true;
    }
}

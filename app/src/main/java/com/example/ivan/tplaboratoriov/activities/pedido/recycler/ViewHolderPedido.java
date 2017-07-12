package com.example.ivan.tplaboratoriov.activities.pedido.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ivan.tplaboratoriov.R;
import com.example.ivan.tplaboratoriov.activities.menu.mvc.MView;
import com.example.ivan.tplaboratoriov.activities.menu.recycler.listener.MenuRecyclerListener;
import com.example.ivan.tplaboratoriov.activities.pedido.mvc.PView;
import com.example.ivan.tplaboratoriov.activities.pedido.recycler.listener.IPedidoRecycler;
import com.example.ivan.tplaboratoriov.activities.pedido.recycler.listener.PedidoRecyclerListener;
import com.example.ivan.tplaboratoriov.clases_datos.Pedido;

/**
 * Created by Ivan on 12/07/2017.
 */

public class ViewHolderPedido extends RecyclerView.ViewHolder implements IPedidoRecycler{

    private PView pView;

    private TextView tvDescripcionProducto;
    private TextView tvPrecioProducto;
    private Button bQuitarProductoPedido;

    private Integer posicionItem;


    public ViewHolderPedido(View itemView) {
        super(itemView);

        this.tvDescripcionProducto = (TextView)this.itemView.findViewById(R.id.item_tv_descripcion);
        this.tvPrecioProducto = (TextView)this.itemView.findViewById(R.id.item_tv_precio);
        this.bQuitarProductoPedido = (Button)this.itemView.findViewById(R.id.item_pedido_b_quitar);

        PedidoRecyclerListener pedidoRecyclerListener = new PedidoRecyclerListener(this);

        this.bQuitarProductoPedido.setOnClickListener(pedidoRecyclerListener);
    }

    @Override
    public void quitarProductoPedido(View view) {

        this.posicionItem = this.getAdapterPosition();

        if (Pedido.borrarProductoPedido(Pedido.pedidoList.get(posicionItem)))
        {
            Toast.makeText(this.pView.getActPedido(), "Se quitó el elemento", Toast.LENGTH_SHORT).show();
            this.pView.cargarDatos();
            this.pView.getRvPedido().getAdapter().notifyItemRemoved(posicionItem);
        } else
            Toast.makeText(this.pView.getActPedido(), "No se pudo quitar", Toast.LENGTH_SHORT).show();
    }

    public void setpView(PView pView) {
        this.pView = pView;
    }

    public TextView getTvDescripcionProducto() {
        return tvDescripcionProducto;
    }

    public TextView getTvPrecioProducto() {
        return tvPrecioProducto;
    }
}

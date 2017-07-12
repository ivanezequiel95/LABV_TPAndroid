package com.example.ivan.tplaboratoriov.activities.pedido.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ivan.tplaboratoriov.R;
import com.example.ivan.tplaboratoriov.activities.pedido.mvc.PView;
import com.example.ivan.tplaboratoriov.clases_datos.Producto;

import java.util.List;

/**
 * Created by Ivan on 12/07/2017.
 */

public class AdapterPedido extends RecyclerView.Adapter<ViewHolderPedido> {

    private List<Producto> pedidoList;
    private PView pView;

    public AdapterPedido(List<Producto> pedidoList, PView pView) {
        this.pedidoList = pedidoList;
        this.pView = pView;
    }

    @Override
    public ViewHolderPedido onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pedido_layout, parent, false);
        ViewHolderPedido viewHolderPedido = new ViewHolderPedido(view);
        return viewHolderPedido;
    }

    @Override
    public void onBindViewHolder(ViewHolderPedido holder, int position) {
        holder.setpView(this.pView);
        Producto producto = this.pedidoList.get(position);
        holder.getTvDescripcionProducto().setText(producto.getDescripcion().toString());
        holder.getTvPrecioProducto().setText(producto.getPrecio().toString());
    }

    @Override
    public int getItemCount() {
        return this.pedidoList.size();
    }
}

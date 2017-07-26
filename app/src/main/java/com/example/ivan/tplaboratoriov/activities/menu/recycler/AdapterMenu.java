package com.example.ivan.tplaboratoriov.activities.menu.recycler;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ivan.tplaboratoriov.R;
import com.example.ivan.tplaboratoriov.activities.menu.mvc.MView;
import com.example.ivan.tplaboratoriov.clases_datos.Producto;

import java.util.List;

/**
 * Created by Ivan on 12/07/2017.
 */

public class AdapterMenu extends RecyclerView.Adapter<ViewHolderMenu> implements Handler.Callback{

    private List<Producto> productoList;
    private MView mView;

    Handler handler;

    public AdapterMenu(List<Producto> productoList, MView mView) {
        this.productoList = productoList;
        this.mView = mView;

        this.handler = new Handler(this);
    }

    @Override
    public ViewHolderMenu onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu_layout, parent, false);
        ViewHolderMenu viewHolderMenu = new ViewHolderMenu(view);
        return  viewHolderMenu;
    }

    @Override
    public void onBindViewHolder(ViewHolderMenu holder, int position) {
        holder.setmView(this.mView);
        Producto producto = this.productoList.get(position);
        holder.getTvDescripcionProducto().setText(producto.getDescripcion().toString());
        holder.getTvPrecioProducto().setText(producto.getPrecio().toString());
        holder.setPosicionItem(position);
    }

    @Override
    public int getItemCount() {
        return this.productoList.size();
    }









    @Override
    public boolean handleMessage(Message msg) {
        return false;
    }
}

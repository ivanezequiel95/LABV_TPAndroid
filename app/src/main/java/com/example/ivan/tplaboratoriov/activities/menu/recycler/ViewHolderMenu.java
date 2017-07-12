package com.example.ivan.tplaboratoriov.activities.menu.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ivan.tplaboratoriov.R;
import com.example.ivan.tplaboratoriov.activities.menu.mvc.MView;
import com.example.ivan.tplaboratoriov.activities.menu.recycler.listener.IMenuRecycler;
import com.example.ivan.tplaboratoriov.activities.menu.recycler.listener.MenuRecyclerListener;
import com.example.ivan.tplaboratoriov.clases_datos.Pedido;
import com.example.ivan.tplaboratoriov.clases_datos.Producto;

/**
 * Created by Ivan on 12/07/2017.
 */

public class ViewHolderMenu extends RecyclerView.ViewHolder implements IMenuRecycler{

    private MView mView;

    private TextView tvDescripcionProducto;
    private TextView tvPrecioProducto;
    private Button bAgregregarProductoPedido;

    private Integer posicionItem;


    public ViewHolderMenu(View itemView) {
        super(itemView);

        this.tvDescripcionProducto = (TextView)this.itemView.findViewById(R.id.item_menu_tv_descripcion);
        this.tvPrecioProducto = (TextView)this.itemView.findViewById(R.id.item_menu_tv_precio);
        this.bAgregregarProductoPedido = (Button)this.itemView.findViewById(R.id.item_menu_b_agregar);

        MenuRecyclerListener menuRecyclerListener = new MenuRecyclerListener(this);

        this.bAgregregarProductoPedido.setOnClickListener(menuRecyclerListener);
    }


    @Override
    public void agregarProductoPedido(View view) {

        this.posicionItem = this.getAdapterPosition();

        Pedido.agregarProductoPedido(Producto.productoList.get(this.posicionItem));

        //Pedido.actualizar();

        mView.cargarDatos();

    }

    public void setmView(MView mView) {
        this.mView = mView;
    }

    public TextView getTvDescripcionProducto() {
        return tvDescripcionProducto;
    }

    public TextView getTvPrecioProducto() {
        return tvPrecioProducto;
    }
}

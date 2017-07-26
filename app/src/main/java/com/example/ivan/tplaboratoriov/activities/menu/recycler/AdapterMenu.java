package com.example.ivan.tplaboratoriov.activities.menu.recycler;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ivan.tplaboratoriov.R;
import com.example.ivan.tplaboratoriov.activities.menu.mvc.MView;
import com.example.ivan.tplaboratoriov.clases_datos.Producto;
import com.example.ivan.tplaboratoriov.conexion.HiloConnection;
import com.example.ivan.tplaboratoriov.conexion.JSONParser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Ivan on 12/07/2017.
 */

public class AdapterMenu extends RecyclerView.Adapter<ViewHolderMenu> implements Handler.Callback{

    private MView mView;

    Handler handler;
    ExecutorService executorService;

    public AdapterMenu( MView mView) {
        this.mView = mView;


        Producto.productoList = new ArrayList<Producto>();
        this.handler = new Handler(this);
        this.executorService = Executors.newFixedThreadPool(5);

        this.setearListaProductos();//Inicia el seteo, la lista se setea en JSONParser
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
        Producto producto = Producto.productoList.get(position);
        holder.getTvDescripcionProducto().setText(producto.getDescripcion().toString());
        holder.getTvPrecioProducto().setText(producto.getPrecio().toString());
        holder.setPosicionItem(position);

        if (producto.getBytesImagen() != null)
        {
            try {
                Bitmap bitmap = BitmapFactory.decodeByteArray(producto.getBytesImagen(), 0, producto.getBytesImagen().length);
                holder.getIvMenu().setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else
        {
            this.descargarImagen(position);
        }
    }

    @Override
    public int getItemCount() {
        return Producto.productoList.size();
    }

    private void setearListaProductos()
    {
        try {
            Thread productosThread = new Thread(new HiloConnection(this.handler, "productos/", "GET"));
            productosThread.start();
        }catch (Exception e){
            e.printStackTrace();}
    }

    private void descargarImagen(Integer position)
    {
        String imagenURL = Producto.productoList.get(position).getUrlImagen();
        Thread descargaImagenThread = new Thread(new HiloConnection(this.handler, imagenURL, position, "IMAGEN"));
        this.executorService.execute(descargaImagenThread);
    }

    @Override
    public boolean handleMessage(Message msg) {

        if (msg.arg1 == 1)
        {
            Producto.productoList = JSONParser.getProductos((String) msg.obj);
            this.notifyDataSetChanged();
        }
        if (msg.arg1 == 2)
        {
            byte[] imagenBytes = (byte[]) msg.obj;
            Producto.productoList.get(msg.arg2).setBytesImagen(imagenBytes);
            this.notifyItemChanged(msg.arg2);
        }
        if (msg.arg1 == 1000)
        {
            Toast.makeText(this.mView.getActMenu(), "Error de conexion o no sé", Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}

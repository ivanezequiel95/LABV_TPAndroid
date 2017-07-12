package com.example.ivan.tplaboratoriov.activities.menu.mvc;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ivan.tplaboratoriov.R;
import com.example.ivan.tplaboratoriov.activities.login.LoginActivity;
import com.example.ivan.tplaboratoriov.activities.menu.listener.IMenu;
import com.example.ivan.tplaboratoriov.activities.menu.listener.MenuListener;
import com.example.ivan.tplaboratoriov.activities.pedido.PedidoActivity;
import com.example.ivan.tplaboratoriov.clases_datos.Pedido;

/**
 * Created by Ivan on 12/07/2017.
 */

public class MController implements IMenu{

    MView mView;

    public MController(MView mView) {
        this.mView = mView;

        MenuListener menuListener = new MenuListener(this);
        this.mView.getbEnviarPedido().setOnClickListener(menuListener);
    }

    @Override
    public void enviarPedido() {
        Toast.makeText(this.mView.getActMenu(), "Se está mostrando su pedido", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this.mView.getActMenu(), PedidoActivity.class);
        this.mView.getActMenu().startActivity(intent);
    }

    @Override
    public void click(View view) {
        if (view.getId() == this.mView.getbEnviarPedido().getId())
            enviarPedido();
    }

    public void logout()
    {
        Pedido.unsetPedido();

        Intent intent = new Intent(this.mView.getActMenu(), LoginActivity.class);
        this.mView.getActMenu().startActivity(intent);

        this.mView.getActMenu().finish();
    }


}

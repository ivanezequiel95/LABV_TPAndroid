package com.example.ivan.tplaboratoriov.activities.menu.recycler.listener;

import android.view.View;

/**
 * Created by Ivan on 12/07/2017.
 */

public class MenuRecyclerListener implements View.OnClickListener{

    IMenuRecycler iMenuRecycler;

    public MenuRecyclerListener(IMenuRecycler iMenuRecycler) {
        this.iMenuRecycler = iMenuRecycler;
    }

    @Override
    public void onClick(View v) {
        iMenuRecycler.agregarProductoPedido(v);
    }
}

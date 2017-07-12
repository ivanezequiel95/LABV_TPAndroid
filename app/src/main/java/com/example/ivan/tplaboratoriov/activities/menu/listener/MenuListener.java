package com.example.ivan.tplaboratoriov.activities.menu.listener;

import android.view.View;

/**
 * Created by Ivan on 12/07/2017.
 */

public class MenuListener implements View.OnClickListener {

    IMenu iMenu;

    public MenuListener(IMenu iMenu) {
        this.iMenu = iMenu;
    }

    @Override
    public void onClick(View v) {
        iMenu.click(v);
    }
}

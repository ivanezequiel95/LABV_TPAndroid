package com.example.ivan.tplaboratoriov.activities.pedido.listener;

import android.app.Activity;
import android.content.DialogInterface;

/**
 * Created by Ivan on 12/07/2017.
 */

public class AlertDialogListener implements DialogInterface.OnClickListener {

    Activity context;

    public AlertDialogListener(Activity context) {
        this.context = context;
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        context.finish();
    }
}

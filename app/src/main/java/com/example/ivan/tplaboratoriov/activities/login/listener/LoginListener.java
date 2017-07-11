package com.example.ivan.tplaboratoriov.activities.login.listener;

import android.view.View;

/**
 * Created by Ivan on 11/07/2017.
 */

public class LoginListener implements View.OnClickListener{

    private ILogin iLogin;

    public LoginListener(ILogin iLogin) {
        this.iLogin = iLogin;
    }

    @Override
    public void onClick(View v) {
        this.iLogin.clickBtn(v);
    }
}

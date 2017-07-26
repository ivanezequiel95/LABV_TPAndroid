package com.example.ivan.tplaboratoriov.conexion;

import android.os.Handler;
import android.os.Message;

/**
 * Created by Ivan on 25/07/2017.
 */

public class HiloConnection implements Runnable {

    private Handler handler;
    private String strUrl;
    private Integer posicionLista;
    private String request;


    /**
     * Para un Get
     *
     * @param handler
     * @param strUrl
     * @param request
     */
    public HiloConnection(Handler handler, String strUrl, String request) {
        this.handler = handler;
        this.strUrl = strUrl;
        this.request = request;
    }


    /**
     * Para una imagen
     *
     * @param handler
     * @param strUrl
     * @param posicionLista
     * @param request
     */
    public HiloConnection(Handler handler, String strUrl, Integer posicionLista, String request) {
        this.handler = handler;
        this.strUrl = strUrl;
        this.posicionLista = posicionLista;
        this.request = request;
    }

    @Override
    public void run() {

        if (Thread.currentThread().isInterrupted())
            return;

        Message message = new Message();

        try {

            HttpManager httpManager = new HttpManager(this.strUrl);
            if (httpManager.notNull())
            {
                if (this.request.equals("GET"))
                {
                    message.arg1 = 1;
                    message.obj = httpManager.getStrDataByGET();
                }

                if (this.request.equals("IMAGEN"))
                {
                    message.arg1 = 2;
                    message.arg2 = this.posicionLista;
                    message.obj = httpManager.getBytesDataByGET();
                }
                if (this.request.equals("POST"))
                {

                }
            }

            this.handler.sendMessage(message);

        }catch (Exception e)
        {
            message.arg1 = 1000;
            this.handler.sendMessage(message);
        }

    }
}

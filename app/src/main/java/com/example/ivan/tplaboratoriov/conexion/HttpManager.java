package com.example.ivan.tplaboratoriov.conexion;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Ivan on 25/07/2017.
 */

public class HttpManager {

    private HttpURLConnection connection;

    HttpManager(String url){
        if (!url.contains("http"))
            url = "http://192.168.0.7:3000/" + url;
        this.connection = getConnection(url);
    }

    private HttpURLConnection getConnection(String stringUrl)
    {
        URL urlx;
        try {
            urlx = new URL(stringUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) urlx.openConnection();
            urlConnection.setReadTimeout(5000);
            urlConnection.setConnectTimeout(10000);
            return urlConnection;
        } catch (MalformedURLException e){
            e.printStackTrace();
        }
        catch (IOException e2) {
            e2.printStackTrace();
        }
        return  null;
    }

    boolean notNull()
    {
        return this.connection!=null;
    }

    private byte[] readFully(InputStream inputStream) throws IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length = 0;

        while ((length = inputStream.read(buffer)) != -1) {
            baos.write(buffer, 0, length);
        }
        inputStream.close();
        return baos.toByteArray();
    }

    byte[] getBytesDataByGET() throws IOException {

        this.connection.setRequestMethod("GET");
        this.connection.connect();
        int response = this.connection.getResponseCode();

        if(response==200) {
            InputStream is = this.connection.getInputStream();
            return readFully(is);
        }
        else
            throw new IOException();
    }

    public String getStrDataByGET() throws IOException {

        byte[] bytes = getBytesDataByGET();
        return new String(bytes, "UTF-8");
    }

    String getStrDataByPOST(String stringJsonPost) throws IOException {

        byte[] bytes = getBytesDataByPOST(stringJsonPost);
        return new String(bytes, "UTF-8");
    }

    private byte[] getBytesDataByPOST(String stringJsonPost) throws IOException {

        this.connection.setRequestMethod("POST");
        this.connection.setDoOutput(true);

        this.connection.setRequestProperty("Content-Type", "application/json");
        this.connection.connect();

        OutputStream os = this.connection.getOutputStream();
        os.write(stringJsonPost.getBytes());
        os.flush();

        int response = this.connection.getResponseCode();

        if(response==200) {
            InputStream is = this.connection.getInputStream();
            return readFully(is);
        }
        else
            throw new IOException();
    }
}

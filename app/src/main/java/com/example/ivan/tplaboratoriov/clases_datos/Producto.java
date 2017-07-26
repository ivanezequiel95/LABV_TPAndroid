package com.example.ivan.tplaboratoriov.clases_datos;

import java.util.List;

/**
 * Created by Ivan on 12/07/2017.
 */

public class Producto {

    private String descripcion;
    private Double precio;
    private String urlImagen;

    private byte[] bytesImagen;


    public static List<Producto> productoList;

    public Producto(String descripcion, Double precio, String urlImagen) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.urlImagen = urlImagen;

        this.bytesImagen = null;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public byte[] getBytesImagen() {
        return bytesImagen;
    }

    public void setBytesImagen(byte[] bytesImagen) {
        this.bytesImagen = bytesImagen;
    }
}

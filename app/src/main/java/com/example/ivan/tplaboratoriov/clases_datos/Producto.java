package com.example.ivan.tplaboratoriov.clases_datos;

import java.util.List;

/**
 * Created by Ivan on 12/07/2017.
 */

public class Producto {

    private String descripcion;
    private Double precio;

    public static List<Producto> productoList;

    public Producto(String descripcion, Double precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getPrecio() {
        return precio;
    }
}

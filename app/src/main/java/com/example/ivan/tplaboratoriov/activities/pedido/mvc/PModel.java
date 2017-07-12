package com.example.ivan.tplaboratoriov.activities.pedido.mvc;

/**
 * Created by Ivan on 12/07/2017.
 */

public class PModel {

    private Double precioEstimado;
    private Integer seleccionados;

    public PModel() {
    }

    public PModel(Double precioEstimado, Integer seleccionados) {
        this.precioEstimado = precioEstimado;
        this.seleccionados = seleccionados;
    }

    public Double getPrecioEstimado() {
        return precioEstimado;
    }

    public void setPrecioEstimado(Double precioEstimado) {
        this.precioEstimado = precioEstimado;
    }

    public Integer getSeleccionados() {
        return seleccionados;
    }

    public void setSeleccionados(Integer seleccionados) {
        this.seleccionados = seleccionados;
    }
}

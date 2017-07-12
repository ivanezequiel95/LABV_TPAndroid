package com.example.ivan.tplaboratoriov.clases_datos;

import java.util.List;

/**
 * Created by Ivan on 12/07/2017.
 */

public class Pedido {

    private static Integer cantidadProductosPedido;
    private static Double precioTotalPedido;

    public static List<Producto> pedidoList;

    public static void setCantidadProductosPedido(Integer cantidadProductosPedido) {
        Pedido.cantidadProductosPedido = cantidadProductosPedido;
    }

    public static void setPrecioTotalPedido(Double precioTotalPedido) {
        Pedido.precioTotalPedido = precioTotalPedido;
    }

    public static boolean agregarProductoPedido(Producto producto)
    {
        if (Pedido.pedidoList.add(producto)) {
            actualizar();
            return true;
        }
        else
            return false;
    }

    public static boolean borrarProductoPedido(Producto producto)
    {
        if (pedidoList.remove(producto))
        {
            actualizar();
            return true;
        }else
            return false;
    }


    public static void unsetPedido()
    {
        cantidadProductosPedido = Integer.valueOf(0);
        precioTotalPedido = Double.valueOf(0.00);
        pedidoList.clear();
    }


    private static void actualizar()
    {
        cantidadProductosPedido = getCantidadProductosPedido();
        precioTotalPedido = getPrecioTotalPedido();
    }
    public static Double getPrecioTotalPedido()
    {
        Double auxTotal = 0.00;
        if (Pedido.pedidoList.size()>0)
            for (Producto p : Pedido.pedidoList)
                auxTotal = auxTotal + p.getPrecio();
        return auxTotal;
    }
    public static Integer getCantidadProductosPedido()
    {
        if (Pedido.pedidoList.size() > 0)
            return Pedido.pedidoList.size();
        else
            return 0;
    }

}

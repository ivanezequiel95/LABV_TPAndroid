package com.example.ivan.tplaboratoriov.conexion;

import com.example.ivan.tplaboratoriov.clases_datos.Producto;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 26/07/2017.
 */

public class JSONParser {

    public static boolean parseRespuestaLogin(String str)
    {
        try {

            JSONObject jsonObject = new JSONObject(str.substring(str.indexOf("{"), str.lastIndexOf("}")+1));

            if (jsonObject.getInt("codigo") == 200)
                return true;
            if (jsonObject.getInt("codigo") == 400)
                return false;

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    //Este metodo si setea la lista
    public static List<Producto> getProductos(String str)
    {
        List<Producto> productoList = new ArrayList<Producto>();


        try {
            String arrayProductos = "{ productos: ";
            arrayProductos = arrayProductos.concat(str + " }");

            JSONObject jsonObject = new JSONObject(arrayProductos);

            JSONArray productos = jsonObject.getJSONArray("productos");

            for (int i = 0 ; i < productos.length() ; i++)
            {
                JSONObject unProducto = productos.getJSONObject(i);

                String descripcion = unProducto.getString("nombre");
                Double precio = unProducto.getDouble("precio");
                String urlImagen = unProducto.getString("imagen");

                Producto p = new Producto(descripcion, precio, urlImagen);
                productoList.add(p);
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return productoList;
    }

    public static boolean parseRespuestaValidacionUsuario(String str)
    {
        try {

            String strResultadoBusqueda = "{ resultado: ";
            strResultadoBusqueda = strResultadoBusqueda.concat(str + " }");

            JSONObject jsonObject = new JSONObject(strResultadoBusqueda);
            JSONArray resultadoArray = jsonObject.getJSONArray("resultado");

            if (resultadoArray.length() == 0)
                return true;
            else
                return false;

        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public static boolean parseRespuestaRegistroUsuario(String str)
    {
        try {
            JSONObject jsonObject = new JSONObject(str.substring(str.indexOf("{"), str.lastIndexOf("}")+1));
            if (jsonObject.getString("mensaje").equals("Se inserto correctamente"))
                return true;
            else
                return false;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}

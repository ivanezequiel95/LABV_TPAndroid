package com.example.ivan.tplaboratoriov.conexion;

import org.json.JSONObject;

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


}

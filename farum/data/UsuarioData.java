package com.teamcjz.farum.data;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.teamcjz.farum.model.Usuario;
import com.teamcjz.farum.util.Constantes;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class UsuarioData {


    private String LoginURL = Constantes.BASEURL + "Usuario/Login";

    private String CrearCuentaURL = Constantes.BASEURL + "Usuario/";


    public void getCredenciales(FarumRequestQueue requestQueue, final Usuario credenciales, OnLoginSuccess callback){

        Map<String, String> params = new HashMap<String, String>();
        params.put("Correo", credenciales.getCorreo());
        params.put("Contrasenia", credenciales.getContrasenia());
        JSONObject jsonObject = new JSONObject(params);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, LoginURL, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d("Usuario data", response.toString());


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d("Usuario data", error.toString());
            }
        });

        requestQueue.addToReqquestQueue(request);
    }



    public void CrearCuenta(FarumRequestQueue requestQueue, final Usuario usuario, final OnCrearCuenta callback){


        //JSONObject objParametros = new JSONObject(params);

        StringRequest request = new StringRequest(Request.Method.POST, CrearCuentaURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callback.procesaCuenta();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d("Usuario data", error.toString());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Correo", usuario.getCorreo());
                params.put("Contrasenia", usuario.getContrasenia());
                params.put("Nombre", usuario.getNombre());
                return params;
            }
        };

        requestQueue.addToReqquestQueue(request);

    }



    public interface OnLoginSuccess{

        void procesaLogin(Usuario usuario);

    }

    public interface OnCrearCuenta{
        void procesaCuenta();
    }

}

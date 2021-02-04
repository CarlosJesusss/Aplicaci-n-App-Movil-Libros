package com.teamcjz.farum.interfaces;

import com.teamcjz.farum.model.Usuario;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UsuarioRetroFit {

    @POST("Usuario")
    Call<Void> CrearCuenta(@Body Usuario usuario);

    @POST("Usuario/Login/")
    Call<Usuario> Login(@Body Usuario usuario);

}

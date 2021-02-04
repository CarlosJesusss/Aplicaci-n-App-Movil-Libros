package com.teamcjz.farum.model;

public class Usuario {

    public int IdUsuario;
    public String Nombre;
    public String Correo;
    public String Telefono;
    public String Contrasenia;
    public String Direccion;
    public String Activo;

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.IdUsuario = idUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        this.Correo = correo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        this.Telefono = telefono;
    }

    public String getContrasenia() {
        return Contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.Contrasenia = contrasenia;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getActivo() {
        return Activo;
    }

    public void setActivo(String activo) {
        this.Activo = activo;
    }
}

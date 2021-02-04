package com.teamcjz.farum.model;

import java.util.Date;

public class Intercambio {

    private int idIntercambio;
    private int idUsuIni;
    private int idUsuDestino;
    private String direccion;
    private Date fechaIniciado;
    private Date fechaIntercambio;
    private int idLibroElegido;
    private int idLibroOfrecido;
    private String activo;
    private String estado;
    private String horaIntercambio;

    private Libro libroElegido;
    private Libro libroOfrecido;
    private Usuario usuInicial;
    private Usuario usuDestino;

    public Intercambio(){
        libroElegido = new Libro();
        libroOfrecido = new Libro();
        usuInicial = new Usuario();
        usuDestino = new Usuario();
    }


    public int getIdIntercambio() {
        return idIntercambio;
    }

    public void setIdIntercambio(int idIntercambio) {
        this.idIntercambio = idIntercambio;
    }

    public int getIdUsuIni() {
        return idUsuIni;
    }

    public void setIdUsuIni(int idUsuIni) {
        this.idUsuIni = idUsuIni;
    }

    public int getIdUsuDestino() {
        return idUsuDestino;
    }

    public void setIdUsuDestino(int idUsuDestino) {
        this.idUsuDestino = idUsuDestino;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaIniciado() {
        return fechaIniciado;
    }

    public void setFechaIniciado(Date fechaIniciado) {
        this.fechaIniciado = fechaIniciado;
    }

    public Date getFechaIntercambio() {
        return fechaIntercambio;
    }

    public void setFechaIntercambio(Date fechaIntercambio) {
        this.fechaIntercambio = fechaIntercambio;
    }

    public int getIdLibroElegido() {
        return idLibroElegido;
    }

    public void setIdLibroElegido(int idLibroElegido) {
        this.idLibroElegido = idLibroElegido;
    }

    public int getIdLibroOfrecido() {
        return idLibroOfrecido;
    }

    public void setIdLibroOfrecido(int idLibroOfrecido) {
        this.idLibroOfrecido = idLibroOfrecido;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getHoraIntercambio() {
        return horaIntercambio;
    }

    public void setHoraIntercambio(String horaIntercambio) {
        this.horaIntercambio = horaIntercambio;
    }

    public Libro getLibroElegido() {
        return libroElegido;
    }

    public void setLibroElegido(Libro libroElegido) {
        this.libroElegido = libroElegido;
    }

    public Libro getLibroOfrecido() {
        return libroOfrecido;
    }

    public void setLibroOfrecido(Libro libroOfrecido) {
        this.libroOfrecido = libroOfrecido;
    }

    public Usuario getUsuInicial() {
        return usuInicial;
    }

    public void setUsuInicial(Usuario usuInicial) {
        this.usuInicial = usuInicial;
    }

    public Usuario getUsuDestino() {
        return usuDestino;
    }

    public void setUsuDestino(Usuario usuDestino) {
        this.usuDestino = usuDestino;
    }
}

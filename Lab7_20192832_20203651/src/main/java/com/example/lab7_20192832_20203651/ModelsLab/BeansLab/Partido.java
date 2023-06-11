package com.example.lab7_20192832_20203651.ModelsLab.BeansLab;

import java.util.Date;

public class Partido {

    private int idPartido;

    private Date fechapartido;

    private int numeroJornada;

    private Seleccion seleccionTabla;
    private Seleccion seleccionLocal;

    private Seleccion seleccionVisitante;


    private Arbitro arbitropartido;

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public Date getFechapartido() {
        return fechapartido;
    }

    public void setFechapartido(Date fechapartido) {
        this.fechapartido = fechapartido;
    }

    public int getNumeroJornada() {
        return numeroJornada;
    }

    public void setNumeroJornada(int numeroJornada) {
        this.numeroJornada = numeroJornada;
    }

    public Seleccion getSeleccionTabla() {
        return seleccionTabla;
    }

    public void setSeleccionTabla(Seleccion seleccionTabla) {
        this.seleccionTabla = seleccionTabla;
    }

    public Seleccion getSeleccionLocal() {
        return seleccionLocal;
    }

    public void setSeleccionLocal(Seleccion seleccionLocal) {
        this.seleccionLocal = seleccionLocal;
    }

    public Seleccion getSeleccionVisitante() {
        return seleccionVisitante;
    }

    public void setSeleccionVisitante(Seleccion seleccionVisitante) {
        this.seleccionVisitante = seleccionVisitante;
    }

    public Arbitro getArbitropartido() {
        return arbitropartido;
    }

    public void setArbitropartido(Arbitro arbitropartido) {
        this.arbitropartido = arbitropartido;
    }
}





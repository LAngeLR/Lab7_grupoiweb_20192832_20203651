package com.example.lab7_20192832_20203651.ModelsLab.BeansLab;

import java.util.Date;

public class Partido {


    private int idPartido;
    private Date fechapartido;
    private int numeroJornada;
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

    public Arbitro getArbitropartido() {
        return arbitropartido;
    }
    public void setArbitropartido(Arbitro arbitropartido) {
        this.arbitropartido = arbitropartido;
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
}






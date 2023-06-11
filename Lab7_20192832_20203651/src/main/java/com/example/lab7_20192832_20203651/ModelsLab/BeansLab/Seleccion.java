package com.example.lab7_20192832_20203651.ModelsLab.BeansLab;

public class Seleccion {

    private int idSeleccion;
    private String nombreSeleccion;
    private String tecnicoSeleccion;
    private Estadio estadio;

    public int getIdSeleccion() {
        return idSeleccion;
    }

    public void setIdSeleccion(int idSeleccion) {
        this.idSeleccion = idSeleccion;
    }

    public String getNombreSeleccion() {
        return nombreSeleccion;
    }

    public void setNombreSeleccion(String nombreSeleccion) {
        this.nombreSeleccion = nombreSeleccion;
    }

    public String getTecnicoSeleccion() {
        return tecnicoSeleccion;
    }

    public void setTecnicoSeleccion(String tecnicoSeleccion) {
        this.tecnicoSeleccion = tecnicoSeleccion;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }
}

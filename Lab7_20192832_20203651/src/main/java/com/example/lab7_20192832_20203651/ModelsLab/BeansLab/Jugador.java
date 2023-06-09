package com.example.lab7_20192832_20203651.ModelsLab.BeansLab;

public class Jugador {

    private int idJugador;
    private String nombreJugador;
    private int edadJugador;
    private String posicionJugador;
    private String clubJugador;
    private Seleccion seleccion;

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getEdadJugador() {
        return edadJugador;
    }

    public void setEdadJugador(int edadJugador) {
        this.edadJugador = edadJugador;
    }

    public String getPosicionJugador() {
        return posicionJugador;
    }

    public void setPosicionJugador(String posicionJugador) {
        this.posicionJugador = posicionJugador;
    }

    public String getClubJugador() {
        return clubJugador;
    }

    public void setClubJugador(String clubJugador) {
        this.clubJugador = clubJugador;
    }

    public Seleccion getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(Seleccion seleccion) {
        this.seleccion = seleccion;
    }
}

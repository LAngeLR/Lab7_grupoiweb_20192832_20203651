package com.example.lab7_20192832_20203651.ModelsLab.Daos.Lab;

import com.example.lab7_20192832_20203651.ModelsLab.BeansLab.Jugador;
import com.example.lab7_20192832_20203651.ModelsLab.BeansLab.Seleccion;

import java.lang.reflect.Array;
import java.sql.*;
import java.util.ArrayList;

public class JugadoresDao extends BaseDao {
    public ArrayList<Jugador> listarJugadores(){
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        String sql = "select idJugador, j.nombre,edad,posicion,club, s.nombre as \"Seleccion\"\n" +
                "from jugador j\n" +
                "inner join seleccion s on j.sn_idSeleccion = s.idSeleccion;";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Jugador jugador = new Jugador();
                jugador.setIdJugador(rs.getInt(1));
                jugador.setNombreJugador(rs.getString(2));
                jugador.setEdadJugador(rs.getInt(3));
                jugador.setPosicionJugador(rs.getString(4));
                jugador.setClubJugador(rs.getString(5));

                Seleccion seleccion = new Seleccion();
                seleccion.setNombreSeleccion(rs.getString(6));

                jugador.setSeleccion(seleccion);

                listaJugadores.add(jugador);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listaJugadores;
    }

    public void crearJugador(Jugador jugador){
        String sql = "INSERT INTO jugador (nombre,edad,posicion,club,sn_idSeleccion) VALUES (?,?,?,?,?)";

        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {


             pstmt.setString(1,jugador.getNombreJugador());
             pstmt.setInt(2,jugador.getEdadJugador());
             pstmt.setString(3,jugador.getPosicionJugador());
             pstmt.setString(4,jugador.getClubJugador());
             pstmt.setString(5,jugador.getSeleccion().getNombreSeleccion());
             pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

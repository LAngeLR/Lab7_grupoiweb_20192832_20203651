package com.example.lab7_20192832_20203651.ModelsLab.Daos.Lab;

import com.example.lab7_20192832_20203651.ModelsLab.BeansLab.Estadio;
import com.example.lab7_20192832_20203651.ModelsLab.BeansLab.Jugador;
import com.example.lab7_20192832_20203651.ModelsLab.BeansLab.Seleccion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SeleccionesDao extends BaseDao{

    public ArrayList<Seleccion> listarSelecciones(){
        ArrayList<Seleccion> listaSelecciones = new ArrayList<>();

        String sql = "select * from seleccion;";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Seleccion seleccion = new Seleccion();
                seleccion.setIdSeleccion(rs.getInt(1));
                seleccion.setNombreSeleccion(rs.getString(2));
                seleccion.setTecnicoSeleccion(rs.getString(3));

                listaSelecciones.add(seleccion);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listaSelecciones;
    }
}

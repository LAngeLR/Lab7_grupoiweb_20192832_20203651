package com.example.lab7_20192832_20203651.ModelsLab.Daos.Lab;

import com.example.lab7_20192832_20203651.ModelsLab.BeansLab.Estadio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EstadiosDao extends BaseDao{

    public ArrayList<Estadio> listarEstadios() {

        java.util.ArrayList<Estadio> estadios = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM estadio")) {

            while (rs.next()) {
                Estadio estadio = new Estadio();

                estadio.setIdEstadio(rs.getInt(1));
                estadio.setNombreEstadio(rs.getString(2));

                estadios.add(estadio);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

        return estadios;
    }
}
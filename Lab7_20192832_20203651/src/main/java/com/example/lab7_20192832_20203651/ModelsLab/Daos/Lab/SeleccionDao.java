package com.example.lab7_20192832_20203651.ModelsLab.Daos.Lab;

import com.example.lab7_20192832_20203651.ModelsLab.BeansLab.Estadio;
import com.example.lab7_20192832_20203651.ModelsLab.BeansLab.Seleccion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SeleccionDao extends BaseDao {

    public ArrayList<Partido> listaDeSelecciones() {

        ArrayList<Partido> selecciones = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT\n" +
                     "  s.idSeleccion,\n" +
                     "  s.nombre AS \"nombre_seleccion\",\n" +
                     "  e.nombre AS \"nombre_estadio\",\n" +
                     "  p.fecha AS \"fecha\",\n" +
                     "  s_visitante.nombre AS \"nombre_seleccion_visitante\",\n" +
                     "  s_local.nombre AS \"nombre_seleccion_local\"\n" +
                     "FROM\n" +
                     "  seleccion s\n" +
                     "JOIN\n" +
                     "  estadio e ON s.estadio_idEstadio = e.idEstadio\n" +
                     "JOIN\n" +
                     "  partido p ON (s.idSeleccion = p.seleccionVisitante OR s.idSeleccion = p.seleccionLocal)\n" +
                     "JOIN\n" +
                     "  seleccion s_visitante ON p.seleccionVisitante = s_visitante.idSeleccion\n" +
                     "JOIN\n" +
                     "  seleccion s_local ON p.seleccionLocal = s_local.idSeleccion\n" +
                     "JOIN\n" +
                     "  (\n" +
                     "    SELECT\n" +
                     "      s.idSeleccion,\n" +
                     "      MIN(p.fecha) AS min_fecha\n" +
                     "    FROM\n" +
                     "      seleccion s\n" +
                     "    JOIN\n" +
                     "      partido p ON s.idSeleccion = p.seleccionVisitante OR s.idSeleccion = p.seleccionLocal\n" +
                     "    GROUP BY\n" +
                     "      s.idSeleccion\n" +
                     "  ) subquery ON s.idSeleccion = subquery.idSeleccion AND p.fecha = subquery.min_fecha\n" +
                     "ORDER BY\n" +
                     "  p.fecha ASC")) {

            while (rs.next()) {

                Partido partido = new Partido();

                Seleccion seleccion = new Seleccion();
                seleccion.setIdSeleccion(rs.getInt(1));
                seleccion.setNombreSeleccion(rs.getString(2));
                seleccion.setTecnicoSeleccion(rs.getString(3));

                Estadio estadio = new Estadio();
                estadio.setNombreEstadio(rs.getString(4));

                Seleccion seleccionLocal = new Seleccion();
                seleccionLocal.setNombreSeleccion(rs.getString(5));

                Seleccion seleccionVisitante = new Seleccion();
                seleccionVisitante.setNombreSeleccion(rs.getString(6));






                Seleccion seleccion = new Seleccion();

                seleccion.setIdSeleccion(rs.getInt(1));
                seleccion.setNombreSeleccion(rs.getString(2));
                seleccion.setTecnicoSeleccion(rs.getString(3));

                Estadio estadio = new Estadio();
                estadio.setIdEstadio(rs.getInt(4));
                estadio.setNombreEstadio(rs.getString(5));

                Partido partido = new Partido();
                partido.setSeleccionLocal(rs.getInt(6));
                partido.setSeleccionVisitante(rs.getInt(7));






                Estadio estadio = new Estadio();
                estadio.setIdEstadio(rs.getInt(10));
                estadio.setNombre(rs.getString(19));
                estadio.setProvincia(rs.getString(20));

                Seleccion seleccionLocal = new Seleccion();
                seleccionLocal.setIdSeleccion(rs.getInt(7));
                seleccionLocal.setNombre(rs.getString(8));
                seleccionLocal.setTecnico(rs.getString(9));
                seleccionLocal.setEstadio(estadio);
                partido.setSeleccionLocal(seleccionLocal);

                Seleccion seleccionVisitante = new Seleccion();
                seleccionVisitante.setIdSeleccion(rs.getInt(11));
                seleccionVisitante.setNombre(rs.getString(12));
                seleccionVisitante.setTecnico(rs.getString(13));
                partido.setSeleccionVisitante(seleccionVisitante);

                Arbitro arbitro = new Arbitro();
                arbitro.setIdArbitro(rs.getInt(15));
                arbitro.setNombre(rs.getString(16));
                arbitro.setPais(rs.getString(17));
                partido.setArbitro(arbitro);

                partidos.add(partido);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return partidos;
    }
}

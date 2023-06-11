package com.example.lab7_20192832_20203651.ModelsLab.Daos.Lab;
import com.example.lab7_20192832_20203651.ModelsLab.BeansLab.Partido;
import com.example.lab7_20192832_20203651.ModelsLab.BeansLab.Estadio;
import com.example.lab7_20192832_20203651.ModelsLab.BeansLab.Seleccion;

import java.sql.*;
import java.util.ArrayList;

public class SeleccionDao extends BaseDao {

    public ArrayList<Partido> listaDeSelecciones() {

        ArrayList<Partido> selecciones = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT\n" +
                             "  s.idSeleccion,\n" +
                             "  s.nombre AS \"nombre_seleccion\",\n" +
                             "  s.tecnico,\n" +
                             "  e.idEstadio,\n" +
                             "  e.nombre AS \"nombre_estadio\",\n" +
                             "  p.fecha AS \"fecha\",\n" +
                             "  s_visitante.idSeleccion,\n" +
                             "  s_visitante.nombre AS \"nombre_seleccion_visitante\",\n" +
                             "  s_local.idSeleccion,\n" +
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
                partido.setSeleccionTabla(seleccion);

                Estadio estadio = new Estadio();
                estadio.setIdEstadio(rs.getInt(4));
                estadio.setNombreEstadio(rs.getString(5));
                seleccion.setEstadio(estadio);

                Seleccion seleccionLocal = new Seleccion();
                seleccionLocal.setIdSeleccion(9);
                seleccionLocal.setNombreSeleccion(rs.getString(10));
                partido.setSeleccionLocal(seleccionLocal);

                Seleccion seleccionVisitante = new Seleccion();
                seleccionVisitante.setIdSeleccion(rs.getInt(7));
                seleccionVisitante.setNombreSeleccion(rs.getString(8));
                partido.setSeleccionVisitante(seleccionVisitante);

                selecciones.add(partido);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return selecciones;
    }

    public void crearPartido(Partido partido) {

        String sql1 = "INSERT INTO seleccion(idSeleccion,nombre, tecnico,estadio_idEstadio) VALUES (?, ?, ?);";
        String sql2 = "INSERT INTO estadio(idEstadio,nombre,provincia,club) VALUES (?,?,?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmtPartido = conn.prepareStatement(sql1);
             PreparedStatement pstmtEstadio = conn.prepareStatement(sql2)){

            pstmtPartido.setInt(1, partido.getSeleccionTabla().getIdSeleccion());
            pstmtPartido.setString(2, partido.getSeleccionTabla().getNombreSeleccion());
            pstmtPartido.setString(3, partido.getSeleccionTabla().getTecnicoSeleccion());
            pstmtPartido.setInt(4,partido.getSeleccionTabla().getEstadio().getIdEstadio());

            pstmtEstadio.setInt(1, partido.getSeleccionTabla().getEstadio().getIdEstadio());
            pstmtEstadio.setString(2, partido.getSeleccionTabla().getEstadio().getNombreEstadio());
            pstmtEstadio.setString(3, partido.getSeleccionTabla().getEstadio().getProvinciaEstadio());
            pstmtEstadio.setString(4, partido.getSeleccionTabla().getEstadio().getClubEstadio());

            pstmtEstadio.executeUpdate();
            pstmtPartido.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void borrarSeleccion(String id) {

        String sql = "DELETE from seleccion WHERE idSeleccion = ?";

        try(Connection connection = getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql))
        {
            pstmt.setString(1,id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean existeSeleccion(String nombreSeleccion) {

        String sql = "SELECT count(*) FROM seleccion WHERE nombre = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombreSeleccion);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

}

package com.example.lab7_20192832_20203651.ControllersLab;

import com.example.lab7_20192832_20203651.ModelsLab.BeansLab.Estadio;
import com.example.lab7_20192832_20203651.ModelsLab.BeansLab.Partido;
import com.example.lab7_20192832_20203651.ModelsLab.BeansLab.Seleccion;
import com.example.lab7_20192832_20203651.ModelsLab.Daos.Lab.EstadiosDao;
import com.example.lab7_20192832_20203651.ModelsLab.Daos.Lab.JugadoresDao;
import com.example.lab7_20192832_20203651.ModelsLab.Daos.Lab.SeleccionDao;
import com.example.lab7_20192832_20203651.ModelsLab.BeansLab.Jugador;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SeleccionesServlet", value = "/SeleccionesServlet")
public class SeleccionesServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "guardar" : request.getParameter("action");
        RequestDispatcher view;
        Partido partido;
        SeleccionDao seleccionDao = new SeleccionDao();
        switch (action) {
            case "guardar":
                partido = new Partido();

                Seleccion seleccionTabla = new Seleccion();
                seleccionTabla.setNombreSeleccion(request.getParameter("seleccion"));
                seleccionTabla.setTecnicoSeleccion(request.getParameter("tecnico"));

                Estadio estadio = new Estadio();

                estadio.setNombreEstadio(request.getParameter("estadio"));

                seleccionTabla.setEstadio(estadio);

                partido.setSeleccionTabla(seleccionTabla);

                //Se valida si existe una seleccion con el mismo nombre entonces nos redirecciona
                //al mismo form para cambiar los datos

                if (seleccionDao.existeSeleccion(seleccionTabla.getNombreSeleccion())) {
                    response.sendRedirect(request.getContextPath() + "/SeleccionesServlet?action=crear");
                } else {
                    seleccionDao.crearPartido(partido);
                    response.sendRedirect(request.getContextPath() + "/SeleccionesServlet");
                }
                break;
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");
        RequestDispatcher view;

        SeleccionDao daoPartidos = new SeleccionDao();
        EstadiosDao daoEstadios = new EstadiosDao();
        JugadoresDao jugadoresDao = new JugadoresDao();
        String idSeleccion;

        switch (action) {
            case "lista":
                request.setAttribute("listaSelecciones",daoPartidos.listaDeSelecciones());
                view = request.getRequestDispatcher("selecciones/listaselecciones.jsp");
                view.forward(request, response);
                break;
            case "crear":
                request.setAttribute("listaEstadios", daoEstadios.listarEstadios());
                view = request.getRequestDispatcher("selecciones/form.jsp");
                view.forward(request, response);
                break;

            case "borrar":
                idSeleccion = request.getParameter("id");
                //Validacion si el id de una seleccion no corresponde a local o visitante significa que no esta
                //en partido y se puede borrar

                ArrayList<Partido> listaPartidos = daoPartidos.listaDeSelecciones();
                for (Partido partido : listaPartidos) {
                    if ((partido.getSeleccionLocal().getIdSeleccion()==Integer.parseInt(idSeleccion)) || partido.getSeleccionVisitante().getIdSeleccion()==Integer.parseInt(idSeleccion)) {
                        response.sendRedirect(request.getContextPath() + "/SeleccionesServlet?action=lista");
                    }else {
                        ArrayList<Jugador> listaJugadores = jugadoresDao.listarJugadores();

                        for (Jugador jugador : listaJugadores) {
                            //Validar si un jugador esta en una seleccion
                            if (jugador.getSeleccion().getIdSeleccion()== Integer.parseInt(idSeleccion)) {
                                daoPartidos.borrarSeleccion(idSeleccion);
                            }
                        }
                        response.sendRedirect(request.getContextPath() + "/SeleccionesServlet");
                    }
                }
                break;
        }
    }
}

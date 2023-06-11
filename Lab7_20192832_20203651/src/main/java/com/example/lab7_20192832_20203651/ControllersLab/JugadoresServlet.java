package com.example.lab7_20192832_20203651.ControllersLab;
import com.example.lab7_20192832_20203651.ModelsLab.BeansLab.Jugador;
import com.example.lab7_20192832_20203651.ModelsLab.BeansLab.Seleccion;
import com.example.lab7_20192832_20203651.ModelsLab.Daos.Lab.JugadoresDao;

import com.example.lab7_20192832_20203651.ModelsLab.Daos.Lab.SeleccionesDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "JugadoresServlet", value = "")
public class JugadoresServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");
        JugadoresDao jugadoresDao = new JugadoresDao();
        SeleccionesDao seleccionesDao = new SeleccionesDao();
        RequestDispatcher view;

        switch (action) {
            case "listar":
                ArrayList<Jugador> listaJugadores = jugadoresDao.listarJugadores();
                request.setAttribute("listaJugadores", listaJugadores);
                view = request.getRequestDispatcher("jugadores/listadejugadores.jsp");
                view.forward(request, response);
                break;

            case "crear":
                ArrayList<Seleccion> listaSelecciones = seleccionesDao.listarSelecciones();
                request.setAttribute("listaSelecciones",listaSelecciones);
                view = request.getRequestDispatcher("jugadores/crearJugador.jsp");
                view.forward(request,response);
                break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action") == null ?
                        "listar" : request.getParameter("action");

        JugadoresDao jugadoresDao = new JugadoresDao();
        RequestDispatcher view;

        switch (action){
            case "crear":
                Jugador jugador = new Jugador();

                jugador.setNombreJugador(request.getParameter("Nombre"));
                jugador.setEdadJugador(Integer.parseInt(request.getParameter("Edad")));
                jugador.setPosicionJugador(request.getParameter("posicion"));
                jugador.setClubJugador(request.getParameter("club"));

                Seleccion seleccionJugador = new Seleccion();
                seleccionJugador.setNombreSeleccion(request.getParameter("seleccion"));
                jugador.setSeleccion(seleccionJugador);

                jugadoresDao.crearJugador(jugador);

                response.sendRedirect(request.getContextPath() + "");
                break;
        }

    }

}
package com.example.lab7_20192832_20203651.ControllersLab;
import com.example.lab7_20192832_20203651.ModelsLab.Daos.Lab.JugadoresDao;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "JugadoresServlet", value = "/JugadoresServlet")
public class JugadoresServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        JugadoresDao jugadoresdao = new JugadoresDao();
        request.setAttribute("listaJugadores",jugadoresdao.listarJugadores());

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jugadores/listajugadores.jsp");
        requestDispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
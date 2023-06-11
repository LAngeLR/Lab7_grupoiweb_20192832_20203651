<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.lab7_20192832_20203651.ModelsLab.BeansLab.Jugador" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<Jugador> listaJugador = (ArrayList<Jugador>) request.getAttribute("listaJugadores"); %>


<html>
<head>
    <title>Lista de Jugadores</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
          crossorigin="anonymous">
</head>
<body>
<table class ="table">
    <tr class = "table-header">
        <th>ID</th>
        <th>Nombre</th>
        <th>Edad</th>
        <th>Posición</th>
        <th>Club</th>
        <th>Selección</th>
    </tr>
    <% for (Jugador jugador : listaJugador){%>
    <tr>
        <td><%=jugador.getIdJugador()%></td>
        <td><%=jugador.getNombreJugador()%></td>
        <td><%=jugador.getEdadJugador()%></td>
        <td><%=jugador.getPosicionJugador()%></td>
        <td><%=jugador.getClubJugador()%></td>
        <td><%=jugador.getSeleccion().getNombreSeleccion()%></td>
    </tr>
    <%}%>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>
</html>

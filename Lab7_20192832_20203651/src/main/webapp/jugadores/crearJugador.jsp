<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.lab7_20192832_20203651.ModelsLab.BeansLab.Seleccion" %><%--
  Created by IntelliJ IDEA.
  User: PABLO
  Date: 11/06/2023
  Time: 02:06
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<Seleccion> listaSelecciones = (ArrayList<Seleccion>) request.getAttribute("listaSelecciones");%>

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'/>
        <title>Crear un nuevo Jugador</title>
    </head>
    <jsp:include page="/navbar/navbar.jsp">
        <jsp:param name="title" value="Laboratorio 6"/>
    </jsp:include>
    <body>
    <div class='container'>
        <hr class="invisible">
        <h3 class='mb-3'>Crear un nuevo jugador</h3>
        <form method="POST" action="<%=request.getContextPath()%>?action=crear">
            <div class="form-group">
                <label for="Nombre">Nombre</label>
                <input type="text" class="form-control" name="Nombre" id="Nombre">
            </div>
            <div class="form-group">
                <label for="Edad">Edad</label>
                <input type="number" class="form-control" name="Edad" id="Edad">
            </div>
            <div class="form-group">
                <label for="posicion">Posición</label>
                <input type="text" class="form-control" name="posicion" id="posicion">
            </div>
            <div class="form-group">
                <label for="club">Club</label>
                <input type="text" class="form-control" name="club" id="club">
            </div>

            <div class="form-group">
                <label for="seleccion">Selección</label>
                <select required name = "seleccion" id = "seleccion" class ="form-control">
                    <% for (Seleccion seleccion :listaSelecciones) {%>
                    <option value = "<%=seleccion.getIdSeleccion()%>"><%=seleccion.getNombreSeleccion()%>
                    </option>
                    <%}%>
                </select>
            </div>
            <hr class="invisible">
            <a href="<%=request.getContextPath()%>" class="btn btn-danger">Volver</a>
            <a href="<%=request.getContextPath()%>" class="btn btn-success">Submit</a>

        </form>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    </body>
</html>

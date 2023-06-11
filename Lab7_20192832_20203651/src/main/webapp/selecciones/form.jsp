<%@ page import="com.example.lab7_20192832_20203651.ModelsLab.BeansLab.Partido" %>
<%@ page import="com.example.lab7_20192832_20203651.ModelsLab.BeansLab.Seleccion" %>
<%@ page import="com.example.lab7_20192832_20203651.ModelsLab.BeansLab.Estadio" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listaEstadios" type="java.util.ArrayList<com.example.lab7_20192832_20203651.ModelsLab.BeansLab.Estadio>" scope="request"/>


<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'/>
  <title>LAB 7</title>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-light bg-light">
  <a class="navbar-brand" href="#">Clasificatorias Sudamericanas Qatar 2022</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
    <ul class="navbar-nav">
      <li class="nav-item" >
        <a class="nav-link" href="<%=request.getContextPath()%>/JugadoresServlet">Jugadores</a>
      </li>
      <li class="nav-item" >
        <a class="nav-link" href="<%=request.getContextPath()%>/SeleccionesServlet">Selecciones</a>
      </li>
    </ul>
  </div>
</nav>
<div class='container'>
  <div class="row mb-4">
    <div class="col"></div>
    <div class="col-md-6">
      <h1 class='mb-3'>Crear una Seleccion de Clasificatorias</h1>
      <form method="POST" action="<%=request.getContextPath()%>/SeleccionesServlet?action=guardar">

        <div class="form-group">
          <label>Nombre Seleccion</label>
          <input class="form-control" name="seleccion" id="seleccion">
        </div>

        <div class="form-group">
          <label>Nombre Tecnico</label>
          <input class="form-control" name="tecnico" id="tecnico">
        </div>

        <div class="form-group">
          <label>Estadio</label>
          <select required name="estadio" class="form-control">
            <% for(Estadio estadio: listaEstadios){ %>
            <option value="<%=estadio.getNombreEstadio()%>"><%=estadio.getNombreEstadio()%></option>
            <% } %>
          </select>
        </div>
        <button type="submit" class="btn btn-primary">Guardar</button>
        <a href="<%=request.getContextPath()%>/SeleccionesServlet" class="btn btn-danger">Cancelar</a>
      </form>
    </div>
    <div class="col"></div>
  </div>
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

<%-- 
    Document   : editar
    Created on : 18-jul-2021, 18:39:38
    Author     : Kri5ho
--%>


<%@page import="Modelo.Estudiante"%>
<%@page import="ModeloDAO.EstudianteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>TRABAJO FINAL SISTEMAS DISTRIBUIDOS</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
                <%
                    EstudianteDAO dao = new EstudianteDAO();
                    int id = Integer.parseInt((String) request.getAttribute("idest"));
                    Estudiante e = (Estudiante) dao.list(id);
                %>
                <h1>Modificar Estudiante</h1>
                <form action="Controlador">
                    DNI:<br>
                    <input class="form-control" type="text" name="txtDni" value="<%= e.getDni()%>"><br>
                    Nombres: <br>
                    <input class="form-control" type="text" name="txtNom" value="<%= e.getNom()%>"><br>
                    Apellidos: <br>
                    <input class="form-control" type="text" name="txtApe" value="<%= e.getApe()%>"><br>
                    Facultad:<br>
                    <input class="form-control" type="text" name="txtFac" value="<%= e.getFac()%>"><br>
                    Escuela: <br>
                    <input class="form-control" type="text" name="txtEsc" value="<%= e.getEsc()%>"><br>
                    Ciclo: <br>
                    <input class="form-control" type="text" name="txtCic" value="<%= e.getCic()%>"><br>
                    Curso: <br>
                    <input class="form-control" type="text" name="txtCur" value="<%= e.getCur()%>"><br>
                    Nota: <br>
                    <input class="form-control" type="text" name="txtNot" value="<%= e.getNot()%>"><br>
                    Pago: <br>
                    <input class="form-control" type="text" name="txtPag" value="<%= e.getPag()%>"><br>

                    <input type="hidden" name="txtid" value="<%= e.getId()%>">
                    <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                    <a href="Controlador?accion=listar">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>

<%-- 
    Document   : listar
    Created on : 18-jul-2021, 18:39:24
    Author     : Kri5ho
--%>


<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Estudiante"%>
<%@page import="java.util.List"%>
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
            <h1>Estudiantes</h1>
            <a class="btn btn-success" href="Controlador?accion=add">Agregar Nuevo Estudiante</a>
            
            <a class="btn btn-success" href="index.jsp">Regresar</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">DNI</th>
                        <th class="text-center">NOMBRES</th>
                        <th class="text-center">APELLIDOS</th>
                        <th class="text-center">FACULTAD</th>
                        <th class="text-center">ESCUELA</th>
                        <th class="text-center">CICLO</th>
                        <th class="text-center">CURSO</th>
                        <th class="text-center">NOTA</th>
                        <th class="text-center">PAGO</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    EstudianteDAO dao=new EstudianteDAO();
                    List<Estudiante>list=dao.listar();
                    Iterator<Estudiante>iter=list.iterator();
                    Estudiante est=null;
                    while(iter.hasNext()){
                        est=iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= est.getId()%></td>
                        <td class="text-center"><%= est.getDni()%></td>
                        <td><%= est.getNom()%></td>
                        <td><%= est.getApe()%></td>
                        <td><%= est.getFac()%></td>
                        <td><%= est.getEsc()%></td>
                        <td><%= est.getCic()%></td>
                        <td><%= est.getCur()%></td>
                        <td><%= est.getNot()%></td>
                        <td><%= est.getPag()%></td>
                        
                        <td class="text-center">
                            <a class="btn btn-warning" href="Controlador?accion=editar&id=<%= est.getId()%>">Editar</a>
                            <a class="btn btn-danger" href="Controlador?accion=eliminar&id=<%= est.getId()%>">Remove</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>

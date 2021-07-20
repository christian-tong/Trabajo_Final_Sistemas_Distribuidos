/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contorlador;

import Modelo.Estudiante;
import ModeloDAO.EstudianteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kri5ho
 */
public class Controlador extends HttpServlet {

    String listar="vistas/listar.jsp";
    String add="vistas/add.jsp";
    String edit="vistas/edit.jsp";
    Estudiante p=new Estudiante();
    EstudianteDAO dao=new EstudianteDAO();
    int id;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("listar")){
            acceso=listar;            
        }else if(action.equalsIgnoreCase("add")){
            acceso=add;
        }
        else if(action.equalsIgnoreCase("Agregar")){
            String dni=request.getParameter("txtDni");
            String nom=request.getParameter("txtNom");
            String ape=request.getParameter("txtApe");
            String fac=request.getParameter("txtFac");
            String esc=request.getParameter("txtEsc");
            String cic=request.getParameter("txtCic");
            String cur=request.getParameter("txtCur");
            String not=request.getParameter("txtNot");
            String pag=request.getParameter("txtPag");
            
            p.setDni(dni);
            p.setNom(nom);
            p.setApe(ape);
            p.setFac(fac);
            p.setEsc(esc);
            p.setCic(cic);
            p.setCur(cur);
            p.setNot(not);
            p.setPag(pag);
            dao.add(p);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idest",request.getParameter("id"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            id=Integer.parseInt(request.getParameter("txtid"));
            String dni=request.getParameter("txtDni");
            String nom=request.getParameter("txtNom");
            String ape=request.getParameter("txtApe");
            String fac=request.getParameter("txtFac");
            String esc=request.getParameter("txtEsc");
            String cic=request.getParameter("txtCic");
            String cur=request.getParameter("txtCur");
            String not=request.getParameter("txtNot");
            String pag=request.getParameter("txtPag");
            p.setId(id);
            p.setDni(dni);
            p.setNom(nom);
            p.setApe(ape);
            p.setFac(fac);
            p.setEsc(esc);
            p.setCic(cic);
            p.setCur(cur);
            p.setNot(not);
            p.setPag(pag);
            dao.edit(p);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            id=Integer.parseInt(request.getParameter("id"));
            p.setId(id);
            dao.eliminar(id);
            acceso=listar;
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

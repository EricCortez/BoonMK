/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import static Controladores.conector.conectar;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Modelos.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Manu
 */
public class S_validacion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     //   processRequest(request, response);
        
        
                  HttpSession session = request.getSession();
        
//no 
        
       if (   session.getAttribute("usuario")==null){     
         request.getRequestDispatcher("login.jsp").forward(request, response);
       }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre, pass;

        nombre = request.getParameter("usuario");
        pass = request.getParameter("password");

       
   //  String consulta = "select * from inicio.iniciosesion where usuario='"+nombre+"'";
       String consulta2 = "select * from inicio.iniciosesion where usuario='"+nombre+"' and contrasena='"+pass+"'";

    //    String consulta3 = "select * from inicio.iniciosesion where usuario='admin' and contrasena='1234' ";
     
       
        try {
            
            
         
            
            Connection cn = conector.conectar();
            
        PreparedStatement pst = cn.prepareStatement(consulta2);  

// "SELECT * FROM inicio.iniciosesion where usuario=admin and contrasena=1234");
//"SELECT usuario and contrasena FROM inicio.iniciosesion where usuario=admin and contrasena=1234");
            
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Usuarios usuarios = new Usuarios(nombre, pass);
               HttpSession session = request.getSession();
                session.setAttribute("usuario", usuarios);
                request.setAttribute("usuarios", usuarios);
              //  request.getRequestDispatcher("principal").forward(request, response);
               request.getRequestDispatcher("principal").forward(request, response);
            } else {
               // System.out.print("<h1>Datos incorrectos</h1>");
               // request.getRequestDispatcher("Errorlogin").forward(request, response);
                request.getRequestDispatcher("Error_validacion").forward(request, response);
            }
        } catch (SQLException ex) {
           // System.out.print("<h1>No se pudo conectar</h1>");
           // request.getRequestDispatcher("Errorlogin").forward(request, response);
                request.getRequestDispatcher("Error_validacion").forward(request, response);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

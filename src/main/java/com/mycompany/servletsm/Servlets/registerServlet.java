package com.mycompany.servletsm.Servlets;

import com.mycompany.servletsm.Controllers.registerController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "registerServlet", urlPatterns = {"/registerServlet"})
public class registerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String Nombre = request.getParameter("nombreC");
        String Direccion = request.getParameter("direccion");
        String CP = request.getParameter("cp");
        String Telefono = request.getParameter("telefono");
        int Edad = Integer.parseInt(request.getParameter("edad"));
        String Fecha = request.getParameter("fecha");
        String Correo = request.getParameter("correo");
        
        String Usuario = request.getParameter("usuario");
        String Password = request.getParameter("password");
        
        new registerController().registrar(Nombre, Direccion, CP, Telefono, Edad, Fecha, Correo, Usuario, Password);
        
        new PrintWriter(response.getWriter()).println("<script>alert('Usuario Registrado correctamente')</script>");
        response.sendRedirect("index.html");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

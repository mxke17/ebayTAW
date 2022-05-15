/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// MIGUEL JURADO VAZQUEZ

package Servlets;

import Service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mjura
 */
@WebServlet(name = "newUserVendedorServlet", urlPatterns = {"/newUserVendedorServlet"})
public class VendedorNewUserVendedorServlet extends SampleTAWServlet {

    @EJB UserService us;
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
            String nick = request.getParameter("nick");
            String email = request.getParameter("email");
            String pass = request.getParameter("pass");
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String genero = request.getParameter("genero");
            String calle = request.getParameter("calle");
            String $numero = request.getParameter("numero");
            String ciudad = request.getParameter("ciudad");
            String $cpostal = request.getParameter("cPostal");
            String region = request.getParameter("region");
            
            
            // Nick, email y pass estarán rellenas por obligacion de html
            this.us.crearVendedor(nick, email, pass, nombre, apellidos, genero, calle, $numero, ciudad, $cpostal, region);
            
            request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
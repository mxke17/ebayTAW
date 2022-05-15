/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DTO.UserDTO;
import Entity.Mensaje;
import Service.MensajeService;
import Service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author power
 */
@WebServlet(name = "MarketingBorrarMensajeServlet", urlPatterns = {"/MarketingBorrarMensajeServlet"})
public class MarketingBorrarMensajeServlet extends HttpServlet {

    @EJB MensajeService ms;
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Tomar id mensaje
        int idMensaje  = Integer.parseInt(request.getParameter("idMensaje"));
        //Traer id del usuario de la sesion
        int id = Integer.parseInt(request.getParameter("Usuario"));
        UserDTO usuarioActual = this.us.getUsuario(id);
        
        //BorrarMensaje
        this.ms.borrarMensaje(idMensaje);
        
        //Traemos mis mensajes
        List<Mensaje> misMensajes = this.ms.misMensajes(usuarioActual);
        //Pasar la lista 
        request.setAttribute("misMensajes", misMensajes);
        request.getRequestDispatcher("WEB-INF/Marketing/usuario_ver_mis_mensajes.jsp").forward(request, response);
        
        
        
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

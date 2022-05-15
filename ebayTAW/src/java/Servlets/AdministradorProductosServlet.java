/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DTO.CategoriesDTO;
import DTO.ProductsDTO;
import DTO.UserDTO;
import Service.CategoryService;
import Service.ProductService;
import Service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cristobal
 */
@WebServlet(name = "AdministradorProductosServlet", urlPatterns = {"/AdministradorProductosServlet"})
public class AdministradorProductosServlet extends SampleTAWServlet {

    @EJB ProductService productService;
    @EJB UserService userService;
    @EJB CategoryService categoryService;
    
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
        if (super.comprobarSession(request, response)){
            String title = request.getParameter("title");
            
            String userIdStr = request.getParameter("userId");
            Integer userId = null;
            if(userIdStr != null && !userIdStr.isEmpty()){
                userId = Integer.parseInt(userIdStr);
            }
            
            String categoryIdStr = request.getParameter("categoryId");
            Integer categoryId = null;
            if(categoryIdStr != null && !categoryIdStr.isEmpty()){
                categoryId = Integer.parseInt(categoryIdStr);
            }
            
            String initialPriceStr = request.getParameter("initialPrice");
            BigDecimal initialPrice = null;
            if(initialPriceStr != null && !initialPriceStr.isEmpty()){
                initialPrice = new BigDecimal(initialPriceStr);
            }
            
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            
            String startDateStr = request.getParameter("startDate");
            Date startDate = null;
            if(startDateStr != null && !startDateStr.isEmpty()){
                try {
                    startDate = format.parse(startDateStr);
                } catch (ParseException ex) {
                    Logger.getLogger(AdministradorProductosServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            String finishDateStr = request.getParameter("finishDate");
            Date finishDate = null;
            if(finishDateStr != null && !finishDateStr.isEmpty()){
                try {
                    finishDate = format.parse(finishDateStr);
                } catch (ParseException ex) {
                    Logger.getLogger(AdministradorProductosServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            String isSoldStr = request.getParameter("isSold");
            Boolean isSold = null;
            if(isSoldStr != null && !isSoldStr.isEmpty()){
                isSold = Boolean.parseBoolean(isSoldStr);
            }
            
            List<ProductsDTO> productos = this.productService.listarProductos(title,userId, categoryId, initialPrice, startDate, finishDate, isSold);
            request.setAttribute("productos", productos);
            
            List<UserDTO> usuarios = this.userService.listarUsuarios();
            List<CategoriesDTO> categorias = this.categoryService.listarCategorias(null);
            request.setAttribute("usuarios", usuarios);
            request.setAttribute("categorias", categorias);
            
            request.getRequestDispatcher("/WEB-INF/Administrador/administrador_productos.jsp").forward(request, response);
        }
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
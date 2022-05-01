<%-- 
    Document   : productos
    Created on : 30-abr-2022, 11:03:51
    Author     : mjura
--%>

<%@page import="DTO.ProductsDTO"%>
<%@page import="DTO.UserDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    UserDTO vendedor = (UserDTO)session.getAttribute("usuario");
    if (vendedor == null){
        response.sendRedirect(request.getContextPath());
    }
%>



<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <jsp:include page="/WEB-INF/Vendedor/vendedor.jsp" />
        
        <!-- TABLA PRODUCTOS -->
        <form method="post" action="ProductosVendedorServlet">
            Titulo: <input type="text" name="filtroTitulo" value="">
            <input type="submit" value="Filtrar">
        </form>
        
        <% 
            List<ProductsDTO> productos = (List)request.getAttribute("productos");
            if ( productos == null || productos.isEmpty()){
        %>
        
        <h2>No existen productos</h2>
        
        <% 
            } else {
        %>
        <table border="1">
            <tr>
                <th>Titutlo</th>
                <th>Descripcion</th>                
                <th>Precio Inicial</th>                                
                <th>Link foto</th>     
                <th>Fecha inicio</th>                     
                <th>Fecha final</th>
                <th>Vendido</th>
                <th></th>                                                     
                <th></th>                                                                     
            </tr>
        
        <% 
            for(ProductsDTO producto:productos){
        %>
        
        <tr>
            <td><%= producto.getTitle() %></td>
            <td><%= producto.getDescription() %></td>
            <td><%= producto.getInitialPrice() %></td>
            <td><%= producto.getPhoto() %></td>
            <td><%= producto.getStartDate() %></td>
            <td><%= producto.getFinishDate() %></td>
            <td><%= producto.getIsSold() %></td>
            <td><a href="ProductoBorrarServlet?id=<%= producto.getProductID() %>">Borrar</a></td>
            <td><a href="CrearEditarProducto?id=<%= producto.getProductID() %>">Editar</a></td>
        </tr>
        
        <% 
            }
        %>
        
        </table>
        
        <% 
            }
        %>
    </body>
</html>

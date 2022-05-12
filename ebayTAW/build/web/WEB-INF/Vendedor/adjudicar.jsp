<%-- 
    Document   : adjudicar
    Created on : 12-may-2022, 17:14:14
    Author     : mjura
--%>

<%@page import="Entity.Bids"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="DTO.ProductsDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    ProductsDTO producto = (ProductsDTO)request.getAttribute("producto");
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/Vendedor/vendedor.jsp" />
        <h1>Listado de pujas del producto</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Titulo</th>
                    <th>Descripcion</th>
                    <th>Precio Inicial</th>
                    <th>Foto</th>
                    <th>Fecha Inicio</th>
                    <th>Fecha Fin</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><%= producto.getTitle() %></td>
                    <td><%= producto.getDescription() %></td>
                    <td><%= producto.getInitialPrice() %></td>
                    <td><%= producto.getPhoto() %></td>
                    <td><%= format.format(producto.getStartDate()) %></td>
                    <td><%= format.format(producto.getFinishDate()) %></td>
                </tr>
            </tbody>
        </table>
        <h2>Listado de pujas</h2>
        <% if(producto.getBidsList()== null || producto.getBidsList().isEmpty()){ %>
        <p>Lo siento, su producto no ha sido pujado</p>
        <%} else { %>
        <table border="1">
            <thead>
                <tr>
                    <th>Comprador</th>
                    <th>Puja</th>
                </tr>
            </thead>
            <tbody>
                <%for (Bids puja:producto.getBidsList()){%>
                <tr>
                    <td><%= puja.getUserID().getName() %> <%= puja.getUserID().getSurname() %></td>
                    <td><%= puja.getBidID() %></td>
                </tr>
                <%}%>
            </tbody>
        </table>

        <%}%>
    </body>
</html>

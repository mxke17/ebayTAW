<%-- 
    Document   : vendedor
    Created on : 27-abr-2022, 12:00:56
    Author     : mjura
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entity.Users"%>

<!DOCTYPE html>
<%
    Users vendedor = (Users)session.getAttribute("usuario");
    if (vendedor == null){
        response.sendRedirect(request.getContextPath());
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=vendedor.getUsername()%> page</title>
    </head>
    <table width="80%">
        <tr width="80%">
            <td>Session ID: <%=session.getId()%></td>
            <td><a href="ProductosVendedorServlet">Listado de productos</a></td>
            <td><a href="LogoutServlet">Salir</a></td>
        </tr>
    </table>
    
    <body>
        <h1>Bienvenidx, <%=vendedor.getUsername()%> </h1>
        <!--
        <form method="post" action="ProductosVendedorServlet">
            Titulo: <input type="text" name="filtroTitulo" value="">
            <input type="submit" value="Filtrar">
        </form>
        -->
    </body>
</html>

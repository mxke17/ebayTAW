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
        <title>Vendedor page</title>
    </head>
    <body>
        <h1>Bienvenidx, <%=vendedor.getUsername()%> </h1>
    </body>
</html>

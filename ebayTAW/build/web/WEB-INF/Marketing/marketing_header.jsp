<%-- 
    Document   : marketing_header
    Created on : 12-may-2022, 13:31:34
    Author     : Antonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DTO.UserDTO"%>

<!DOCTYPE html>
<%
    UserDTO marketing = (UserDTO)session.getAttribute("usuario");
    if (marketing == null){
        response.sendRedirect(request.getContextPath());
    }
%>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--meta http-equiv="Content-Type" content="text/html; charset=UTF-8"-->
        <title><%=marketing.getUsername()%> page</title>
        
        <style>
            * {
            box-sizing: border-box;
            font-family: Arial, Helvetica, sans-serif;
            }

            body {
                margin: 0;
                font-family: Arial, Helvetica, sans-serif;
            }

            /* Style the top navigation bar */
            .topnav {
                overflow: hidden;
                background-color: #333;
            }

            /* Style the topnav links */
            .topnav a {
                float: left;
                display: block;
                color: #f2f2f2;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
                
            }

            /* Change color on hover */
            .topnav a:hover {
                background-color: #ddd;
                color: black;
            }

            /* Style the content */
            .content {
                background-color: #ddd;
                padding: 10px;
            }
        </style>
        
    </head>
    
    
    <body>
        
        <div class="topnav">
            <li style="float:right"><a href="LogoutServlet">Salir</a></li>
            <li style="float:right"><a href="MarketingRedactarMensajeServlet">Crear un nuevo mensaje</a></li> 
            <li style="float:right"><a href="MarketingVerListasServlet">Ver listas</a></li>
            <li style="float:right"><a href="MarketingCrearServlet">Crear nueva lista</a></li>
            <li style="float:right"><a href="MarketingMensajesRecibidosServlet?Usuario=<%= marketing.getUserID()%>">Mensajes Recibidos</a></li>
            <li style="float:right"><a href="MarketingMenuServlet">Menu</a></li>

            
 
        </div>

        <div class="content">
            <!-- <p>Session ID: <%=session.getId()%></p> --->
        </div>
    </body>
</html>

<%-- 
    Document   : registroVendedor
    Created on : 03-may-2022, 16:14:53
    Author     : mjura
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Vendedor</title>
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
            
            /* Style the footer */
            .footer {
                background-color: #f1f1f1;
                padding: 10px;
            }
        </style>
    </head>
    <body>
        
        <div class="topnav">
            <li style="float:right"><a class="active" href="registroVendedorServlet">Home</a></li>
            <li style="float:right"><a class="active" href="registroVendedorServlet">Registrate como vendedor</a></li>
        </div>
        
        
        
        <div class="content">
            <h1>Bienvenido futuro vendedor</h1>
            <p>Los campos * son obligatorios</p>
            <form action="" method="POST">
                <table border="0">
                    <tbody>
                        <tr>
                            <td>*Nombre de usuario:</td>
                            <td><input type="" name="nick" value="" /></td>
                        </tr>
                        <tr>
                            <td>*Email:</td>
                            <td><input type="" name="email" value="" /></td>
                        </tr>
                        <tr>
                            <td>*Contraseña:</td>
                            <td><input type="" name="pass" value="" /></td>
                        </tr>
                        <tr>
                            <td>Nombre:</td>
                            <td><input type="" name="nombre" value="" /></td>
                        </tr>
                        <tr>
                            <td>Apellidos:</td>
                            <td><input type="" name="apellidos" value="" /></td>
                        </tr>
                        <tr>
                            <td>Genero:</td>
                            <td><input type="" name="genero" value="" /></td>
                        </tr>
                        <tr>
                            <td>Calle:</td>
                            <td><input type="" name="calle" value="" /></td>
                        </tr>
                        <tr>
                            <td>Numero:</td>
                            <td><input type="" name="numero" value="" /></td>
                        </tr>
                        <tr>
                            <td>Ciudad:</td>
                            <td><input type="" name="ciudad" value="" /></td>
                        </tr>
                        <tr>
                            <td>Codigo Postal:</td>
                            <td><input type="" name="cPostal" value="" /></td>
                        </tr>
                        <tr>
                            <td>Region:</td>
                            <td><input type="" name="region" value="" /></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Registrarse" /></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
        
        
        <div class="footer">
            <p>Footer</p>
        </div>
    </body>
</html>

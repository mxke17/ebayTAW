<%-- 
    Document   : homePage
    Created on : 25-abr-2022, 20:15:25
    Author     : mjura
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenidx a ebay</h1>
        <form action="./Usuarios" method="POST">
        <table border="0">
            <tbody>
                <tr>
                    <td>Nick:</td>
                    <td><input type="text" name="nick" value="" /></td>
                </tr>
                <tr>
                    <td>Contraseña:</td>
                    <td><input type="password" name="password" value="" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Iniciar" /></td>
                </tr>
            </tbody>
        </table>
        </form>

    </body>
</html>

<%-- 
    Document   : productos
    Created on : 30-abr-2022, 11:03:51
    Author     : mjura
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <form method="post" action="ProductosVendedorServlet">
            Titulo: <input type="text" name="filtroTitulo" value="">
            <input type="submit" value="Filtrar">
        </form>
    </body>
</html>

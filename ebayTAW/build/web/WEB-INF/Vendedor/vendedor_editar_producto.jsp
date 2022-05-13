<%-- 
    Document   : editProducto
    Created on : 01-may-2022, 18:07:20
    Author     : mjura
--%>

<%@page import="DTO.CategoriesDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="DTO.UserDTO"%>
<%@page import="DTO.ProductsDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    UserDTO vendedor = (UserDTO)session.getAttribute("usuario");
    if (vendedor == null){
        response.sendRedirect(request.getContextPath());
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=vendedor.getUsername()%> page</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/Vendedor/vendedor_header.jsp" />
        
        <%
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            ProductsDTO producto = (ProductsDTO)request.getAttribute("producto");
            List<CategoriesDTO> categorias = (List)request.getAttribute("categorias");
        %>
        
        <form method="post" action="ProductoGuardarServlet">
            <table border="1">
                <tbody>
                    <tr>
                        <td><label for="">Titulo:</label></td>
                        <td><input required type="text" name="titulo" value="<%= producto.getTitle() %>"></td>
                    </tr>
                    <tr>
                        <td><label for="">Descripcion:</label></td>
                        <td><input required type="text" name="descripcion" value="<%= producto.getDescription() %>"></td>
                    </tr>
                    <tr>
                        <td><label for="">Categoria:</label></td>
                        <td><select name="categoria">
                                <% for (CategoriesDTO categoria:categorias){
                                    String selected = "";
                                if (categoria.getName().equals(producto.getCategoryID().getName())){
                                    selected = "selected";
                                }
                                %>
                                <option value="<%=categoria.getCategoryID()%>" <%= selected %> ><%= categoria.getName() %></option>
                                <%}%>
                            </select></td>
                    </tr>
                    <tr>
                        <td><label for="">Precio Inicial:</label></td>
                        <td><input required type="number" name="precioInicial" step="any" min="0" value="<%= producto.getInitialPrice() %>"></td>
                    </tr>
                    <tr>
                        <td><label for="">Link foto:</label></td>
                        <td><input required type="text" name="linkFoto" value="<%= producto.getPhoto() %>"></td>
                    </tr>
                    <tr>
                        <td><label for="">Fecha inicio:</label></td>
                        <td><input required type="date" name="fechaInicio" value="<%= format.format(producto.getStartDate())%>"></td>
                    </tr>
                    <tr>
                        <td><label for="">Fecha fin</label></td>
                        <td><input required type="date" name="fechaFin" value="<%= format.format(producto.getFinishDate()) %>"></td>
                    </tr>
                    <tr>
                        <td><label for="">¿Vendido?</label></td>
                        <%String checked = "";
                        if (producto.getIsSold()){
                            checked="checked";
                        }%>
                        <td><input  type="checkbox" name="vendido" <%= checked %>></td>
                    </tr>
                </tbody>
            </table>
            <input type="hidden" name="id" value="<%= producto.getProductID() %>" />       
            <input type="submit" value="Editar" />
        </form>
    </body>
</html>

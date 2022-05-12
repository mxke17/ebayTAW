/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DTO.CategoriesDTO;
import DTO.ProductsDTO;
import DTO.UserDTO;
import Entity.Products;
import Facades.ProductsFacade;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author mjura
 */
@Stateless
public class ProductService {

    @EJB
    ProductsFacade pf;

    public List<ProductsDTO> listaEntityADTO(List<Products> lista) {
        List<ProductsDTO> listaDTO = null;
        if (lista != null) {
            listaDTO = new ArrayList<>();
            for (Products producto : lista) {
                listaDTO.add(producto.toDTO());
            }
        }
        return listaDTO;
    }

    public List<ProductsDTO> listarProductos(String filtroTitulo) {
        List<Products> productos = null;
        if (filtroTitulo == null || filtroTitulo.isEmpty()) {
            productos = this.pf.findAll();
        } else {
            productos = this.pf.findAllByTitulo(filtroTitulo);
        }

        return this.listaEntityADTO(productos);
    }

    public List<ProductsDTO> listarProductos(String filtroTitulo, UserDTO vendedor) {
        List<Products> productos = null;
        if (filtroTitulo == null || filtroTitulo.isEmpty()) {
            productos = this.pf.findAllByUser(vendedor);
        } else {
            productos = this.pf.findByTitulo(filtroTitulo, vendedor);
        }

        return this.listaEntityADTO(productos);
    }

    public void borrarProducto(Integer id) {
        Products producto = this.pf.find(id);
        this.pf.remove(producto);
    }

    public ProductsDTO buscarProducto(Integer id) {
        Products producto = this.pf.find(id);
        return producto.toDTO();
    }

    public void editarProductoBorrarLuego(Integer id, String titulo, String descripcion, BigDecimal precioInicial, String foto, Boolean vendido) {
        Products producto = this.pf.find(id);

        producto.setTitle(titulo);
        producto.setDescription(descripcion);
        producto.setInitialPrice(precioInicial);
        producto.setPhoto(foto);
        producto.setIsSold(vendido);
        this.pf.edit(producto);
    }

    public void editarProducto(Integer id, String titulo, String descripcion, BigDecimal precioInicial, String foto, Date fechaInicio, Date fechaFin, Boolean vendido) {
        Products producto = this.pf.find(id);

        producto.setTitle(titulo);
        producto.setDescription(descripcion);
        producto.setInitialPrice(precioInicial);
        producto.setPhoto(foto);
        producto.setStartDate(fechaInicio);
        producto.setFinishDate(fechaFin);
        producto.setIsSold(vendido);
        this.pf.edit(producto);
    }

    //Cristobal
    public List<ProductsDTO> listarProductos(String title, Integer userId, Integer categoryId, BigDecimal initialPrice, Date startDate, Date finishDate, Boolean isSold) {
        List<Products> productos;

        if ((title == null || title.isEmpty()) && userId == null && categoryId == null && initialPrice == null && startDate == null && finishDate == null && isSold == null) {
            productos = this.pf.findAll();
        } else {
            productos = this.pf.findAll(title, userId, categoryId, initialPrice, startDate, finishDate, isSold);
        }

        return this.listaEntityADTO(productos);
    }
}

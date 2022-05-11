/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DTO.ProductsDTO;
import DTO.UserDTO;
import Entity.Categories;
import Entity.Products;
import Facades.CategoriesFacade;
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
    
    @EJB ProductsFacade pf;
    @EJB CategoriesFacade cf;
    
    public List<ProductsDTO> listaEntityADTO (List<Products> lista){
        List<ProductsDTO> listaDTO = null;
        if (lista != null){
            listaDTO = new ArrayList<>();
            for (Products producto:lista){
                listaDTO.add(producto.toDTO());
            }
        }
        return listaDTO;
    }

    // Cristobal
    public List<ProductsDTO> listarProductos (String filtroTitulo){
        List<Products> productos = null;
        if (filtroTitulo == null || filtroTitulo.isEmpty()){
            productos = this.pf.findAll();
        } else {
            productos = this.pf.findAllByTitulo(filtroTitulo);
        }
        
        return this.listaEntityADTO(productos);
    }    

    // Miguel
    public List<ProductsDTO> listarProductos (String filtroTitulo, UserDTO vendedor){
        List<Products> productos = null;
        if (filtroTitulo == null || filtroTitulo.isEmpty()){
            productos = this.pf.findAllByUser(vendedor);
        } else {
            productos = this.pf.findByTitulo(filtroTitulo, vendedor);
        }
        
        return this.listaEntityADTO(productos);
    }
    
    // Miguel
    public void borrarProducto(Integer id){
        Products producto = this.pf.find(id);
        this.pf.remove(producto);
    }
    
    
    public ProductsDTO buscarProducto(Integer id){
        Products producto = this.pf.find(id);
        return producto.toDTO();
    }
    
    // Miguel
    public void editarProducto(Integer id, String titulo, String descripcion, String categoria, BigDecimal pInicial, String linkFoto, Date fInicio, Date fFin, Boolean v){
        
        //Busco el producto
        Products producto = this.pf.find(id);
        Categories cat = this.cf.findByNombre(categoria);
        
        producto.setTitle(titulo);
        producto.setDescription(descripcion);
        producto.setCategoryID(cat);
        producto.setInitialPrice(pInicial);
        producto.setPhoto(linkFoto);
        producto.setStartDate(fInicio);
        producto.setFinishDate(fFin);
        producto.setIsSold(v);
        
        this.pf.edit(producto);
    }
    
    
}

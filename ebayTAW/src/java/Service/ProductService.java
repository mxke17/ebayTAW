/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DTO.ProductsDTO;
import DTO.UserDTO;
import Entity.Products;
import Facades.ProductsFacade;
import java.util.ArrayList;
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
    
    
    
    public List<ProductsDTO> listarProductos (String filtroTitulo, UserDTO vendedor){
        List<Products> productos = null;
        if (filtroTitulo == null || filtroTitulo.isEmpty()){
            productos = this.pf.findAllByUser(vendedor);
        } else {
            productos = this.pf.findByTitulo(filtroTitulo, vendedor);
        }
        
        return this.listaEntityADTO(productos);
    }
}

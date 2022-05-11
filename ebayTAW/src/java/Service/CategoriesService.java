/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DTO.CategoriesDTO;
import Entity.Categories;
import Facades.CategoriesFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author mjura
 */
@Stateless
public class CategoriesService {
    @EJB CategoriesFacade cf;
    
    // Miguel
    public List<CategoriesDTO> listaEntityADTO(List<Categories> lista){
        List<CategoriesDTO> listaDTO = null;
        if (lista != null){
            listaDTO = new ArrayList<>();
            for (Categories categoria:lista){
                listaDTO.add(categoria.toDTO());
            }
        }
        return listaDTO;
    }
    
    // Miguel
    public List<CategoriesDTO> findAll(){
        List<Categories> categorias = null;
        categorias = this.cf.findAll();
        
        return this.listaEntityADTO(categorias);
    }
    
    // Miguel
    public CategoriesDTO findByNombre(String nombre){
        Categories categoria = null;
        
        categoria = this.cf.findByNombre(nombre);
        
        return categoria.toDTO();
    }
    
}

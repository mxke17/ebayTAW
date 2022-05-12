/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DTO.CategoriesDTO;
import Entity.Categories;
import Facades.CategoriesFacade;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author cristobal
 */
@Stateless
public class CategoryService {

    @EJB
    CategoriesFacade cf;

    //Cristobal
    public List<CategoriesDTO> listaEntityADTO(List<Categories> categorias) {
        return categorias.stream().map(x -> x.toDTO()).collect(Collectors.toList());
    }

    //Cristobal
    public List<CategoriesDTO> listarCategorias(String filtroTitulo) {
        List<Categories> categorias = null;
        if (filtroTitulo == null || filtroTitulo.isEmpty()) {
            categorias = this.cf.findAll();
        } else {
            categorias = this.cf.findAllByNombre(filtroTitulo);
        }

        return this.listaEntityADTO(categorias);
    }
    
    //Cristobal
    public void borrarCategoria(Integer categoriaId){
        Categories category = this.cf.find(categoriaId);
        this.cf.remove(category);
    }
}

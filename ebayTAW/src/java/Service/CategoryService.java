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
    public CategoriesDTO getCategoria(Integer categoriaId){
        Categories category = this.cf.find(categoriaId);
        return category.toDTO();
    }
    
    //Cristobal
    public void borrarCategoria(Integer categoriaId){
        Categories category = this.cf.find(categoriaId);
        this.cf.remove(category);
    }
    
<<<<<<< Updated upstream
    //Cristobal
    public void crearCategoria(String nombre){
        Categories category = new Categories();
        category.setName(nombre);
        this.cf.create(category);
    }
    
    //Cristobal
    public void editarCategoria(Integer categoriaId, String nombre){
        Categories category = this.cf.find(categoriaId);
        System.out.println("sancho: " + nombre);
        category.setName(nombre);
        this.cf.edit(category);
=======
    // Miguel
    public List<CategoriesDTO> findAll(){
        List<Categories> categorias = this.cf.findAll();
        return this.listaEntityADTO(categorias);
>>>>>>> Stashed changes
    }
}

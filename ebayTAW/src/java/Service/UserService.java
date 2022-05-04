/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DTO.UserDTO;
import Entity.Users;
import Facades.UsersFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author mjura
 */
@Stateless
public class UserService {
    
    @EJB UsersFacade uf;
    public UserDTO comprobarCredenciales (String email, String pass){
        Users usuario = this.uf.comprobarUsuario(email, pass);
        return usuario.toDTO();
    }
    
    public void crearVendedor(String username, String email, String password, 
            String nombre, String apellidos, String genero, String calle, 
            Integer numero, String ciudad, Integer cpostal, String region){
        Users vendedor = new Users();
        // Relleno los datos
        vendedor.setRol("Vendedor");
        vendedor.setUsername(username);
        vendedor.setEmail(email);
        vendedor.setPassword(password);
        vendedor.setName(nombre);
        vendedor.setSurname(apellidos);
        vendedor.setGender(genero);
        vendedor.setStreet(calle);
        vendedor.setNumber(numero);
        vendedor.setCity(ciudad);
        vendedor.setRegion(region);
        vendedor.setPostalCode(cpostal);
        this.uf.create(vendedor);
    }
    
    
}

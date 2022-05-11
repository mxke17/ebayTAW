/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DTO.UserDTO;
import Entity.Users;
import Facades.UsersFacade;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author mjura
 */
@Stateless
public class UserService {
    
    public List<UserDTO> listaEntityADTO (List<Users> lista){
        return lista.stream().map(u -> u.toDTO()).collect(Collectors.toList());
    }
    
    @EJB UsersFacade uf;
    public UserDTO comprobarCredenciales (String email, String pass){
        Users usuario = this.uf.comprobarUsuario(email, pass);
        return usuario.toDTO();
    }
    
    public void crearVendedor(String nick, String email, String pass, String nombre, String apellidos, String genero, String calle, String $numero, String ciudad, String $cPostal, String region){
        Users nUser = new Users();
        
        nUser.setUsername(nick);
        nUser.setEmail(email);
        nUser.setPassword(pass);

        if (nombre != null || !nombre.isEmpty()){
            nUser.setName(nombre);
        }

        if (apellidos != null || !apellidos.isEmpty()){
            nUser.setSurname(apellidos);
        }
        
        // Error aqui
        if (genero != null || !genero.isEmpty()){
            nUser.setGender(genero);
        }

        if (calle != null || !calle.isEmpty()){
            nUser.setStreet(calle);
        }

        if ($numero != null || !$numero.isEmpty()){
            nUser.setNumber(Integer.parseInt($numero));
        }

        if (ciudad != null || !ciudad.isEmpty()){
            nUser.setCity(ciudad);
        }

        if ($cPostal != null || !$cPostal.isEmpty()){
            nUser.setPostalCode(Integer.parseInt($cPostal));
        }

        if (region != null || region.isEmpty()){
            nUser.setRegion(region);
        }

        nUser.setRol("Vendedor");
        this.uf.create(nUser);
    }
    
    public List<UserDTO> listarUsuarios(){
        List<Users> users = null;

        users = this.uf.findAll();
    
        return this.listaEntityADTO(users);
    }
    
}

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
    
    
}

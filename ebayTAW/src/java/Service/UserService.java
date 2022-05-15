/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DTO.UserDTO;
import Entity.Users;
import Facades.UsersFacade;
import Facades.UsuarioslistaFacade;
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

    //Cristobal
    public List<UserDTO> listaEntityADTO(List<Users> lista) {
        return lista.stream().map(u -> u.toDTO()).collect(Collectors.toList());
    }

    @EJB UsersFacade uf;
    @EJB UsuarioslistaFacade ulf;

    public UserDTO comprobarCredenciales(String email, String pass) {
        Users usuario = this.uf.comprobarUsuario(email, pass);
        return usuario.toDTO();
    }

    public void crearVendedor(String username, String email, String password,
            String nombre, String apellidos, String genero, String calle,
            Integer numero, String ciudad, Integer cpostal, String region) {
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

    public List<UserDTO> listarUsuarios() {
        List<Users> users = this.uf.findAll();

        return this.listaEntityADTO(users);
    }

    //Cristobal
    public List<UserDTO> listarUsuarios(String rol, String username, String email, String name,
            String surname, String gender, String street, Integer number,
            String city, String region, Integer postalCode) {
        if ((rol == null || rol.isEmpty()) && (username == null || username.isEmpty()) && (name == null || name.isEmpty()) && (email == null || email.isEmpty())
                && (surname == null || surname.isEmpty()) && (gender == null || gender.isEmpty()) && (street == null || street.isEmpty())
                && number == null && (city == null || city.isEmpty()) && (region == null || region.isEmpty()) && postalCode == null) {
            List<Users> users = this.uf.findAll();
            return this.listaEntityADTO(users);
        } else {
            List<Users> users = this.uf.getUsuarios(rol, username, email, name, surname, gender, street, number, city, region, postalCode);
            return this.listaEntityADTO(users);
        }
    }

    //Cristobal
    public void borrarUsuario(Integer userId) {
        Users user = this.uf.find(userId);
        this.uf.remove(user);
    }

    //Cristobal
    public UserDTO getUsuario(Integer userId) {
        Users user = this.uf.find(userId);
        return user.toDTO();
    }

    //Cristobal
    public void editarUser(Integer userId, String rol, String username, String email, String name,
            String surname, String gender, String street, Integer number,
            String city, String region, Integer postalCode) {
        Users user = this.uf.find(userId);

        user.setRol(rol);
        user.setUsername(username);
        user.setEmail(email);
        if (name.isEmpty()) {
            name = null;
        }
        user.setName(name);
        if (surname.isEmpty()) {
            surname = null;
        }
        user.setSurname(surname);
        if (gender.isEmpty()) {
            gender = null;
        }
        user.setGender(gender);
        if (street.isEmpty()) {
            street = null;
        }
        user.setStreet(street);
        user.setNumber(number);
        if (city.isEmpty()) {
            city = null;
        }
        user.setCity(city);
        if (region.isEmpty()) {
            region = null;
        }
        user.setRegion(region);
        user.setPostalCode(postalCode);

        this.uf.edit(user);
    }

    //Cristobal
    public void crearUser(String rol, String username, String password, String email, String name,
            String surname, String gender, String street, Integer number,
            String city, String region, Integer postalCode) {
        Users user = new Users();

        user.setRol(rol);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        if (name.isEmpty()) {
            name = null;
        }
        user.setName(name);
        if (surname.isEmpty()) {
            surname = null;
        }
        user.setSurname(surname);
        if (gender.isEmpty()) {
            gender = null;
        }
        user.setGender(gender);
        if (street.isEmpty()) {
            street = null;
        }
        user.setStreet(street);
        user.setNumber(number);
        if (city.isEmpty()) {
            city = null;
        }
        user.setCity(city);
        if (region.isEmpty()) {
            region = null;
        }
        user.setRegion(region);
        user.setPostalCode(postalCode);

        System.out.println("sancho");
        System.out.println(rol + ", " + username + ", " + email + ", " + name + ", " + surname + ", " + gender + ", " + street + ", " + number + ", " + city + ", " + region + ", " + postalCode);
        
        this.uf.create(user);
    }

    // Antonio
    public List<UserDTO> usuariosDTODeUnaLista(int idList) {
       
        return this.ulf.getUsuariosDTOEnUnaLista(idList);
        
    }

    public List<UserDTO> listarUsuariosFiltrado(String nombreUsuario, String orderBy) {
        return this.uf.listarUsuariosFiltrado(nombreUsuario,orderBy);
    }
}

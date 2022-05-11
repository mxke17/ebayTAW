/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import DTO.UserDTO;
import Entity.Products;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mjura
 */
@Stateless
public class ProductsFacade extends AbstractFacade<Products> {

    @PersistenceContext(unitName = "ebayTAWPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductsFacade() {
        super(Products.class);
    }
    
    // Miguel
    public List<Products> findAllByUser (UserDTO vendedor){
        Query q;
        //q = this.getEntityManager().createQuery("select p from Products p WHERE p.userID.userID = :vendedor");
        q = this.getEntityManager().createQuery("select p from Products p WHERE p.userID.userID = :vendedor ORDER BY p.productID DESC");
        q.setParameter("vendedor", vendedor.getUserID());
        return q.getResultList();
    }

    // Cristobal
    public List<Products> findAllByTitulo (String titulo){
        Query q;
        q = this.getEntityManager().createQuery("select p from Products p WHERE p.title like :titulo");
        q.setParameter("titulo", '%' + titulo + '%');
        return q.getResultList();
    }
    
    // Miguel
    public List<Products> findByTitulo (String titulo, UserDTO vendedor){
        Query q;
        q = this.getEntityManager().createQuery("select p from Products p WHERE p.userID.userID = :vendedor AND p.title like :titulo ORDER BY P.productID DESC");
        q.setParameter("titulo", '%' + titulo + '%');
        q.setParameter("vendedor", vendedor.getUserID());
        return q.getResultList();
    }
    
    // Miguel
    public List<Products> findByVendidoTrue (){
        
        return null;
    }
    
}

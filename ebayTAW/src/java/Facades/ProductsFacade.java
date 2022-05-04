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
    
    public List<Products> findAllByUser (UserDTO vendedor){
        Query q;
        //q = this.getEntityManager().createQuery("select p from Products p WHERE p.userID.userID = :vendedor");
        q = this.getEntityManager().createQuery("select p from Products p WHERE p.userID.userID = :vendedor ORDER BY p.userID DESC");
        q.setParameter("vendedor", vendedor.getUserID());
        return q.getResultList();
    }
    
    public List<Products> findByTitulo (String titulo, UserDTO vendedor){
        Query q;
        q = this.getEntityManager().createQuery("select p from Products p WHERE p.userID.userID = :vendedor AND p.title like :titulo");
        q.setParameter("titulo", '%' + titulo + '%');
        q.setParameter("vendedor", vendedor.getUserID());
        return q.getResultList();
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.physique.interfaces;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author venus
 */
public class JPABase {
    protected EntityManagerFactory emf;
    protected EntityManager em;
    protected EntityTransaction transac;
    
    protected void close(){
        this.em.close();
        this.emf.close();
    }
    
    protected void open(){
        this.emf = Persistence.createEntityManagerFactory("PU");
        this.em = this.emf.createEntityManager();
        this.transac = this.em.getTransaction();
        this.transac.begin();
    }
}

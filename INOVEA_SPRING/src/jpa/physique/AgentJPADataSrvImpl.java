/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.physique;

import java.util.List;
import jpa.physique.interfaces.AgentJPADataSrv;
import jpa.metier.entity.AgentJPA;
import jpa.physique.interfaces.JPABase;
/**
 *
 * @author Oussama
 */
public class AgentJPADataSrvImpl extends JPABase implements AgentJPADataSrv {

    @Override
    public AgentJPA add(AgentJPA agent) throws Exception {
        this.open();
        this.em.persist(agent);
        this.transac.commit();
        this.close();
        return agent;
    }
    

    @Override
    public void remove(AgentJPA agent) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(AgentJPA agent) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AgentJPA getById(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AgentJPA getByNom(String nom) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AgentJPA getByEmail(String email) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AgentJPA getByTelephone(String telephone) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AgentJPA> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

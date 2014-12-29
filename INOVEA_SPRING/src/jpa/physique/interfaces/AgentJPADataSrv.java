/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.physique.interfaces;

import java.util.List;
import jpa.metier.entity.AgentJPA;

/**
 *
 * @author Oussama
 */
public interface AgentJPADataSrv {
    public AgentJPA add(AgentJPA agent) throws Exception;
    public void remove(AgentJPA agent) throws Exception;
    public void update(AgentJPA agent) throws Exception;
    
    public AgentJPA getById(Long id) throws Exception;
    public AgentJPA getByNom(String nom) throws Exception;
    public AgentJPA getByEmail(String email) throws Exception;
    public AgentJPA getByTelephone(String telephone) throws Exception;
    public List<AgentJPA> getAll() throws Exception;
}

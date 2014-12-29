/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.physique.interfaces;

import java.util.List;
import jpa.metier.entity.AdministrateurJPA;

/**
 *
 * @author Oussama
 */
public interface AdministrateurDataSrv {
    public AdministrateurJPA add(AdministrateurJPA administrateur) throws Exception;
    public void remove(AdministrateurJPA administrateur) throws Exception;
    public void update(AdministrateurJPA administrateur) throws Exception;
    
    public AdministrateurJPA getById(Long id) throws Exception;
    public AdministrateurJPA getByNom(String nom) throws Exception;
    public AdministrateurJPA getByEmail(String email) throws Exception;
    public List<AdministrateurJPA> getAll() throws Exception;
    //public AdministrateurJPA getContent(AdministrateurJPA client) throws Exception;
}

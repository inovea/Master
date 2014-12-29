/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.physique.interfaces;

import jpa.physique.AgentJPADataSrvImpl;

/**
 *
 * @author Oussama
 */
public class FactoryPhysiqueData {
    static AgentJPADataSrv agentJPADataSrv;
    
    public static AgentJPADataSrv getAgentJPADataSrv(){
        if(agentJPADataSrv == null){
            agentJPADataSrv = new AgentJPADataSrvImpl();
        }
        return agentJPADataSrv;
    }
}

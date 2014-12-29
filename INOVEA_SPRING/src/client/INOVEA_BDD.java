/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client;

import jpa.metier.entity.AgentJPA;
import jpa.physique.AgentJPADataSrvImpl;
import jpa.physique.interfaces.AgentJPADataSrv;
import jpa.physique.interfaces.FactoryPhysiqueData;


/**
 *
 * @author Oussama
 */
public class INOVEA_BDD {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        
        AgentJPA agent = new AgentJPA();
        agent.setNom("BENTALHA");
        AgentJPADataSrv agentSrv = FactoryPhysiqueData.getAgentJPADataSrv();
        if(agentSrv.add(agent) != null)
            System.out.println("GOOD!");
        
    }
    
}

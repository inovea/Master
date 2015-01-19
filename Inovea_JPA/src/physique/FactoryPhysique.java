/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package physique;

/**
 *
 * @author Oussama
 */
public class FactoryPhysique {
    static ContainerServicesImpl containerSrv;
    static AlertServicesImpl alertSrv;
    
    public static ContainerServicesImpl getContainerSrv(){
        if(containerSrv == null){
            containerSrv = new ContainerServicesImpl();
        }
        return containerSrv;
    }
    
    public static AlertServicesImpl getAlertSrv(){
        if(alertSrv == null){
            alertSrv = new AlertServicesImpl();
        }
        return alertSrv;
    }
    
}

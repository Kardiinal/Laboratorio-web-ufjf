/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auxiliar;


import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import Model.Systemusers;
import java.util.ArrayList;

/**
 *
 * @author Kardiinal
 */
public class SystemUsersControllers {
    public static String getUsuariosCadastrados(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prototipo2PU");
        SystemusersJpaController systemUsersJpa = new SystemusersJpaController(null, emf);
        List<Systemusers> sysUsers = systemUsersJpa.findSystemusersEntities();
        String usersNames = "";
        for(Systemusers sysUser: sysUsers){
            usersNames += " | " + sysUser.getUsername();
        }
        emf.close();
        return usersNames;
    }
    
    public static boolean validateLogin(String username,String password){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prototipo2PU");
        SystemusersJpaController systemUsersJpa = new SystemusersJpaController(null, emf);
        List<Systemusers> sysUsers = systemUsersJpa.findSystemusersEntities();
        boolean loginValido = false;
        for(Systemusers sysUser: sysUsers){
            
            String bdUsername = sysUser.getUsername().toLowerCase();
            String bdPassword = sysUser.getPassword().toLowerCase();
            String loginUsername = username.toLowerCase();
            String loginPassword = password.toLowerCase();
            

            if(bdUsername.equals(loginUsername) && bdPassword.equals(loginPassword)){
                loginValido = true;
            }
            
        }
        emf.close();
        return loginValido;
    }
}

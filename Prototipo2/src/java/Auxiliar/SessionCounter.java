/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auxiliar;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * This class listens to all the sessions being created and destroyed
 * 
 * @author www.planetofbits.com
 */
@WebListener
public class SessionCounter implements HttpSessionAttributeListener, HttpSessionListener
{

        private static int userCounter = 0;
        
        @Override
        public void sessionDestroyed(HttpSessionEvent event){
            HttpSession session = event.getSession();
            boolean logado = (boolean)session.getAttribute("logado");
            
            if(logado == true){
                userCounter--;
            }
            
        }
        
        
        @Override
        public void attributeReplaced(HttpSessionBindingEvent event) {
            HttpSession session = event.getSession();
            boolean logado = (boolean)session.getAttribute("logado");
            ServletContext servletContext = event.getSession().getServletContext();
            if(event.getName().equals("logado")){
                boolean temp = (boolean)event.getValue();
                if(temp == true && logado != true){
                    userCounter--;
                }else if (temp == false && logado != false){
                    userCounter++;
                }
            }
            //if(userCounter == -1)userCounter = 0;
        }
        
        public static int getUserCount(){
            return userCounter;
        }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}

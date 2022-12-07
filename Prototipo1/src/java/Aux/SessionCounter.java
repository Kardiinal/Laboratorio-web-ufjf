/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Aux;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import jakarta.servlet.http.HttpSession;

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
        
}
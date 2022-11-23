 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Aux.JavaBeans;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


import java.io.IOException;
import java.io.PrintWriter;


import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletException;;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Aux.JavaBeans;

/**
 *
 * @author ice
 */




import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 *
 * @author ice
 */
public class Control extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        //----------------------------------------------------------------------------------------//
        //Validação do login
        
        if(request == null){
            String a = "0";
        }
        
        String receivedUsername = request.getParameter("loginUsername");
        String receivedPassword = request.getParameter("loginPassword");
        JavaBeans jb = new JavaBeans();
        //boolean result = validaLogin(receivedUsername,receivedPassword);
        
        if(request.getParameter("erro") != null){
            ServletException error = new ServletException();
            //out.println(error);
            throw error;
        }
        
        // Pega a sessao
        HttpSession session = request.getSession(true);
        String code = request.getParameter("code"); 
        
        boolean logado = false;  
        Object tmp = session.getAttribute("logado");
        if (tmp != null && (boolean) tmp) {
            logado = true;
        }


        
        if (!logado) {
            if (receivedUsername != null) {
                // quer fazer login
                if (jb.getLoginValido(receivedUsername, receivedPassword)) {
                    session.setAttribute("logado", true);
                    logado = true;
                } else {
                    session.setAttribute("msg", "Login inválido!");
                }
            }else if(code != null && code.equals("sair")){
                session.setAttribute("msg", "Deslogado com sucesso!");
            }else {
                //session.setAttribute("msg", "Sessão expirou!!");
        
            }
        }
          
        if (logado) {
            request.setAttribute("logado", "true");
            request.setAttribute("user", receivedUsername);
            //response.sendRedirect("Menu.jsp");
        } else {
            request.setAttribute("logado", "false");
        }
        
        if(code!= null){
            switch(code){
                case "sair":
                    session.setAttribute("msg", "Deslogado com sucesso!");
                    session.setAttribute("logado", false);
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                    break;
                case "logar":
                    request.getRequestDispatcher("Menu.jsp").forward(request, response);
                    break;
                case "menu":
                    request.getRequestDispatcher("Menu.jsp").forward(request, response);
                    break;
                case "welcome":
                    request.getRequestDispatcher("Welcome.jsp").forward(request, response);                  
                    break;
                default:
                    
                    request.getRequestDispatcher("Login.jsp").forward(request, response);    
                    break;
            }
        }else{
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
        
        //request.getRequestDispatcher("Menu.jsp").forward(request, response);                   
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

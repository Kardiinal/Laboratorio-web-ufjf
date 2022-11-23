package Aux;


import jakarta.servlet.ServletException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ice
 */
public class JavaBeans {
    public boolean getLoginValido(String receivedUsername, String receivedPassword)
        throws ServletException, IOException {
        String resp = "test";

        String query = "SELECT username, password FROM APP.SYSTEMUSERS where upper(username) = '"
                + receivedUsername.toUpperCase() + "' and PASSWORD ='" +receivedPassword + "'";

        Connection con = null;
        Statement stmt = null;
        ResultSet rs;
        
        boolean result = false;
        //----------------------------------------------------------------------------------------//


        try{
            String url = "jdbc:derby://localhost:1527/LabProg";
            con = DriverManager.getConnection(url, "adm", "adm");             
            stmt = con.createStatement();                 
            rs = stmt.executeQuery(query);

            // Extract data from result set
            if (rs.next()) {
                result = true;
            }
            rs.close();
            stmt.close();
            con.close();

        }catch (SQLException e) {
            //Handle errors for JDBC
            resp = e.getMessage();
            throw new ServletException(e);
        } catch (Exception e) {
            //Handle errors for Class.forName
            resp = e.getMessage();
            throw new ServletException(e);
        }
        finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                throw new ServletException(e);
            }// nothing we can do
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new ServletException(e);
            }//end finally try
        } //end try
        return result;
    }
}

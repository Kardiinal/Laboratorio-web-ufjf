<%-- 
    Document   : Welcome
    Created on : 21/12/2022, 14:28:06
    Author     : Kardiinal
--%>

<%  
    
    Object objLogado = session.getAttribute("logado");
    
    boolean logado = false;

    if(objLogado != null){
        logado = (Boolean) objLogado;
    }
    if(!logado){
        request.getRequestDispatcher("Login.jsp").forward(request, response);
        //response.sendRedirect("Login.jsp");
    }
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <div>
            <center>
                <h1>Hello World!</h1>
                <a href='http://localhost:8080/Prototipo2/Control?code=menu'>Voltar para o Menu</a><br>
            </center>
        </div>
    </body>
</html>
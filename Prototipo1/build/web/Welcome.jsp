<%-- 
    Document   : Welcome
    Created on : 17 de nov de 2022, 22:25:41
    Author     : ice
--%>

<%  
    
    Object objLogado = session.getAttribute("logado");
    
    boolean logado = false;

    if(objLogado != null){
        logado = (boolean) objLogado;
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
                <a href='http://localhost:8080/Prototipo1/Control?code=menu'>Voltar para o Menu</a><br>
            </center>
        </div>
    </body>
</html>

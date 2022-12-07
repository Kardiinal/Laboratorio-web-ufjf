<%-- 
    Document   : Menu
    Created on : 1 de nov de 2022, 21:26:13
    Author     : ice
--%>
<%@ page import="Aux.SessionCounter"%>
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
        <title>Protótipo 1 - Menu</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="refresh" content="20"/>
    </head>
    <body>
        <div>
            <center>
                <%
		int userCount = SessionCounter.getUserCount();
                %>
                <h3>Numero de usuarios logados: <%=userCount%></h3>
                <a href="http://localhost:8080/Prototipo1/Control?code=welcome">Welcome</a> <br>
                <a href='http://localhost:8080/Prototipo1/asda'>Erro HTML</a><br>
                <a href='http://localhost:8080/Prototipo1/Control?erro=true'>Erro Java</a><br>
                <a href='http://localhost:8080/Prototipo1/Control?code=sair'>Sair</a><br>

            </center>
                <jsp:include page = "adrotator.jsp" flush="true"/>
        </div>
                
    </body>
</html>

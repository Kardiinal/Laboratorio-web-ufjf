<%-- 
    Document   : Menu
    Created on : 21/12/2022, 12:13:24
    Author     : Kardiinal
--%>
<%@ page import="Auxiliar.SystemUsersControllers"%>
<%@ page import="Auxiliar.SessionCounter"%>
<%  
    
    Object objLogado = session.getAttribute("logado");
    String usersInSystem = SystemUsersControllers.getUsuariosCadastrados();
    boolean logado = false;

    if(objLogado != null){
        logado = (Boolean) objLogado;
    }
    if(!logado){
        request.getRequestDispatcher("Login.jsp").forward(request, response);
        //response.sendRedirect("Login.jsp");
    }
    
    //SystemusersController.getSystemUsers();

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Protótipo 2 - Menu</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="refresh" content="20"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div>
            <center>
                <h3>Usuarios Cadastrados no Sistema: <%=usersInSystem%> </h3>
                <%
		int userCount = SessionCounter.getUserCount();
                
                %>
                <h3>Numero de usuarios logados: <%=userCount%></h3>
                <a href="http://localhost:8080/Prototipo2/Control?code=welcome">Welcome</a> <br>
                <a href='http://localhost:8080/Prototipo2/asda'>Erro HTML</a><br>
                <a href='http://localhost:8080/Prototipo2/Control?erro=true'>Erro Java</a><br>
                <a href='http://localhost:8080/Prototipo2/Control?code=sair'>Sair</a><br>

            </center>
                <jsp:include page = "adrotator.jsp" flush="true"/>
        </div>
                
    </body>
</html>

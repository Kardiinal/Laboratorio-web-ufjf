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
        <style>
            .contentHolder{
                width: 500px;
                height: 500px;
                display: flex;
                justify-content: center;
                align-items: center;
                box-shadow: 0px 0px 30px;
                border-radius: 20px;
                background-color: white;
                flex-direction: column;
            }
            .pageContent, html{
                width: 100vw;
                height: 100vh;
                background-image: linear-gradient(to right top, #051937, #004d7a, #008793, #00bf72, #a8eb12) !important;
                display: flex;
                justify-content: center;
                align-items: center;
                flex-direction: column;
            }
            .loginBtn {
                margin-left: auto;
                margin-right: auto;
                display: block;
                transition: transform .2s;
            }
            
            .loginBtn:hover {
                transform: scale(1.5);
            }
            
            .directLink{
                width: 150px;
                height: 50px;
                background-color: white;
                box-shadow: 0px 0px 15px;
                margin: 15px 0px 15px 0px;
                transition: transform .2s;
                display: flex;
                justify-content: center;
                border-radius: 20px;
                align-items: center;
            }
            
            .directLink:hover {
                transform: scale(1.5);
            }
            
            .banner{
                width: 500px;
                height: 150px;
                background-color: white;
                box-shadow: 0px 0px 30px;
                margin: 15px 0px 15px 0px;
                transition: transform .2s;
                display: flex;
                justify-content: center;
                border-radius: 20px;
                align-items: center;
            }
            
            .banner[img]{
                size: auto;
            }
            
        </style>
    </head>
    <body>
        <div class="pageContent">
            
                
                <%
		int userCount = SessionCounter.getUserCount();
                
                %>
                <h3>Usuarios Cadastrados no Sistema: <%=usersInSystem%> </h3>
                <h3>Numero de usuarios logados: <%=userCount%></h3><br>
                <div class="contentHolder">
                    <a class="directLink" href="http://localhost:8080/Prototipo2/Control?code=welcome">Welcome</a>
                    <a class="directLink" href='http://localhost:8080/Prototipo2/asda'>Erro HTML</a>
                    <a class="directLink" href='http://localhost:8080/Prototipo2/Control?erro=true'>Erro Java</a>
                    <a class="directLink" href='http://localhost:8080/Prototipo2/Control?code=sair'>Sair</a>
                </div>
                <div class="banner">
                    <jsp:include page = "adrotator.jsp" flush="true"/>
                </div>
                
        </div>
                
    </body>
</html>

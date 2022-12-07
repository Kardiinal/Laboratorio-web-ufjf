<%-- 
    Document   : Login.jsp
    Created on : 1 de nov de 2022, 21:59:35
    Author     : ice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="Aux.SessionCounter"%>
<%  
    
    //import Aux.SessionCounter;
    Object objMsg = session.getAttribute("msg");
    String msg = "";
    
    
    if(objMsg != null){
        msg = (String) objMsg;
        String a = "a";
    }else{
        
    }
    

%>
<html>
    <head>
        <title>Prototipo 1 - Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <center>
            <%
		int userCount = SessionCounter.getUserCount();
            %>
            <h3>Numero de usuarios logados: <%=userCount%></h3>
            <div style="width: 200px">
            <p><%=msg%></p>
            <form action="Control" method="POST">
                <div class="form-group">
                    <p style="text-align: left;">Informe seu Login: 
                    <input type="text" name="loginUsername" class="form-control" placeholder="Login"></p>
                </div>
                <div class="form-group">
                    <p style="text-align: left;">Informe sua Senha: 
                    <input type="password" name="loginPassword" class="form-control" placeholder="Password"></p>
                </div>
                <input type="hidden" name="code" value="logar">
                <p style="text-align: left;" ><input type="submit" class="btn btn-default" value="Login"></p>
            </form>
            </div>
        </center>
    </body>
</html>

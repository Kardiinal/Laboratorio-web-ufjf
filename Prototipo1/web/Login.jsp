<%-- 
    Document   : Login.jsp
    Created on : 1 de nov de 2022, 21:59:35
    Author     : ice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
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
    </head>
    <body>
        <center>
            <p><%=msg%></p>
            <form action="Control" method="POST">
                <p>Informe seu Login: <input type="text" name="loginUsername"></p>
                <p>Informe sua Senha: <input type="password" name="loginPassword"></p>
                <input type="hidden" name="code" value="logar">
                <p><input type="submit" value="Login"> 
            </form>
        </center>
    </body>
</html>

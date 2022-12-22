<%-- 
    Document   : Login
    Created on : 21/12/2022, 11:22:24
    Author     : Kardiinal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="Auxiliar.SessionCounter"%>
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
        <style>
            .formHolder{
                width: 500px;
                height: 500px;
                display: flex;
                justify-content: center;
                align-items: center;
                box-shadow: 0px 0px 30px;
                border-radius: 20px;
                background-color: white;
            }
            .pageBackGround, html{
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
            
        </style>
    </head>
    <body>
            <%
		int userCount = SessionCounter.getUserCount();
            %>
            <div class="pageBackGround">
                <h3>Numero de usuarios logados: <%=userCount%></h3>
                <div class="formHolder">
                    
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
                            <p style="text-align: left;" ><input type="submit" class="loginBtn btn btn-default" value="Login"></p>
                        </form>
                    </div>
                </div>
            </div>
    </body>
</html>

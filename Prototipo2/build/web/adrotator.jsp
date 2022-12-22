<%-- 
    Document   : adrotator
    Created on : 21/12/2022, 14:25:48
    Author     : Kardiinal
--%>


<%@page import="Auxiliar.Rotator"%>
<jsp:useBean id = 'rotator' scope = 'session' class = 'Auxiliar.Rotator' />

    <% rotator.nextAd(); %>
    <p>
        <a href= "<jsp:getProperty name = 'rotator' property = 'link' />" target="blank">
            <img style="max-height:100px; max-width:100px;" src = "<jsp:getProperty name = 'rotator' property = 'image' />" alt = "advertisement">
        </a>
    </p>
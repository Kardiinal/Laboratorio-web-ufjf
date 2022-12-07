
<%@page import="Aux.Rotator"%>
<jsp:useBean id = 'rotator' scope = 'session' class = 'Aux.Rotator' />

    <% rotator.nextAd(); %>
    <p>
        <a href= "<jsp:getProperty name = 'rotator' property = 'link' />" target="blank">
            <img style="max-height:100px; max-width:100px;" src = "<jsp:getProperty name = 'rotator' property = 'image' />" alt = "advertisement">
        </a>
    </p>
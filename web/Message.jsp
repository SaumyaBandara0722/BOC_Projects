<%-- 
    Document   : Message
    Created on : Oct 28, 2020, 11:17:18 AM
    Author     : Saumya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Message</title>
    </head>
    <body>
        <center>
            <h3><%=request.getAttribute("Message")%></h3>
        </center>
    </body>
</html>

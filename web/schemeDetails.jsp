<%-- 
    Document   : schemeDetails
    Created on : Sep 21, 2020, 4:37:40 PM
    Author     : 977042160v
--%>
<%@page import="java.util.List"%>
<%@page import="com.DBHandler"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Scheme"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="views/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Scheme Details</title>
    </head>

    <body>
        <%
            // get value from text fields
            String segmentField = request.getParameter("txtSegment");
            String purposeField = request.getParameter("txtPurpose");
            

            List<Scheme> l = DBHandler.readSchemes(segmentField, purposeField);
            request.setAttribute("scheme", l);
        %>

        <h2 style="text-align:center">Select Your Scheme</h2>
        <br>
        <table class="table table-striped">
            <thead>
            <th>Scheme Id</th>
            <th>Scheme Name</th> 
            <th>Description</th>
            <th>Selection</th>
        </thead>           

        <tbody>
            <c:forEach items="${ scheme }" var="u">
                <tr>
                    <td>${u.getSid()}</td>
                    <td>${u.getSname()}</td>
                    <td>${u.getDesc()}</td>
                    <td> <form action="SchemeSevlet2" method="get">
                        <input type="hidden" name="hidIDSave" value="${u.getSid()}">                       
                        <input type="submit" value ="View more" class="btn btn-secondary" style="background-color:#000000; border: none;"/>
                    </form>
                    </td>
                </tr>

            </c:forEach>
        </tbody>
    </table>
</body>

</html>

<%-- 
    Document   : view_segment
    Created on : Sep 29, 2020, 8:55:47 AM
    Author     : 977042160v
--%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.DBHandler"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String driver = "com.mysql.jdbc.Driver";
    String connectionUrl = "jdbc:mysql://localhost:3306/";
    String database = "loan_advisory";
    String userid = "root";
    String password = "root";
    String id = request.getParameter("id");
    try {
        Class.forName(driver);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="views/bootstrap.min.css">
        <script src="Components/jquery-3.5.1.min.js" type="text/javascript"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Segment Details</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar navbar-light" style="background-color: #E8E8FA;">
            <a class="navbar-brand" href="#">Loan Advisory</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="index.html">Home <span class="sr-only">(current)</span></a>
                    </li>

                    <li class="nav-item active">
                        <a class="nav-link" href="customer.jsp">Customer Request<span class="sr-only">(current)</span></a>
                    </li>

                    <li class="dropdown">                   
                        <a href="#" class="nav-link" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Segment and purpose<span class="caret"></span></a>
                        <ul class="dropdown-menu">                        
                            <li class="dropdown-item"><a href="purpose.jsp">Add Purpose</a></li>
                            <li class="dropdown-item"><a href="segment.jsp">Add Segment</a></li>
                            <li class="dropdown-item"><a href="view_purpose.jsp">View Purpose</a></li>
                            <li class="dropdown-item"><a href="view_segment.jsp">View Segment</a></li>
                        </ul>
                    </li>

                    <li class="dropdown">
                        <a href="#" class="nav-link" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Loan Scheme<span class="caret"></span></a>
                        <ul class="dropdown-menu">                        
                            <li class="dropdown-item"><a href="selectScheme.jsp">Select</a></li>
                            <li class="dropdown-item"><a href="schemeManagement.jsp">Add</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>

        <h1>All Available Segments</h1>
        <br>   
        <table class="table table-striped">
            <thead>
            <th>Segment Id</th>
            <th>Segment Name</th>
            <th>Current Status</th>
            <th>Selection</th>
        </thead>           

        <%
            try {
                connection = DriverManager.getConnection(connectionUrl + database, userid, password);
                statement = connection.createStatement();
                String sql = "select * from loan_advisory.segment where status='active'";
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
        %>

        <tr>               
            <td><%=resultSet.getString("segId")%></td>
            <td><%=resultSet.getString("segName")%></td>
            <td><%=resultSet.getString("status")%></td>
            <td> <form action="UpdateSegmentServlet" method="post">
                    <input type="hidden" name="hidIDSave" value="<%=resultSet.getString("segId")%>">
                    <input type="hidden" name="hidUpdateSegment" value="updateSegment">
                    <input id="btnUpdate" name="btnUpdate" type="submit" value ="Edit" class="btn btn-secondary"/>
                </form>
            </td>
            <td>
                <form action="UpdateSegmentServlet" method="post">
                    <input type="hidden" name="hidIDSave" value="<%=resultSet.getString("segId")%>">
                    <input type="hidden" name="hidUpdateSegment" value="deleteSegment">
                    <input name="btnDelete" type="submit" value ="Delete" class="btn btn-secondary">
                </form>

            <td>

        </tr>

        <%
                }
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
    </table> 
</body>
</html>

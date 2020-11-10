<%-- 
    Document   : selectScheme
    Created on : Oct 6, 2020, 8:33:10 AM
    Author     : 977042160v
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="model.Scheme"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="views/bootstrap.min.css">
        <script src="Components/jquery-3.5.1.min.js" type="text/javascript"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Select Scheme</title>
    </head>

    <body>
        <nav class="navbar navbar-expand-lg navbar navbar-light" style="background-color: #FFE933;">
            <img src="views/download.png" alt="" style="width:90px;height:70px;"/>
            <a class="navbar-brand" href="#" style="white-space:pre">&#9Loan Advisory</a>     
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

        <div class="container" style="width: 50%; align-items: center">
            <div class="row">
                <div class="col-8"><br>
                    <h5 style="text-align:center">Add required loan segment and purpose to get avaliable loan schemes</h5>
                    <br>
                    <form action="schemeDetails.jsp" method="post">                                      

                        <!-- SEGMENT -->
                        <div class="input-group input-group-sm mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="lblName">Segment: </span>
                            </div>
                            <select class="form-control" name="txtSegment" id="txtSegment">
                                <option value="-1">select segment</option>
                                <%
                                    Connection con = null;
                                    try {
                                        Class.forName("com.mysql.jdbc.Driver");
                                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loan_advisory?useSSL=false", "root", "admin");
                                        String query = "select * from segment where status='active'";
                                        Statement stm = con.createStatement();
                                        ResultSet rs = stm.executeQuery(query);

                                        while (rs.next()) {
                                %>
                                <option value="<%=rs.getString("segName")%>" required=""><%=rs.getString("segName")%></option>
                                <%
                                        }
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                        out.println("Error" + ex.getMessage());
                                    }
                                %>
                            </select>
                        </div>

                        <!-- PURPOSE -->
                        <div class="input-group input-group-sm mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="lblName">Purpose: </span>
                            </div>
                            <!--                            <input type="text" id="txtPurpose" name="txtPurpose" required>-->
                            <select class="form-control" name="txtPurpose">
                                <option value="-1">select purpose</option>
                                <%
                                    Connection conn = null;
                                    try {
                                        Class.forName("com.mysql.jdbc.Driver");
                                        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loan_advisory?useSSL=false", "root", "admin");
                                        String query = "select * from purpose where purpose_status='active'";
                                        Statement stm = con.createStatement();
                                        ResultSet rs = stm.executeQuery(query);

                                        while (rs.next()) {
                                %>
                                <option value="<%=rs.getString("purpose")%>" required=""><%=rs.getString("purpose")%></option>
                                <%
                                        }
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                        out.println("Error" + ex.getMessage());
                                    }
                                %>
                            </select>
                        </div>

                        <input type="submit" name="btnSave" value="View Scheme Details" class="btn btn-primary" style="background-color:#000000; border: none;">
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

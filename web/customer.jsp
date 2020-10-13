<%-- 
    Document   : customer
    Created on : Sep 21, 2020, 1:56:33 PM
    Author     : 977042160v
--%>

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
        <title>Loan Request</title>
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

        <div class="container">
            <div class="row">
                <div class="col-8">
                    <h1 class="m-3">Customer Request Form</h1>
                    <form id="formCustomer" action="AddCustomerServlet" method="post">                                      
                        <!-- NIC -->
                        <div class="input-group input-group-sm mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="lblName">NIC: </span>                           
                            </div>                       
                            <input type="text" id="txtNIC" name="txtNIC">                       
                            <input type="button" id="btnCheck" value="Check" class="btn btn-primary">                      
                        </div>                 

                        <!-- NAME -->
                        <div class="input-group input-group-sm mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="lblName">Name: </span>
                            </div>
                            <input type="text" id="txtName" name="txtName">
                        </div>

                        <!-- PHONE NUMBER -->
                        <div class="input-group input-group-sm mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="lblName">Phone Number: </span>
                            </div>
                            <input type="text" id="txtPhone" name="txtPhone">
                        </div>

                        <!-- ACCOUNT NUMBER -->
                        <div class="input-group input-group-sm mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="lblName">Account Number: </span>
                            </div>
                            <input type="text" id="txtAccount" name="txtAccount">
                        </div>                   

                        <!-- SEGMENT -->
                        <div class="input-group input-group-sm mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="lblName">Segment: </span>
                            </div>
                            <input type="text" id="txtSegment" name="txtSegment">
                        </div>

                        <!-- PURPOSE -->
                        <div class="input-group input-group-sm mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="lblName">Purpose: </span>
                            </div>
                            <input type="text" id="txtPurpose" name="txtPurpose">
                        </div>

                        <!-- AMOUNT -->
                        <div class="input-group input-group-sm mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="lblName">Request Amount: </span>
                            </div>
                            <input type="text" id="txtAmt" name="txtAmt">
                        </div>

                        <!-- SCHEME -->
                        <div class="input-group input-group-sm mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="lblScheme">Loan Scheme: </span>
                            </div>
                            <input type="text" id="txtScheme" name="txtScheme">
                        </div>

                        <!--                    <div id="alertSuccess" class="alert alert-success"></div>
                                            <div id="alertError" class="alert alert-danger"></div>-->

                       <button type="submit" id="btnSave" form="formCustomer" value="Submit" class="btn btn-primary">Save</button>
<!--                        <input type="submit" name="btnSave"  value="Submit" class="btn btn-primary">-->
                    </form>                
                </div>
            </div>
        </div>
    </body>
</html>


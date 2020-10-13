<%-- 
    Document   : schemeManagement
    Created on : Sep 24, 2020, 3:47:13 PM
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
        <title>Loan Schemes</title>
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
                    <h1 class="m-3">Add New Loan Schemes</h1>                               
                    <form action = "UploadServlet" method = "post" enctype = "multipart/form-data">
                        <!-- SCHEME NAME -->
                        <div class="input-group input-group-sm mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="lblName">Scheme Name: </span>                           
                            </div>                       
                            <input type="text" id="txtName" name="txtName">                                          
                        </div>                 

                        <!-- DESCRIPTION     -->
                        <div class="input-group input-group-sm mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="lblDesc">Description: </span>
                            </div>
                            <input type="text" id="txtDesc" name="txtDesc">
                        </div>

                        <!-- SEGMENT -->
                        <div class="input-group input-group-sm mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="lblSegment">Segment: </span>
                            </div>
                            <input type="text" id="txtSegment" name="txtSegment">
                        </div>

                        <!-- PURPOSE -->
                        <div class="input-group input-group-sm mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="lblPurpose">Purpose: </span>
                            </div>
                            <input type="text" id="txtPurpose" name="txtPurpose">
                        </div>                                           

                    <!-- upload a file -->                    
                    Select a file to upload:
                    <br>
                    <input type = "file" name = "file" size = "50" />
                    <br>
                    <input type = "submit" value = "Upload File" />
                    
                    <div>                    
                    <button type="submit" id="btnSave" form="formLoanScheme" value="Submit" class="btn btn-primary">Save</button>
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

<%-- 
    Document   : upload
    Created on : Oct 13, 2020, 9:38:36 AM
    Author     : 977042160v
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload Scheme</title>
    </head>
    <body>

        <div class="container">
            <div class="row">
                <div class="col-8">
                    <h1 class="m-3">Add New Loan Schemes</h1>                               
                    <form action = "SchemeSevlet1" method = "post" enctype = "multipart/form-data">
                        <!-- SCHEME NAME -->
                        <div class="input-group input-group-sm mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="lblName">Scheme Name: </span>                           
                            </div>                       
                            <input type="text" id="txtName" name="txtName" required="">                                          
                        </div>                 

                        <!-- DESCRIPTION     -->
                        <div class="input-group input-group-sm mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="lblDesc">Description: </span>
                            </div>
                            <input type="text" id="txtDesc" name="txtDesc" required="">
                        </div>

                        <!-- SEGMENT -->
                        <div class="input-group input-group-sm mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="lblSegment">Segment: </span>
                            </div>
                            <input type="text" id="txtSegment" name="txtSegment" required="">
                        </div>

                        <!-- PURPOSE -->
                        <div class="input-group input-group-sm mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="lblPurpose">Purpose: </span>
                            </div>
                            <input type="text" id="txtPurpose" name="txtPurpose" required="">
                        </div> 
                        <!-- upload a file -->                    
                        Select a file to upload:
                        <br>
                        <input type = "file" name = "file" size = "50" required=""/>
                        <br>
                        <input type = "submit" value = "Submit" />


                    </form>
    </body>
</html>

<%@page import="model.Segment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="views/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>edit_segment</title>
    </head>
    <body>
        <%
            Segment s = new Segment();
            s = (Segment)request.getAttribute("sObject");
            
        %>
        <h1>Edit Details</h1>
        <form id="formSegment" action="UpdateSegmentServlet" method="post">
            <!-- SEGMENT ID -->
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="lblID">Segment ID: </span>                           
                </div>                       
                <input type="text" id="txtID" name="txtID" value="<%=s.getSegId()%>">                                         
            </div>
                    
            <!-- SEGMENT NAME -->
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="lblName">Segment Name: </span>                           
                </div>                       
                <input type="text" id="txtName" name="txtName" value="<%=s.getSegName()%>">                                         
            </div>

            <input type="submit" name="hidUpdateSegment" form="formSegment"  value="Update" class="btn btn-primary">
            
        </form>
    </body>
</html>

//check MySql JDBC Driver version.should be mysql-connector-java-5.1.49.jar
package com;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class UploadServlet extends HttpServlet {
    
    // database connection settings
    private String dbURL = "jdbc:mysql://localhost:3306/loan_advisory?useSSL=false";
    private String dbUser = "root";
    private String dbPass = "admin";
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // gets values of text fields
        String schemeName = request.getParameter("txtName");
        String desc = request.getParameter("txtDesc");
        String segment = request.getParameter("txtSegment");
        String purpose = request.getParameter("txtPurpose");
                
        InputStream inputStream = null; // input stream of the upload file
         
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("file");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
         
        Connection conn = null; // connection to the database
        String message = null;  // message will be sent back to client
         
        try {
            // connects to the database
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
            
            // constructs SQL statement
            String sql = "INSERT INTO `scheme` (`id`, `schemeName`, `desc`, `segment`, `purpose`, `file`) values (?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, 0);
            statement.setString(2, schemeName);
            statement.setString(3, desc);
            statement.setString(4, segment);
            statement.setString(5, purpose);
             
            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                statement.setBlob(6, inputStream);
            }
 
            // sends the statement to the database server
            int row = statement.executeUpdate();
            if (row > 0) {
                message = "File uploaded and saved into database";
            }
        } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                // closes the database connection
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            // sets the message in request scope
            request.setAttribute("Message", message);
             
            // forwards to the message page
            getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
        }
    
    }

}

package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Scheme;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author 977042160v
 */
@WebServlet("/schemeDetails")
public class SchemeSevlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public SchemeSevlet2() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("hidIDSave")!=null?request.getParameter("hidIDSave"):"NA";
         
        ServletOutputStream sos;
        Connection  con=null;
        PreparedStatement pstmt=null;
         
        response.setContentType("application/pdf");
 
        response.setHeader("Content-disposition","inline; filename="+id+".pdf" );
 
 
        sos = response.getOutputStream();
         
 
           try {
               Class.forName("com.mysql.jdbc.Driver");
               con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loan_advisory?useSSL=false","root","admin");
          } catch (Exception e) {
                     System.out.println(e);
                     System.exit(0); 
                          }
            
          ResultSet rset=null;
            try {
                pstmt = con.prepareStatement("Select file from scheme where id=?");
                pstmt.setString(1, id.trim());
                rset = pstmt.executeQuery();
                if (rset.next())
                    sos.write(rset.getBytes("file"));
                else
                    return;
                 
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
     
        sos.flush();
        sos.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String segment = request.getParameter("txtSegment");
        String purpose = request.getParameter("txtPurpose");

        DBHandler dbh = new DBHandler();
        ArrayList<Scheme> Scheme = new ArrayList<Scheme>();
        Scheme = (ArrayList<Scheme>) dbh.readSchemes(segment, purpose);

        request.setAttribute("sObject", Scheme);
        request.getRequestDispatcher("schemeDetails.jsp").forward(request, response);               
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Scheme;

/**
 *
 * @author 977042160v
 */
public class SchemeSevlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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

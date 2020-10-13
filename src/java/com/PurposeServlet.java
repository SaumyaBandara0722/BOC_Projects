package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Purpose;

/**
 *
 * @author 977042160v
 */
public class PurposeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {
            String pId = request.getParameter("txtID");
            String segName = request.getParameter("txtName");
            String purpose = request.getParameter("txtPurpose");

            Purpose p = new Purpose();
            p.setPid(pId);
            p.setSname(segName);
            p.setPurpose(purpose);

            int status = DBHandler.addPurpose(p);
            if (status > 0) {
                out.print("Record saved successfully!");
                request.getRequestDispatcher("purpose.jsp").include(request, response);
            } else {
                out.println("Sorry! unable to save record");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pid = request.getParameter("hidUpdatePurpose");

        try {
            switch (pid) {
                case "updatePurpose":
                    updatePurpose(request, response);
                    break;
                case "Update":
                    updatePurposeDetails(request, response);
                    break;
                case "deletePurpose":
                    deletePurpose(request,response);
                    break;
                default:
                    break;
            }

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void updatePurpose(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String pid = request.getParameter("hidIDSave");
        DBHandler dbh = new DBHandler();
        Purpose p;

        p = dbh.readPurposeDetails(pid);

        try {
            request.setAttribute("sObject", p);
            request.getRequestDispatcher("edit_purpose.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void updatePurposeDetails(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        try (PrintWriter out = response.getWriter()) {
    
                String pId = request.getParameter("txtID");
                String segName = request.getParameter("txtName");
                String purpose = request.getParameter("txtPurpose");

                Purpose p = new Purpose();
                
                p.setPid(pId);
                p.setSname(segName);
                p.setPurpose(purpose);

                int status = DBHandler.updatePurpose(p);
                if (status > 0) {
                    out.print("Record updated successfully!");
                    request.getRequestDispatcher("edit_purpose.jsp").include(request, response);
                } else {
                    out.println("Sorry! unable to update record");
                }
            }
        
    }
    
    private void deletePurpose(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        try (PrintWriter out = response.getWriter()) {

            String pid = request.getParameter("hidIDSave");
            Purpose p = new Purpose();

            p.setPid(pid);

            int output = DBHandler.deletePurposeDetails(p);
            if (output > 0) {
                out.print("Record deleted successfully!");
                request.getRequestDispatcher("view_purpose.jsp").include(request, response);
            } else {
                out.println("Sorry! unable to delete record");
            }
        }
    }
}

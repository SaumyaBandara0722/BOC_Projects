package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Segment;

/**
 *
 * @author 977042160v
 */
public class UpdateSegmentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pid = request.getParameter("hidUpdateSegment");

        try {
            switch (pid) {
                case "updateSegment":
                    update(request, response);
                    break;
                case "Update":
                    updateSegment(request, response);
                    break;
                case "deleteSegment":
                    deleteSegment(request,response);
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

    private void update(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String sId = request.getParameter("hidIDSave");
        DBHandler dbh = new DBHandler();
        Segment s;

        s = dbh.readDetails(sId);

        try {
            request.setAttribute("sObject", s);
            request.getRequestDispatcher("edit_segment.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void updateSegment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        try (PrintWriter out = response.getWriter()) {

            String sid = request.getParameter("txtID");
            String segName = request.getParameter("txtName");

            Segment s = new Segment();

            s.setSegId(sid);
            s.setSegName(segName);

            int status = DBHandler.updateSegmentdetails(s);
            if (status > 0) {
                out.print("Record updated successfully!");
                request.getRequestDispatcher("edit_segment.jsp").include(request, response);
            } else {
                out.println("Sorry! unable to update record");
            }
        }
    }
    
    private void deleteSegment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        try (PrintWriter out = response.getWriter()) {

            String sid = request.getParameter("hidIDSave");
            Segment s = new Segment();

            s.setSegId(sid);

            int output = DBHandler.deleteSegmentDetails(s);
            if (output > 0) {
                out.print("Record deleted successfully!");
                request.getRequestDispatcher("view_segment.jsp").include(request, response);
            } else {
                out.println("Sorry! unable to delete record");
            }
        }
    }
}

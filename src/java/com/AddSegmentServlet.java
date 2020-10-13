package com;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Segment;

/**
 *
 * @author 977042160v
 */
public class AddSegmentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        try (PrintWriter out = response.getWriter()) {
            String segId = request.getParameter("txtID");
            String segName = request.getParameter("txtName");
           
            Segment s = new Segment();
            s.setSegId(segId);
            s.setSegName(segName);
            
            int status = DBHandler.addSegment(s);
            if (status > 0) {
                out.print("Record saved successfully!");
                request.getRequestDispatcher("segment.jsp").include(request, response);
            } else {
                out.println("Sorry! unable to save record");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

package com;

// Import required java libraries
import java.io.*;
import java.util.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Scheme;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;

public class UploadServlet extends HttpServlet {

    private boolean isMultipart;
    private String filePath;
    private int maxFileSize = 50 * 1024;
    private int maxMemSize = 4 * 1024;
    private File file;

    public void init() {
        // Get the file location where it would be stored.
        filePath = getServletContext().getInitParameter("file-upload");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        throw new ServletException("GET method used with "
                + getClass().getName() + ": POST method required.");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Check that we have a file upload request
        isMultipart = ServletFileUpload.isMultipartContent(request);
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();

        if (!isMultipart) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet upload</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>No file uploaded</p>");
            out.println("</body>");
            out.println("</html>");
            return;
        }

        DiskFileItemFactory factory = new DiskFileItemFactory();

        // maximum size that will be stored in memory
        factory.setSizeThreshold(maxMemSize);

        // Location to save data that is larger than maxMemSize.
        factory.setRepository(new File("c:\\temp"));

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // maximum file size to be uploaded.
        upload.setSizeMax(maxFileSize);

        try {
            // Parse the request to get file items.
            List fileItems = upload.parseRequest(request);

            // Process the uploaded file items
            Iterator i = fileItems.iterator();

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet upload</title>");
            out.println("</head>");
            out.println("<body>");

            while (i.hasNext()) {
                FileItem fi = (FileItem) i.next();
                if (!fi.isFormField()) {
                    // Get the uploaded file parameters
                    String fieldName = fi.getFieldName();
                    String fileName = fi.getName();
                    String contentType = fi.getContentType();
                    boolean isInMemory = fi.isInMemory();
                    long sizeInBytes = fi.getSize();

                    String sname = request.getParameter("txtName");
                    String description = request.getParameter("txtDesc");
                    String segment = request.getParameter("txtSegment");
                    String purpose = request.getParameter("txtPurpose");

                    Scheme s = new Scheme();
                    s.setSname(sname);
                    s.setDesc(description);
                    s.setSegment(segment);
                    s.setPurpose(purpose);

                    // Write the file
                    if (fileName.lastIndexOf("\\") >= 0) {
                        file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\")));
                        int status = DBHandler.AddScheme(s);
                    if (status > 0) {
                        out.print("Record saved successfully!");
                        request.getRequestDispatcher("schemeManagement.jsp").include(request, response);
                    } else {
                        out.println("Sorry! unable to save record");
                    }
                    
                    out.println("Uploaded Filename: " + fileName + "<br>");
                    } else {
                        file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\") + 1));
                    }
                    fi.write(file);

                    
                }
            }
            out.println("</body>");
            out.println("</html>");
        } catch (Exception ex) {
            System.out.println(ex);
        }

//        //add loan scheme
//        try {
//            String sname = request.getParameter("txtName");
//            String description = request.getParameter("txtDesc");
//            String segment = request.getParameter("txtSegment");
//            String purpose = request.getParameter("txtPurpose");
//            String fileLink = request.getParameter("file");
//
//            Scheme s = new Scheme();
//            s.setSname(sname);
//            s.setDesc(description);
//            s.setSegment(segment);
//            s.setPurpose(purpose);
//            s.setPath(fileLink);
//
//            int status = DBHandler.AddScheme(s);
//            if (status > 0) {
//                out.print("Record saved successfully!");
//                request.getRequestDispatcher("schemeManagement.jsp").include(request, response);
//            } else {
//                out.println("Sorry! unable to save record");
//            }
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

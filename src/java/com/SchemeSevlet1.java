package com;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


@WebServlet(name="SchemeSevlet1", urlPatterns={"/SchemeSevlet1"})     // specify urlPattern for servlet
@MultipartConfig(fileSizeThreshold = 1024*1024*10, maxFileSize = 1024*1024*1000, maxRequestSize = 1024*1024*1000)                                               // specifies servlet takes multipart/form-data
public class SchemeSevlet1 extends HttpServlet {
    
    PrintWriter out = null;
    Connection con = null;
    PreparedStatement ps = null;
    HttpSession session = null;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        try{
            out = response.getWriter();
            session = request.getSession(false);
            String folderName = "resources";
            String uploadPath = request.getServletContext().getRealPath("") + File.separator + folderName;
            File dir = new File(uploadPath);
            if(!dir.exists()){
                dir.mkdirs();
            }
            Part filePart = request.getPart("file");
            String sname = request.getParameter("txtName");
            String description = request.getParameter("txtDesc");
            String segment = request.getParameter("txtSegment");
            String purpose = request.getParameter("txtPurpose");
            String fileName = filePart.getSubmittedFileName();
            String path = folderName + File.separator + fileName;
            InputStream is = filePart.getInputStream();
            Files.copy(is, Paths.get(uploadPath + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING);
            
            try{
                con = DBHandler.getConnection();
                System.out.println("connection done");
                String sql = "insert into scheme_details(id,schemeName,description,segment,purpose,path) values (?, ?, ?, ?, ?, ?)";
                
            }
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

package com;
import model.Customer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 977042160v
 */

public class AddCustomerServlet extends HttpServlet {
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try(PrintWriter out = response.getWriter()){
            String NIC = request.getParameter("txtNIC");
            String name = request.getParameter("txtName");
            String phone = request.getParameter("txtPhone");
            String account = request.getParameter("txtAccount");
            String segment = request.getParameter("txtSegment");
            String purpose = request.getParameter("txtPurpose");
            Double amount = Double.parseDouble(request.getParameter("txtAmt"));
            int scheme = Integer.parseInt(request.getParameter("txtScheme"));
            
            Customer c = new Customer();
            c.setNIC(NIC);
            c.setName(name);
            c.setPhone(phone);
            c.setAccount(account);
            c.setSegment(segment);
            c.setPurpose(purpose);
            c.setAmount(amount);
            c.setScheme(scheme);
                        
            int status=DBHandler.AddCustomer(c);
            if(status>0){
                out.print("Record saved successfully!");
                request.getRequestDispatcher("customer.jsp");
            }else{
                out.println("Sorry! unable to save record");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

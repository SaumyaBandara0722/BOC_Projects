package com;

import model.Customer;
import model.Scheme;
import java.util.*;
import java.sql.*;
import model.Purpose;
import model.Segment;
import javax.swing.JOptionPane;

/**
 *
 * @author 977042160v
 */
public class DBHandler {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loan_advisory", "root", "root");
              con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loan_advisory?useSSL=false", "root", "admin");

        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    //Add customer request
    public static int AddCustomer(Customer e) {
        int status = 0;
        try {
            Connection con = DBHandler.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into loan_advisory.cust_details(cid,nic,name,phn_num,accnt_num,seg,purpose,amt,scheme) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");

            ps.setInt(1, 0);
            ps.setString(2, e.getNIC());
            ps.setString(3, e.getName());
            ps.setString(4, e.getPhone());
            ps.setString(5, e.getAccount());
            ps.setString(6, e.getSegment());
            ps.setString(7, e.getPurpose());
            ps.setDouble(8, e.getAmount());
            ps.setInt(9, e.getScheme());
            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    //view available loan schemes
    public static List<Scheme> getAllSchemes() {
        List<Scheme> list = new ArrayList<Scheme>();

        try {
            Connection con = DBHandler.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from loan_advisory.scheme_details");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Scheme e = new Scheme();
                e.setSid(rs.getInt(1));
                e.setSname(rs.getString(2));
                e.setDesc(rs.getString(3));
                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    //Add loan segments
    public static int addSegment(Segment s) {
        int status = 0;
        try {
            Connection con = DBHandler.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into loan_advisory.segment(id,segId,segName) values (?, ?, ?)");

            ps.setInt(1, 0);
            ps.setString(2, s.getSegId());
            ps.setString(3, s.getSegName());            
            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }


    // method to read database to update segments
    public Segment readDetails(String segId) {
        Segment s = new Segment();

        try {
            Connection con = DBHandler.getConnection();

            String query = "select * from segment where segId=?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, segId);
            
            ResultSet rs = ps.executeQuery();

            // iterate through the rows in the result set
            while (rs.next()) {
                s.setSegId(segId);
                s.setSegName(rs.getString("segName"));
            }
            con.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return s;
    }

    //add loan purposes
    public static int addPurpose(Purpose p) {
        int status = 0;
        try {
            Connection con = DBHandler.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into loan_advisory.purpose(id,pid,sname,purpose) values (?, ?, ?, ?)");

            ps.setInt(1, 0);
            ps.setString(2, p.getPid());
            ps.setString(3, p.getSname());
            ps.setString(4, p.getPurpose());
            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }
    
    // method to read database to update purpose
    public Purpose readPurposeDetails(String pid) {
        Purpose p = new Purpose();

        try {
            Connection con = DBHandler.getConnection();

            String query = "select * from purpose where pid=?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, pid);
            
            ResultSet rs = ps.executeQuery();

            // iterate through the rows in the result set
            while (rs.next()) {
                p.setPid(pid);
                p.setSname(rs.getString("sname"));
                p.setPurpose(rs.getString("purpose"));
            }
            con.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return p;
    }
    
    //update purpose details
    public static int updatePurpose(Purpose p) {
        int status = 0;
        try {
            Connection con = DBHandler.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "update purpose set sname=?,purpose=? where pid=?");
            ps.setString(1, p.getSname());
            ps.setString(2, p.getPurpose());
            ps.setString(3, p.getPid());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    //update segment details
    public static int updateSegmentdetails(Segment s){
        int status = 0;
        try{
            Connection con = DBHandler.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "update segment set segName=? where segId=?");
            ps.setString(1, s.getSegName());
            ps.setString(2, s.getSegId());

            status = ps.executeUpdate();

            con.close();
        }catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }
    
    //delete segment
    public static int deleteSegmentDetails(Segment s){
        int status =0;
        try{
            Connection con = DBHandler.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "update segment set status='inactive' where segId=?");
            ps.setString(1, s.getSegId());
            status = ps.executeUpdate();

            con.close();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }
    
    //delete purpose
    public static int deletePurposeDetails(Purpose p){
        int status =0;
        try{
            Connection con = DBHandler.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "update purpose set purpose_status='inactive' where pid=?");
            ps.setString(1, p.getPid());
            status = ps.executeUpdate();

            con.close();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }
 
    
    //view loan schemes according to segment and purpose
    public static List<Scheme> readSchemes(String segment, String purpose){
       List<Scheme> list = new ArrayList<Scheme>();
    
        try{
//            Connection con = DBHandler.getConnection();
//            PreparedStatement ps = (PreparedStatement)con.prepareStatement(
//                    "select * from scheme_details where segment=? and purpose=?");
   
            Connection conn = null; // connection to the database
            
            // connects to the database
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loan_advisory?useSSL=false", "root", "admin");
            
            PreparedStatement ps = (PreparedStatement)conn.prepareStatement(
                      "select * from scheme where segment=? and purpose=?");
            ps.setString(1, segment);
            ps.setString(2, purpose);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Scheme s = new Scheme();
                s.setSid(rs.getInt("id"));
                s.setSname(rs.getString("schemeName") );
//                s.setDesc(rs.getString("description"));
                s.setDesc(rs.getString("desc"));
                s.setSegment("segment");
                s.setPurpose("purpose");
                //s.setFile(rs.getBlob("file"));
                                
                list.add(s);
            }
//            con.close();
              conn.close();
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return list;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 977042160v
 */
public class Segment {
    private int id;
    private String segId, segName ,status;

    public Segment() {
    }

    public Segment(int id, String segId, String segName) {
        this.id = id;
        this.segId = segId;
        this.segName = segName;       
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSegId() {
        return segId;
    }

    public void setSegId(String segId) {
        this.segId = segId;
    }

    public String getSegName() {
        return segName;
    }

    public void setSegName(String segName) {
        this.segName = segName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}

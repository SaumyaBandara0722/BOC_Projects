package model;

import java.sql.Blob;

public class Scheme {
    private int sid;
    private String sname, desc, segment, purpose, path;
    private Blob file;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }  

    public Blob getFile() {
        return file;
    }

    public void setFile(Blob file) {
        this.file = file;
    }
    
}

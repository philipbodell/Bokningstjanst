package com.mycompany.booking.core;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Johan
 */
@Entity
public class Competition extends AbstractEntity {
    private static final long serialVersionUID = 1L;
   
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "FNAME")
    private String fname;
    @Column(name = "LNAME")
    private String lname;
    @Column(name = "PHONENUMBER")
    private String phonenumber;
    @Basic(optional = false)
    @Column(name = "SCORE")
    private String score;

    public Competition() {
    }

    public Competition(String fname,String lname, String phonenum, String email,String score) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phonenumber = phonenum;
        this.score = score;
    }

    public String getEmail() {
        return email;
    }
    
    public String getScore() {
        return score;
    }

     public void setScore(String score) {
        this.score = score;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPnumber(String pnumber) {
        this.phonenumber = pnumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competition)) {
            return false;
        }
        Competition other = (Competition) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.booking.core.Competition[ id=" + id + " ]";
    }
    
}
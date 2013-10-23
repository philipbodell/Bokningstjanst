/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.booking.core;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Philip och Johan
 */
@Entity
public class Customer extends AbstractEntity {
    private static final long serialVersionUID = 1L;
   
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "FNAME")
    private String fname;
    @Column(name = "LNAME")
    private String lname;
    @Column(name = "PNUMBER")
    private String pnumber;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;

    public Customer() {
    }

    public Customer(String fname,String lname,String password, String pnum, String email) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.pnumber = pnum;
    }

    public String getEmail() {
        return email;
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

    public String getPnumber() {
        return pnumber;
    }

    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.booking.core.Customer[ id=" + id + " ]";
    }
    
}

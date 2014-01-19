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
 * @author Johan
 */
@Entity
public class ContactMessages extends AbstractEntity {
    private static final long serialVersionUID = 1L;
   
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "MESSAGE")
    private String message;
    

    public ContactMessages() {
    }

    public ContactMessages(String message,String email) {
        this.message = message;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
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
        if (!(object instanceof ContactMessages)) {
            return false;
        }
        ContactMessages other = (ContactMessages) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.booking.core.ContactMessages[ id=" + id + " ]";
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.ticketsystem;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public class TicketEntity implements Serializable {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected Long id;
   
    protected TicketEntity(){
        
    }
    
    
    public Long getId(){
        return id;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.booking.core;

import javax.persistence.Entity;
import javax.persistence.Column;
/**
 *
 * @author Fredrik
 */
@Entity
public class Code extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    @Column(name = "CODE")
    private String code;
    @Column(name = "PERCENTAGE")
    private int percentage;


    public Code() {
    }
    
    public Code(String code, int percentage){
        this.code=code;
        this.percentage=percentage;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

 
}

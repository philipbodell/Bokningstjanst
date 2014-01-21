/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.booking.core;

import com.mycompany.booking.utils.IDAO;

/**
 *
 * @author Fredrik
 */
public interface ICodeCatalogue extends IDAO<Code, Long>{
    public Object getByCode(String Code);
    public long getIdByCode(String code);
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.booking.core;

import com.mycompany.booking.utils.IDAO;
import java.util.List;

/**
 *
 * @author Johan
 */
public interface IContactMessagesRegistry extends IDAO<ContactMessages, Long>{
    public List<ContactMessages> getEmail(String mail);
    public Object getById(Long id);
    public Object getAll();
}

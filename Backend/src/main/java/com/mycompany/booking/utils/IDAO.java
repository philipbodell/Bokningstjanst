
package com.mycompany.booking.utils;

import java.util.List;

/**
 * Basic contract for containers of Tickets, Customers, etc
 * 
 * T is type of elements in container
 * K is type of id (primary key)
 * 
 * @author hajo
 */
public interface IDAO<T,K> {

    public void add(T t);

    public void remove(K id);

    public T update(T t);

    public T find(K id);

    public List<T> getRange(int first, int nItems);

    public int getCount();
}

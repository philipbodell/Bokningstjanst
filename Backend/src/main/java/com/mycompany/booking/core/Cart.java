package com.mycompany.booking.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Simple shopping cart
 * 
 * @author hajo
 */
public class Cart {

    private final Map<Ticket, Integer> productFreq = new HashMap<Ticket, Integer>();

    public void add(Ticket ticket) {
        int i = 1;
        if( productFreq.containsKey(ticket)) {
            i = productFreq.get(ticket) + 1;     
        }
        productFreq.put(ticket, i);
    }

    public void remove(Ticket ticket) {       
        int i = productFreq.get(ticket);
        if( i > 1){
            productFreq.put(ticket, --i);
        }else{
            productFreq.remove(ticket);
        }
    }
/*
     public List<Ticket> getAsOrderItems() {
        List<Ticket> items = new ArrayList<Ticket>();
        for (Map.Entry<Product, Integer> e : productFreq.entrySet()) {
            items.add(new OrderItem(e.getKey(), e.getValue()));
        }
        productFreq.clear();
        return items;
    }*/
   
    @Override
    public String toString() {
        return "Cart{" + "productFreq=" + productFreq.toString() + '}';
    }
}

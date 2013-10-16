/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.booking;

import com.mycompany.booking.core.DepartureAdder;
import org.junit.Test;

/**
 *
 * @author ed
 */
public class TestDepartureAdder {
    @Test
    public void test(){
        String input = "Train,Göteborg,Stockholm,14,40,2013,10,20,4,30";
        input += ",Train,Göteborg,PhilipsHus,14,40,2013,10,20,10,30";
        new DepartureAdder().persistDepartures(input);
    }
}

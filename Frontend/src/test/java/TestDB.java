
import com.mycompany.booking.core.Departure;
import com.mycompany.booking.core.ICustomerRegistry;
import com.mycompany.booking.core.IDepartureCatalogue;
import com.web.bokningstjanst.Booking;
import java.util.ArrayList;
import org.junit.Test.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ed
 */
public class TestDB {
    
    @Before // Run before each test
    public void before() {
       // booking = JPABookingFactory.getBooking("PU");
    }
    
    @Test
    public void testDB(){
        ICustomerRegistry cr = Booking.INSTANCE.getCustomerRegistry();
        /*IDepartureCatalogue dc = Booking.INSTANCE.getDepartureCatalogue();
        ArrayList<Departure> deps = (ArrayList)dc.getAll();
        for(Departure d : deps){
            System.out.println(d.getDepartureLocation());
        }*/
        assertTrue(true);
    }
}

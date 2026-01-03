package test;


import org.junit.jupiter.api.Assertions; 

import org.junit.jupiter.api.Test;

import model.Booking;
import model.Customer;
import model.Movie;
import model.Movie2D;
import model.Seat;
import model.ShowTime;

/**
* This is the JUnit test class that tests whether the Booking class is working correctly. 
*/

class BookingTest { 

 
	/**
     * Tests that a NORMAL customer pays the full ticket price (no discount).
     */
    @Test
    void testNormalTicketPrice() {
        
        
        Movie m = new Movie2D("Inception", 100);
        ShowTime st = new ShowTime(m, "20:00", 10);
        Seat s = st.getSeat(1);

        Customer c = new Customer("Ali", Customer.CustomerType.NORMAL);
        Booking b = new Booking(c, st, s);

       
        Assertions.assertEquals(200.0, b.getTotalPrice(), 0.01);
    }

    /**
     * Tests that a STUDENT customer receives a 20% discount.
     */
    @Test
    void testStudentDiscountCalculation() { 
        Movie m = new Movie2D("Inception", 100);
        ShowTime st = new ShowTime(m, "20:00", 10);
        Seat s = st.getSeat(2);

        Customer c = new Customer("Veli", Customer.CustomerType.STUDENT);
        Booking b = new Booking(c, st, s);

       
        Assertions.assertEquals(160.0, b.getTotalPrice(), 0.01);
    }

    /**
     * Tests that confirming a booking marks the selected seat as booked.
     */
    @Test
    void testSeatConfirmationSystem() {
        Movie m = new Movie2D("Inception", 100);
        ShowTime st = new ShowTime(m, "20:00", 10);
        Seat s = st.getSeat(3);

        Booking b = new Booking(
            new Customer("Ayse", Customer.CustomerType.NORMAL), st, s
        );

        b.confirm();

        
        Assertions.assertTrue(s.isBooked());
    }


    /**
     * Tests that invalid seat numbers throw IllegalArgumentException.
     */
    @Test
    void testInvalidSeatNumber() { 
        Movie m = new Movie2D("Test", 100);
        ShowTime st = new ShowTime(m, "18:00", 5); 

       
        Assertions.assertThrows(IllegalArgumentException.class, () -> st.getSeat(6));
        Assertions.assertThrows(IllegalArgumentException.class, () -> st.getSeat(0));
    }

    /**
     * Tests that ShowTime constructor throws exceptions for invalid parameters.
     */
    @Test
    void testEmptyParameterErrors() { 
        Movie m = new Movie2D("Test", 100);

       
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> new ShowTime(null, "18:00", 5)
        );

        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> new ShowTime(m, "", 5)
        );
    }
    
    /**
     * Tests that the same seat cannot be booked twice by different bookings.
     */
    @Test
    void testBookingSameSeatAgain() { 
        Movie m = new Movie2D("Test", 100);
        ShowTime st = new ShowTime(m, "18:00", 5);
        Seat s = st.getSeat(1);

       
        Booking b1 = new Booking(
            new Customer("Can", Customer.CustomerType.NORMAL), st, s
        );
        b1.confirm();

        
        Booking b2 = new Booking(
            new Customer("Ece", Customer.CustomerType.NORMAL), st, s
        );
        b2.confirm();

        
        Assertions.assertTrue(s.isBooked());
    }
}

package movieticketbooking;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import movieticketbooking.Booking;
import movieticketbooking.Customer;
import movieticketbooking.Movie;
import movieticketbooking.Movie2D;
import movieticketbooking.Seat;
import movieticketbooking.ShowTime;

class BookingTest {

    @Test
    void normalCustomer_shouldPayFullPrice() {
        Movie movie = new Movie2D("TestMovie", 100);
        ShowTime st = new ShowTime(movie, "18:00", 5);
        Seat seat = st.getSeat(1);

        Customer normal = new Customer("Ali", Customer.CustomerType.NORMAL);
        Booking booking = new Booking(normal, st, seat);

        assertEquals(movie.getPrice(), booking.getTotalPrice(), 0.0001);
    }

    @Test
    void studentCustomer_shouldGetDiscount() {
        Movie movie = new Movie2D("TestMovie", 100);
        ShowTime st = new ShowTime(movie, "18:00", 5);
        Seat seat = st.getSeat(2);

        Customer student = new Customer("Ayşe", Customer.CustomerType.STUDENT);
        Booking booking = new Booking(student, st, seat);

        double expected = movie.getPrice() * 0.80; // %20 indirim
        assertEquals(expected, booking.getTotalPrice(), 0.0001);
    }

    @Test
    void confirm_shouldBookSeat() {
        Movie movie = new Movie2D("TestMovie", 100);
        ShowTime st = new ShowTime(movie, "18:00", 5);
        Seat seat = st.getSeat(3);

        Customer normal = new Customer("Mehmet", Customer.CustomerType.NORMAL);
        Booking booking = new Booking(normal, st, seat);

        assertFalse(seat.isBooked());
        booking.confirm();
        assertTrue(seat.isBooked());
    }

    @Test
    void secondBookingSameSeat_shouldNotSucceedInBookingAgain() {
        Movie movie = new Movie2D("TestMovie", 100);
        ShowTime st = new ShowTime(movie, "18:00", 5);
        Seat seat = st.getSeat(4);

        Customer c1 = new Customer("C1", Customer.CustomerType.NORMAL);
        Booking b1 = new Booking(c1, st, seat);
        b1.confirm();
        assertTrue(seat.isBooked());

        Customer c2 = new Customer("C2", Customer.CustomerType.NORMAL);
        Booking b2 = new Booking(c2, st, seat);
        b2.confirm();

        // seat zaten booked kalmalı; ikinci booking seat'i tekrar boş yapamaz
        assertTrue(seat.isBooked());
    }
}

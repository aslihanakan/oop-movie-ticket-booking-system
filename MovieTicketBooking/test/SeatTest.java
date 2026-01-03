package test;


import org.junit.jupiter.api.Assertions;


import org.junit.jupiter.api.Test;

import model.Seat;

/**
 * JUnit test class for the Seat class.
 * Tests seat booking behavior and initial seat states.
 */

class SeatTest {

   
	/**
     * Tests that a newly created seat is not booked by default.
     */
    @Test
    void testInitialStateIsNotBooked() {  //Koltuk oluşturulduğunda boş olması gerktiği için kontrol eder
        Seat seat = new Seat(1);
        Assertions.assertFalse(seat.isBooked(), "New seat should be not booked");
    }

    
    /**
     * Tests that calling the book() method marks the seat as booked.
     */
    @Test
    void testSeatBooking() { //book() meetodu çağrıldığında koltuk dolu olmalı
        Seat seat = new Seat(2);
        seat.book();
        Assertions.assertTrue(seat.isBooked(), "Seat should be booked after calling book()");
    }

    
    /**
     * Tests that seats created with invalid numbers
     * still start as not booked since no validation exists in Seat constructor.
     */
    @Test
    void testInvalidSeatNumberWithoutValidation() { //Geçersiz koltuk numarasını kontrol eder
        // sadece başlangıç durumunun booked=false olduğu kontrol edilir
        Seat seatZero = new Seat(0);
        Assertions.assertFalse(seatZero.isBooked(), "Seat with number 0 should start as not booked");

        Seat seatNegative = new Seat(-5);
        Assertions.assertFalse(seatNegative.isBooked(), "Seat with negative number should start as not booked");
    }

    
    /**
     * Tests that a seat already booked cannot be reverted to an unbooked state
     * when book() is called again.
     */
    @Test
    void testBookingAlreadyBookedSeat() { //Zaten dolu olan koltuğun tekrar rezerve edilemeyeceğini hata mesajı verir
        Seat seat = new Seat(10);

        // İlk kez rezerve etme
        seat.book();
        Assertions.assertTrue(seat.isBooked(), "Seat should be booked after first booking");

        // İkinci kez book çağrısı 
        seat.book();

        // Bir koltuk doluyken tekrar alınamasın diye tekrar rezervasyon yapılınca sistem boş koltuğa dolu demesin kontrolü
        Assertions.assertTrue(seat.isBooked(), "Even if a second reservation is made, the seat must not be empty.");
    }
}

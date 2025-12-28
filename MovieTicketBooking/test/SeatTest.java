package test;


import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import model.Seat;

class SeatTest {

    //Koltuk oluşturulduğunda boş olması gerktiği için kontrol eder
    @Test
    void testInitialStateIsNotBooked() {
        Seat seat = new Seat(1);
        Assertions.assertFalse(seat.isBooked(), "New seat should be not booked");
    }

    //book() meetodu çağrıldığında koltuk dolu olmalı
    @Test
    void testSeatBooking() {
        Seat seat = new Seat(2);
        seat.book();
        Assertions.assertTrue(seat.isBooked(), "Seat should be booked after calling book()");
    }

    //Geçersiz koltuk numarasını kontrol eder
    @Test
    void testInvalidSeatNumberWithoutValidation() {
        // sadece başlangıç durumunun booked=false olduğu kontrol edilir
        Seat seatZero = new Seat(0);
        Assertions.assertFalse(seatZero.isBooked(), "Seat with number 0 should start as not booked");

        Seat seatNegative = new Seat(-5);
        Assertions.assertFalse(seatNegative.isBooked(), "Seat with negative number should start as not booked");
    }

    //Zaten dolu olan koltuğun tekrar rezerve edilemeyeceğini hata mesajı verir
    @Test
    void testBookingAlreadyBookedSeat() {
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

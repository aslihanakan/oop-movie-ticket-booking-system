package test;


import org.junit.jupiter.api.Assertions;


import org.junit.jupiter.api.Test;

import model.Movie;
import model.Movie2D;
import model.ShowTime;

/**
 * JUnit test class for the ShowTime class.
 * Tests seat creation, constructor parameter validation,
 * and seat boundary conditions.
 */

class ShowTimeTest {

    
	/**
     * Tests whether seats are created with the correct count
     * when a ShowTime object is initialized.
     */
    @Test
    void testSeatsCreatedCorrectly() { //Koltukların doğru sayıda ve doğru numaralarla oluşturulmasını kontrol eder
        Movie movie = new Movie2D("Test", 100);
        ShowTime showTime = new ShowTime(movie, "18:00", 20);

        // Koltuk sayısı doğru mu diye bakar
        Assertions.assertEquals(20, showTime.getSeats().size());
    }


    
    /**
     * Tests that invalid constructor parameters
     * (null movie or empty time) throw IllegalArgumentException.
     */
    @Test
    void testInvalidParameters() { // null veya boş değerler gelmemesi gerektiği için kontrol eder
        Movie movie = new Movie2D("Test", 100);

        // Movie null gelirse hata mesajı vermeli
        try {
            new ShowTime(null, "18:00", 5);
            Assertions.fail("Exception was expected for null movie");
        } catch (IllegalArgumentException e) {
            System.out.println("Error (null movie): " + e.getMessage());
        }

        // Zaman boş gelirse hata vermeli
        try {
            new ShowTime(movie, "   ", 5);
            Assertions.fail("Exception was expected for empty time");
        } catch (IllegalArgumentException e) {
            System.out.println("Error (empty time): " + e.getMessage());
        }
    }

    
    /**
     * Tests seat count validation in the constructor
     * and boundary checks in the getSeat() method.
     */
    @Test
    void testSeatBoundaries() { // Yanlış koltuk sayısı ve getSeat metodu sınırlarını kontrol eder
        Movie movie = new Movie2D("Test", 100);

        // 0 koltuklu seans oluşturulmamalı
        try {
            new ShowTime(movie, "18:00", 0);
            Assertions.fail("Exception was expected for seatCount = 0");
        } catch (IllegalArgumentException e) {
            System.out.println("Error (seatCount=0): " + e.getMessage());
        }

        ShowTime showTime = new ShowTime(movie, "18:00", 10);

        // Geçersiz koltuk numaralarını kontrol eder
        try {
            showTime.getSeat(0);
            Assertions.fail("Exception was expected for seat number 0");
        } catch (IllegalArgumentException e) {
            System.out.println("Error (getSeat(0)): " + e.getMessage());
        }

        try {
            showTime.getSeat(11);
            Assertions.fail("Exception was expected for seat number 11");
        } catch (IllegalArgumentException e) {
            System.out.println("Error (getSeat(11)): " + e.getMessage());
        }
    }
}


package test;


import org.junit.jupiter.api.Assertions;


import org.junit.jupiter.api.Test;

import model.Movie;
import model.Movie2D;
import model.Movie3D;

class MoviePricingTest {

	/**
     * Tests whether the movie title and duration are correctly set
     * when a Movie object is created.
     */
    @Test
    void testMovieInformation() { // Film bilgilerinin doğruluğuna bakar
        Movie m = new Movie2D("Inception", 148);

        Assertions.assertEquals("Inception", m.getMovieTitle());
        Assertions.assertEquals(148, m.getMovieDuration());
    }

   
    /**
     * Tests that the price of a 3D movie is higher than the price of a 2D movie.
     */
    @Test
    void test3DPriceDifference() {  // 3D filmin fiyatının 2D filmlerden daha yüksek oluğunu kontrol eder
        Movie m2d = new Movie2D("Gravity", 100);
        Movie m3d = new Movie3D("Gravity", 100);

        // 3D filmin daha pahalı olması gerekir
        Assertions.assertTrue(m3d.getPrice() > m2d.getPrice());
    }

   
    /**
     * Tests that invalid movie durations (negative or zero)
     * throw IllegalArgumentException.
     */
    @Test
    void testInvalidMovieDuration() {  // Geçersiz film süresi girildiğinde hata verilmesine bakar

        try {
            new Movie2D("Error", -10);
            Assertions.fail("Exception was expected but not thrown");
        } catch (IllegalArgumentException e) {
        	
            // Negatif süre hatasını yazdırır
            System.out.println("Error message (negative duration): " + e.getMessage());
        }

        try {
            new Movie2D("Error", 0);
            Assertions.fail("Exception was expected but not thrown");
        } catch (IllegalArgumentException e) {
        	
            // Sıfır süre hatasını yazdırır
            System.out.println("Error message (zero duration): " + e.getMessage());
        }
    }

    
    /**
     * Tests that creating a movie with an empty title
     * throws IllegalArgumentException.
     */
    @Test
    void testEmptyMovieTitle() { // Boş film ismi girildiğinde hata verilmesini kontrol eder

        try {
            new Movie2D("", 120);
            Assertions.fail("Exception was expected but not thrown");
        } catch (IllegalArgumentException e) {
        	
            // Boş film ismi hatası mesajını yazdırır
            System.out.println("Error message (empty title): " + e.getMessage());
        }

    }
}

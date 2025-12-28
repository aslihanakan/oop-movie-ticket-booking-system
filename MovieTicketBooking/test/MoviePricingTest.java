package test;


import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import model.Movie;
import model.Movie2D;
import model.Movie3D;

class MoviePricingTest {

    // Film bilgilerinin doğruluğuna bakar
    @Test
    void testMovieInformation() {
        Movie m = new Movie2D("Inception", 148);

        Assertions.assertEquals("Inception", m.getMovieTitle());
        Assertions.assertEquals(148, m.getMovieDuration());
    }

    // 3D filmin fiyatının 2D filmlerden daha yüksek oluğunu kontrol eder
    @Test
    void test3DPriceDifference() {
        Movie m2d = new Movie2D("Gravity", 100);
        Movie m3d = new Movie3D("Gravity", 100);

        // 3D filmin daha pahalı olması gerekir
        Assertions.assertTrue(m3d.getPrice() > m2d.getPrice());
    }

    // Geçersiz film süresi girildiğinde hata verilmesine bakar
    @Test
    void testInvalidMovieDuration() {

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

    // Boş film ismi girildiğinde hata verilmesini kontrol eder
    @Test
    void testEmptyMovieTitle() {

        try {
            new Movie2D("", 120);
            Assertions.fail("Exception was expected but not thrown");
        } catch (IllegalArgumentException e) {
        	
            // Boş film ismi hatası mesajını yazdırır
            System.out.println("Error message (empty title): " + e.getMessage());
        }

    }
}

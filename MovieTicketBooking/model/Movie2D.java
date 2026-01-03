package model;

/**
* This class represents the 2D movie genre.
* It is derived from the Movie class and contains price information for 2D movies. 
**/
public class Movie2D extends Movie { //Movie sınıfından üretilmiştir title ve durationu miras alır

	 /**
     * Creates a 2D movie with the given title and duration.
     *
     * @param title title of the movie
     * @param duration duration of the movie in minutes
     */
    public Movie2D(String title, int duration) {
        super(title, duration);//üst sınıfın constructorunu çağırıyoruz
    }
 
    
    /**
     * Returns the ticket price for a 2D movie.
     *
     * @return price of the 2D movie
     */
    @Override
    public double getPrice() { //abstarct classdaki zorunlu methodu override ederek 2D filmlerin ücretini tanımlıyoruz
        return 200.0;
    }
}

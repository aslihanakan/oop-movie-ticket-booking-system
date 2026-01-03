package model;

/**
* This class represents the 2D movie genre.
* It is derived from the Movie class and contains price information for 2D movies. 
**/
public class Movie2D extends Movie {

	 /**
     * Creates a 2D movie with the given title and duration.
     *
     * @param title title of the movie
     * @param duration duration of the movie in minutes
     */
    public Movie2D(String title, int duration) {
        super(title, duration);
    }
 
    
    /**
     * Returns the ticket price for a 2D movie.
     *
     * @return price of the 2D movie
     */
    @Override
    public double getPrice() {
        return 200.0;
    }
}

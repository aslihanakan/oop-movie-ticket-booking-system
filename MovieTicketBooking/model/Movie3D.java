package model;

/**
* This class represents the 3D movie genre.
* It is derived from the Movie class and is used to apply special pricing for 3D movies. 
*/
public class Movie3D extends Movie {

   
    public Movie3D(String title, int duration) {
        super(title, duration);
    }

    
    /**
     * Returns the ticket price for a 2D movie.
     *
     * @return price of the 2D movie
     */
    @Override
    public double getPrice() {//Abstract classdaki metotu override ederek 3D filmlerin ücretini tanımlıyoruz
        return 300.0; 
    }
}

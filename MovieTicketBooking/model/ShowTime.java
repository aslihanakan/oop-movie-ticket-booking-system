package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
* Represents a movie's showtime at a specific time. 
* Keeps track of seats and showtime information.
*/
public class ShowTime {

    private final Movie movie; 
    private final String time; 
    private final List<Seat> seats; 
    
    /**
     * Creates a new showtime for a given movie.
     * Initializes seats from 1 to seatCount.
     *
     * @param movie the movie of this showtime
     * @param time the showtime time (e.g., "18:00")
     * @param seatCount number of seats for this showtime
     * @throws IllegalArgumentException if movie is null, time is empty, or seatCount is not positive
     */
    public ShowTime(Movie movie, String time, int seatCount) { 
    	
    	
        if (movie == null) {
            throw new IllegalArgumentException("movie cannot be null");
        }
        if (time == null || time.trim().isEmpty()) {
            throw new IllegalArgumentException("time cannot be null/empty");
        }
        if (seatCount <= 0) {
            throw new IllegalArgumentException("seatCount must be > 0");
        }

        
        this.movie = movie;
        this.time = time.trim();
        this.seats = new ArrayList<>();

      
        for (int i = 1; i <= seatCount; i++) {
            seats.add(new Seat(i));
        }
    }

    /**
     * Returns the movie of this showtime.
     *
     * @return movie object
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * Returns the time of this showtime.
     *
     * @return showtime time
     */
    public String getTime() {
        return time;
    }

    /**
     * Returns an unmodifiable list of seats.
     * This prevents external modification of the seat list.
     *
     * @return unmodifiable seat list
     */
    public List<Seat> getSeats() {
        return Collections.unmodifiableList(seats); 
    }

    /**
     * Returns the seat object for the given seat number.
     *
     * @param number seat number (starting from 1)
     * @return Seat object for the given number
     * @throws IllegalArgumentException if the seat number is out of range
     */
    public Seat getSeat(int number) { 
        if (number < 1 || number > seats.size()) {
            throw new IllegalArgumentException(
                "Invalid seat number. Please choose between 1 and " + seats.size()
            );
        }
        return seats.get(number - 1); 
    }

    /**
     * Prints the seat map of this showtime.
     * Booked seats are displayed as [XX], available seats are displayed as [01], [02], ...
     */
    public void printSeatMap() { 
        System.out.println("Seat map for " + movie.getMovieTitle() + " at " + time + ":"); 

       
        for (int i = 0; i < seats.size(); i++) {
            Seat s = seats.get(i);

            if (s.isBooked()) {
                System.out.print("[XX] ");
            } else { 
                System.out.printf("[%02d] ", s.getSeatNumber()); 
            }

            if ((i + 1) % 10 == 0) {
                System.out.println(); 
            }
        }
        System.out.println();
    }
    /**
     * Returns a formatted string representation of the showtime.
     *
     * @return showtime information string
     */
    @Override
    public String toString() {
        return movie.getMovieTitle() + " at " + time;
    }
}

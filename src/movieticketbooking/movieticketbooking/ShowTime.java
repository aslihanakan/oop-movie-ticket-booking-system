import java.util.ArrayList;
import java.util.List;

public class ShowTime {

    private Movie movie;        
    private String time;        
    private List<Seat> seats;   

    public ShowTime(Movie movie, String time, int seatCount) {
        this.movie = movie;
        this.time = time;
        this.seats = new ArrayList<>();

        for (int i = 1; i <= seatCount; i++) {
            seats.add(new Seat(i));
        }
    }

    public Movie getMovie() {
        return movie;
    }

    public String getTime() {
        return time;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public Seat getSeat(int number) {
        return seats.get(number - 1);
    }

   
    public void printSeatMap() {
        System.out.println("Seat map for " + movie.getMovieTitle() + " at " + time + ":");

        for (Seat s : seats) {
            if (s.isBooked()) {
                System.out.print("[X] ");  
            } else {
                System.out.print("[" + s.getSeatNumber() + "] ");
            }
        }

        System.out.println();
    }

    @Override
    public String toString() {
        return movie.getMovieTitle() + " at " + time;
    }
}

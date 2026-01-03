package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
* Represents a movie's showtime at a specific time. 
* Keeps track of seats and showtime information.
*/
public class ShowTime { //Seansı temsil eden sınıf

    private final Movie movie; //Seansın hangi filme ait olduğu
    private final String time; //Seans saati
    private final List<Seat> seats; //Bu seansa ait koltuk bilgisi
    
    /**
     * Creates a new showtime for a given movie.
     * Initializes seats from 1 to seatCount.
     *
     * @param movie the movie of this showtime
     * @param time the showtime time (e.g., "18:00")
     * @param seatCount number of seats for this showtime
     * @throws IllegalArgumentException if movie is null, time is empty, or seatCount is not positive
     */
    public ShowTime(Movie movie, String time, int seatCount) { //Yeni seans oluşturur
    	
    	//Seans için gerekli olan bilgiler boş olursa doldurulması için uyarı verir
        if (movie == null) {
            throw new IllegalArgumentException("movie cannot be null");
        }
        if (time == null || time.trim().isEmpty()) {
            throw new IllegalArgumentException("time cannot be null/empty");
        }
        if (seatCount <= 0) {
            throw new IllegalArgumentException("seatCount must be > 0");
        }

        //Doğrulanmış veriler tutulur
        this.movie = movie;
        this.time = time.trim();
        this.seats = new ArrayList<>();

        //Koltukları 1'den başlayarak numaralandırırız
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
        return Collections.unmodifiableList(seats); // Koltuk listesine dışarıdan müdahale olmasın
    }

    /**
     * Returns the seat object for the given seat number.
     *
     * @param number seat number (starting from 1)
     * @return Seat object for the given number
     * @throws IllegalArgumentException if the seat number is out of range
     */
    public Seat getSeat(int number) { //kullanıcı seçimine göre tek koltuk döndürür
        if (number < 1 || number > seats.size()) { //Koltuk numarasının mevcut koltuk sayısına uygunluğunu kontrol eder
            throw new IllegalArgumentException(
                "Invalid seat number. Please choose between 1 and " + seats.size()
            );
        }
        return seats.get(number - 1); //koltukları kullanıcı 1-30 şeklinde görmelidir ama kodda indeksler 0 dan başladığı için 0-29 olur bunu düzeltir
    }

    /**
     * Prints the seat map of this showtime.
     * Booked seats are displayed as [XX], available seats are displayed as [01], [02], ...
     */
    public void printSeatMap() { //Kullanıcıya koltuk düzenini gösterir
        System.out.println("Seat map for " + movie.getMovieTitle() + " at " + time + ":"); // Hangi film ve hangi saat olduğunu gösterir

        //Her koltuk tek tek kontrol edilir
        for (int i = 0; i < seats.size(); i++) {
            Seat s = seats.get(i);

            if (s.isBooked()) {
                System.out.print("[XX] "); //Kullanıcı tekrar seçemesin diye dolu koltuklar işaretlenir
            } else { 
                System.out.printf("[%02d] ", s.getSeatNumber()); //boş koltukları 01,02... şeklinde gösterir
            }

            if ((i + 1) % 10 == 0) {
                System.out.println(); //ekranda daha düzenli gözükmesi için 10 koltukta bir alt satıra geçer
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

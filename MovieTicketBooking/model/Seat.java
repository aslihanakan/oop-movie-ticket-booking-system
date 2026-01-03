package model;
/**
* Represents a single seat in the cinema. 
* Used for seat availability and reservation purposes.
*/

public class Seat implements Bookable {

	
    private int seatNumber;
    private boolean isBooked;

    
    /**
     * Creates a seat with the given seat number.
     * The seat is initially marked as available.
     *
     * @param seatNumber seat number
     */
    public Seat(int seatNumber) { 
        this.seatNumber = seatNumber;
        this.isBooked = false;
    }

    /**
     * Returns the seat number.
     *
     * @return seat number
     */
    public int getSeatNumber() {
        return seatNumber;
    }

    
    /**
     * Checks whether the seat is already booked.
     *
     * @return true if the seat is booked, false otherwise
     */
    public boolean isBooked() { 
        return isBooked;
    }

    
    /**
     * Reserves the seat.
     * If the seat is already booked, a warning message is displayed.
     */
    @Override
    public void book() {
        if (isBooked) {
            System.out.println("Seat " + seatNumber + " is already booked!");
        } else {
            isBooked = true;
            System.out.println("Seat " + seatNumber + " booked successfully.");
        }
    }
 
    
    /**
     * Returns a string representation of the seat and its current status.
     *
     * @return seat information string
     */
    @Override
    public String toString() { 
        return "Seat " + seatNumber + (isBooked ? " (Booked)" : " (Available)");
    }
}

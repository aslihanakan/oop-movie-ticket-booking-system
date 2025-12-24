public class Seat implements Bookable {

    private int seatNumber;
    private boolean isBooked;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.isBooked = false;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

  
    @Override
    public void book() {
        if (!isBooked) {
            isBooked = true;
        } else {
            System.out.println("Seat " + seatNumber + " is already booked!");
        }
    }

    @Override
    public String toString() {
        return "Seat " + seatNumber + (isBooked ? " (Booked)" : " (Available)");
    }
}

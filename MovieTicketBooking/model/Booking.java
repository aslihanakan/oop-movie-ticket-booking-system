package model;

/**
* This is for ticket reservations made by a customer.
* It performs price calculation and reservation confirmation processes.
*/

public class Booking {

    private Customer customer; 
    private ShowTime showTime; 
    private Seat seat; 
    private double totalPrice;
    private boolean confirmed; 

    private static final double STUDENT_DISCOUNT_RATE = 0.20; 

    public Booking(Customer customer, ShowTime showTime, Seat seat) { 
        this.customer = customer;
        this.showTime = showTime;
        this.seat = seat;

        
        this.totalPrice = calculateFinalPrice();
        this.confirmed = false; 
    }

    /**
     * Calculates the final ticket price.
     * Applies student discount if applicable.
     *
     * @return calculated total price
     */
    public double calculateFinalPrice() {
        double basePrice = showTime.getMovie().getPrice();
        
        if (customer.isStudent()) {
            basePrice = basePrice * (1 - STUDENT_DISCOUNT_RATE);
        }

        return basePrice;
    }
    
    /**
     * Confirms the reservation and marks the seat as booked.
     * Prevents duplicate reservations.
     */
    public void confirm() {
        if (confirmed) {
            System.out.println("This booking is already confirmed.");
            return;
        }
        
        if (seat.isBooked()) {
            System.out.println("Error: Seat " + seat.getSeatNumber() + " is already booked!");
            return;
        }
       
        seat.book();
        confirmed = true;
        
       
        customer.addBooking(this);

        System.out.println("Booking confirmed!");
        System.out.println("Customer: " + customer.getCustomerName());
        System.out.println("Type: " + customer.getCustomerType());
        System.out.println("Movie: " + showTime.getMovie().getMovieTitle());
        System.out.println("Showtime: " + showTime.getTime());
        System.out.println("Seat: " + seat.getSeatNumber());
        System.out.println("Price: " + totalPrice + " TL");
    }

    /**
     * Returns the total price of the reservation.
     *
     * @return total ticket price
     */
    public double getTotalPrice() { 
        return totalPrice;
    }
}

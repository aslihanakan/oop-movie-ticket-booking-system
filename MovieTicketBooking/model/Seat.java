package model;
/**
* Represents a single seat in the cinema. 
* Used for seat availability and reservation purposes.
*/

public class Seat implements Bookable {//Bookable interfaceinde tanımlanan özelliği uygular

	//Koltuk numarası ve rezerve edilip edilmediğini tutar
    private int seatNumber;
    private boolean isBooked;

    
    /**
     * Creates a seat with the given seat number.
     * The seat is initially marked as available.
     *
     * @param seatNumber seat number
     */
    public Seat(int seatNumber) { //Yeni koltuk oluşturulduğunda boş olduğunu tanımlar
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
    public boolean isBooked() { //Koltuğun dolu olup olmadığını kontrol etmek için kullanılır
        return isBooked;
    }

    
    /**
     * Reserves the seat.
     * If the seat is already booked, a warning message is displayed.
     */
    @Override
    public void book() { //Bookable interfaceinden gelen zorunlu metot,rezervasyon işlemini temsil eder
        if (isBooked) {
            System.out.println("Seat " + seatNumber + " is already booked!"); //rezerve edilmek istenen koltuk doluysa hata verir
        } else {
            isBooked = true;
            System.out.println("Seat " + seatNumber + " booked successfully.");//dolu değilse işlemi yapar
        }
    }
 
    
    /**
     * Returns a string representation of the seat and its current status.
     *
     * @return seat information string
     */
    @Override
    public String toString() { //Koltuk ekrana yazdırıldığında durumunu yazar
        return "Seat " + seatNumber + (isBooked ? " (Booked)" : " (Available)");
    }
}

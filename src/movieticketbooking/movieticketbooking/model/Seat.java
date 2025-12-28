package movieticketbooking.model;

public class Seat implements Bookable {//Bookable interfaceinde tanımlanan özelliği uygular

	//Koltuk numarası ve rezerve edilip edilmediğini tutar
    private int seatNumber;
    private boolean isBooked;

    //Yeni koltuk oluşturulduğunda boş olduğunu tanımlar
    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.isBooked = false;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    //Koltuğun dolu olup olmadığını kontrol etmek için kullanılır
    public boolean isBooked() {
        return isBooked;
    }

    //Bookable interfaceinden gelen zorunlu metot,rezervasyon işlemini temsil eder
    @Override
    public void book() {
        if (isBooked) {
            System.out.println("Seat " + seatNumber + " is already booked!"); //rezerve edilmek istenen koltuk doluysa hata verir
        } else {
            isBooked = true;
            System.out.println("Seat " + seatNumber + " booked successfully.");//dolu değilse işlemi yapar
        }
    }
 
    //Koltuk ekrana yazdırıldığında durumunu yazar
    @Override
    public String toString() {
        return "Seat " + seatNumber + (isBooked ? " (Booked)" : " (Available)");
    }
}

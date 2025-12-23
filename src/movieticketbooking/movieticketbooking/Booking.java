package movieticketbooking;

public class Booking {

    private Customer customer; //müşteri bilgisini tutmak için
    private ShowTime showTime; //rezervasyon yapılan filmin seansını tutmak için
    private Seat seat; //rezerve edilen koltuğu tutmak için
    private double totalPrice; //fiyatı tutar
    private boolean confirmed; //rezervasyonun olup olmadığını tutar

    private static final double STUDENT_DISCOUNT_RATE = 0.20; // %20  //Öğrenciler için uygulanacak indirim oranını sabitler 

    public Booking(Customer customer, ShowTime showTime, Seat seat) { //rezervasyon oluşturulması için gerekli bilgileri alır
        this.customer = customer;
        this.showTime = showTime;
        this.seat = seat;

        //fiyatı otomatik hesaplar 
        this.totalPrice = calculateFinalPrice();
        this.confirmed = false; //yeni oluşturulan rezervasyonun başta onaylanmadığını belirtir
    }

    public double calculateFinalPrice() {
        double basePrice = showTime.getMovie().getPrice();//filmden gelen standart fiyatı alır
        //kullanıcı öğrenciyse indirimli fiyat olmasını sağlar 
        if (customer.isStudent()) {
            basePrice = basePrice * (1 - STUDENT_DISCOUNT_RATE);
        }

        return basePrice;
    }
    //aynı rezervasyonun ikinci kez yapılmasını engeller 
    public void confirm() {
        if (confirmed) {
            System.out.println("This booking is already confirmed.");
            return;
        }
        //aynı koltuğun tekrar tekrar seçilmesini engeller
        if (seat.isBooked()) {
            System.out.println("Error: Seat " + seat.getSeatNumber() + " is already booked!");
            return;
        }
        //yapılan koltuk seçiminin ve rezervasyonun kaydedilmesini sağlar
        seat.book();
        confirmed = true;
        
        //rezervasyon geçmişini tutar
        customer.addBooking(this);

        System.out.println("Booking confirmed!");
        System.out.println("Customer: " + customer.getCustomerName());
        System.out.println("Type: " + customer.getCustomerType());
        System.out.println("Movie: " + showTime.getMovie().getMovieTitle());
        System.out.println("Showtime: " + showTime.getTime());
        System.out.println("Seat: " + seat.getSeatNumber());
        System.out.println("Price: " + totalPrice + " TL");
    }

    public double getTotalPrice1() { //hesaplanmış fiyatı dışarı verir 
        return totalPrice;
    }
    

    public double getTotalPrice() {
        return totalPrice;
    }
}

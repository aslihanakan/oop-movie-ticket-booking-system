package movieticketbooking.model;
import java.util.ArrayList;
import java.util.List;

public class Customer {

    public enum CustomerType { NORMAL, STUDENT } //Müşterinin sadece bu iki gruptan biri olabileceğini sabitler.
 
    //Müşteri bilgisi (ad-olduğu tip)
    private String customerName;
    private CustomerType customerType;

    //Müşterinin yaptığı rezervasyonları tutar 
    private List<Booking> bookingHistory = new ArrayList<>();//bir müşterinin birden fazla bilet alabilmesini sağlar

    // Yeni bir müşteri oluştururken belirlenen kısımlar
    public Customer(String customerName, CustomerType customerType) {
        this.customerName = customerName;
        this.customerType = customerType;
    }

    public Customer(String customerName) {
        this(customerName, CustomerType.NORMAL);// Eğer müşteri tipi belirlenmezse otomatik olarak Normal alınır
    }
 
    public String getCustomerName() {
        return customerName;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }
    
    //İndirim uygulamalarında sorun olmaması için müşterinin öğrenci olup olmadığını kontrol eder
    public boolean isStudent() {
        return customerType == CustomerType.STUDENT;
    }

    //Müşteri yeni bir bilet aldığında rezervasyon geçmişine ekler
    public void addBooking(Booking b) {
        bookingHistory.add(b);
    }
}

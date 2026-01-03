package model;
import java.util.ArrayList;

import java.util.List;

/**
 * Represents a customer in the movie ticket booking system.
 * Stores customer information, customer type and booking history.
 */

public class Customer {

	 /**
     * Defines possible customer types.
     * A customer can be either NORMAL or STUDENT.
     */
    public enum CustomerType { NORMAL, STUDENT } //Müşterinin sadece bu iki gruptan biri olabileceğini sabitler.
 
    //Müşteri bilgisi (ad-olduğu tip)
    private String customerName;
    private CustomerType customerType;

    //Müşterinin yaptığı rezervasyonları tutar 
    private List<Booking> bookingHistory = new ArrayList<>();//bir müşterinin birden fazla bilet alabilmesini sağlar

    
    /**
     * Creates a new customer with a specified customer type.
     *
     * @param customerName Name of the customer
     * @param customerType Type of the customer (NORMAL or STUDENT)
     */
    public Customer(String customerName, CustomerType customerType) {// Yeni bir müşteri oluştururken belirlenen kısımlar
        this.customerName = customerName;
        this.customerType = customerType;
    }

    /**
     * Creates a new customer with NORMAL type by default.
     *
     * @param customerName Name of the customer
     */
    public Customer(String customerName) {
        this(customerName, CustomerType.NORMAL);// Eğer müşteri tipi belirlenmezse otomatik olarak Normal alınır
    }
 
    /**
     * Returns the name of the customer.
     *
     * @return customer name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Returns the type of the customer.
     *
     * @return customer type
     */
    public CustomerType getCustomerType() {
        return customerType;
    }
    
    
    /**
     * Checks whether the customer is a student.
     * Used for applying discount rules.
     *
     * @return true if customer is STUDENT, false otherwise
     */
    public boolean isStudent() { //İndirim uygulamalarında sorun olmaması için müşterinin öğrenci olup olmadığını kontrol eder
        return customerType == CustomerType.STUDENT;
    }

    
    /**
     * Adds a new booking to the customer's booking history.
     *
     * @param b booking to be added
     */
    public void addBooking(Booking b) { //Müşteri yeni bir bilet aldığında rezervasyon geçmişine ekler
        bookingHistory.add(b);
    }
}

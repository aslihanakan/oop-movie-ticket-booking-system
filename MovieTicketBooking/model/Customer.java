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
    public enum CustomerType { NORMAL, STUDENT } 
 
   
    private String customerName;
    private CustomerType customerType;

   
    private List<Booking> bookingHistory = new ArrayList<>();

    
    /**
     * Creates a new customer with a specified customer type.
     *
     * @param customerName Name of the customer
     * @param customerType Type of the customer (NORMAL or STUDENT)
     */
    public Customer(String customerName, CustomerType customerType) {
        this.customerName = customerName;
        this.customerType = customerType;
    }

    /**
     * Creates a new customer with NORMAL type by default.
     *
     * @param customerName Name of the customer
     */
    public Customer(String customerName) {
        this(customerName, CustomerType.NORMAL);
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
    public boolean isStudent() { 
        return customerType == CustomerType.STUDENT;
    }

    
    /**
     * Adds a new booking to the customer's booking history.
     *
     * @param b booking to be added
     */
    public void addBooking(Booking b) { 
        bookingHistory.add(b);
    }
}

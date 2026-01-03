package app;

import java.util.ArrayList;



import java.util.List;
import java.util.Scanner;


import model.Booking;
import model.Customer;
import model.Movie;
import model.Movie2D;
import model.Movie3D;
import model.Seat;
import model.ShowTime;

/**
 * Entry point of the Movie Ticket Booking System.
 * Collects user input and coordinates the booking workflow.
 */
public class Main {
   
	
	/**
     * Runs the console-based booking flow:
     * movie selection, showtime selection, seat selection, and booking confirmation.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) { 

    	
        Scanner scanner = new Scanner(System.in);

       
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie2D("Inception", 148));
        movies.add(new Movie3D("Avatar 3D", 162));
        movies.add(new Movie2D("Interstellar", 169));
        movies.add(new Movie3D("Gravity 3D",94));
        movies.add(new Movie3D("Doctor Strange 3D",115));
        movies.add(new Movie2D("Hope on the Stage",89));

        System.out.println("=== Movie Ticket Booking System ===");
        System.out.println("\nAvailable Movies:");
        for (int i = 0; i < movies.size(); i++) { 
            System.out.println((i + 1) + ") " + movies.get(i).getMovieTitle());
        }
      
       
        /**
         * Reads an integer input from the user within the given range.
         * Keeps asking until a valid number is entered.
         *
         * @param sc scanner used for input
         * @param prompt message shown to the user
         * @param min minimum allowed value
         * @param max maximum allowed value
         * @return a valid integer within [min, max]
         */
        int movieChoice = readInt(scanner, "\nSelect a movie (1-" + movies.size() + "): ", 1, movies.size());  
        Movie selectedMovie = movies.get(movieChoice - 1);

        
        List<ShowTime> showTimes = List.of(
                new ShowTime(selectedMovie, "18:00", 30),
                new ShowTime(selectedMovie, "19.15",30),
                new ShowTime(selectedMovie, "21:00", 30)
        );

        System.out.println("\nAvailable Showtimes for " + selectedMovie.getMovieTitle() + ":"); 
        
       
        for (int i = 0; i < showTimes.size(); i++) {
            System.out.println((i + 1) + ") " + showTimes.get(i).getTime());
        }

        
        int showChoice = readInt(scanner, "\nSelect a showtime (1-" + showTimes.size() + "): ", 1, showTimes.size());
        ShowTime selectedShow = showTimes.get(showChoice - 1);

       
        while (true) {
            System.out.println("\n----------------------------------------");
            System.out.println("Movie   : " + selectedShow.getMovie().getMovieTitle());
            System.out.println("Showtime: " + selectedShow.getTime());
            System.out.println("----------------------------------------");

            System.out.println("\nSeat Map:");
            selectedShow.printSeatMap();

            int seatChoice = readInt(scanner, "\nSelect a seat (1-30) or 0 to Exit: ", 0, 30);
            
            
            if (seatChoice == 0) {
                System.out.println("\n=== Goodbye! ===");
                break;
            }

            
            Seat selectedSeat = selectedShow.getSeat(seatChoice);
            
           
            if (selectedSeat.isBooked()) {
                System.out.println("This seat is already booked. Please choose another seat.");
                continue;
            }

           
            /**
             * Reads a non-empty line from the user.
             * Keeps asking until the user enters a non-empty value.
             *
             * @param sc scanner used for input
             * @param prompt message shown to the user
             * @return non-empty string
             */
            String name = readNonEmptyLine(scanner, "\nEnter your name: ");  
            Customer.CustomerType type = askCustomerType(scanner);

            Customer customer = new Customer(name, type);


            
            Booking booking = new Booking(customer, selectedShow, selectedSeat);
            System.out.println();
            booking.confirm();

            
            System.out.print("\nDo you want to book another seat? (Y/N): ");
            String again = scanner.nextLine().trim();
            if (!again.equalsIgnoreCase("Y")) {
                System.out.println("\n=== Thank you for using the system! ===");
                break;
            }
        }

        scanner.close();
    }

    /**
     * Reads an integer input from the user within the given range.
     */
    private static int readInt(Scanner sc, String prompt, int min, int max) { 
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                int value = Integer.parseInt(line);
                if (value < min || value > max) {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
 
    /**
     * Reads a non-empty line from the user.
     */
    private static String readNonEmptyLine(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Input cannot be empty.");
        }
    }

    /**
     * Asks the user to select the customer type (NORMAL or STUDENT).
     *
     * @param sc scanner used for input
     * @return selected customer type
     */
    private static Customer.CustomerType askCustomerType(Scanner sc) {
        System.out.println("\nCustomer type:");
        System.out.println("1) NORMAL");
        System.out.println("2) STUDENT (20% discount)");
        int choice = readInt(sc, "Select (1-2): ", 1, 2);
        return (choice == 2) ? Customer.CustomerType.STUDENT : Customer.CustomerType.NORMAL;
    }
}

package movieticketbooking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
   
	//Programın çalışmaya başlayacağı sınıf
    public static void main(String[] args) {

    	//Kullanıcının sistemde seçim yapmasını sağlar 
        Scanner scanner = new Scanner(System.in);

        //Seçilebilecek filmler listesi
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie2D("Inception", 148));
        movies.add(new Movie3D("Avatar 3D", 162));
        movies.add(new Movie2D("Interstellar", 169));
        movies.add(new Movie3D("Gravity 3D",94));
        movies.add(new Movie3D("Doctor Strange 3D",115));
        movies.add(new Movie2D("Hope on the Stage",89));

        System.out.println("=== Movie Ticket Booking System ===");
        System.out.println("\nAvailable Movies:");
        for (int i = 0; i < movies.size(); i++) { //Filmlerin numaralı bir şekilde ekrana yazdırılmasını sağlar 
            System.out.println((i + 1) + ") " + movies.get(i).getMovieTitle());
        }
      
        //Kullanıcıdan seçtiği filmin numarasını alır
        int movieChoice = readInt(scanner, "\nSelect a movie (1-" + movies.size() + "): ", 1, movies.size());
        Movie selectedMovie = movies.get(movieChoice - 1);

        //Seçilen filme ait 3 seans oluşturur
        List<ShowTime> showTimes = List.of(
                new ShowTime(selectedMovie, "18:00", 30),//seans saati ve koltuk sayısı
                new ShowTime(selectedMovie, "19.15",30),
                new ShowTime(selectedMovie, "21:00", 30)
        );

        System.out.println("\nAvailable Showtimes for " + selectedMovie.getMovieTitle() + ":"); //Seansları ekrana yazdırır
        
        //Seans saatlerini numaralı bir şekilde ekrana yazdırır
        for (int i = 0; i < showTimes.size(); i++) {
            System.out.println((i + 1) + ") " + showTimes.get(i).getTime());
        }

        //Kullanıcı seansı seçer 
        int showChoice = readInt(scanner, "\nSelect a showtime (1-" + showTimes.size() + "): ", 1, showTimes.size());
        ShowTime selectedShow = showTimes.get(showChoice - 1);

        //Kullanıcı istediği kadar koltuk alabilsin diye döngü
        while (true) {
            System.out.println("\n----------------------------------------");
            System.out.println("Movie   : " + selectedShow.getMovie().getMovieTitle());
            System.out.println("Showtime: " + selectedShow.getTime());
            System.out.println("----------------------------------------");

            System.out.println("\nSeat Map:");
            selectedShow.printSeatMap();//Boş ve dolu koltukları gösterir

            int seatChoice = readInt(scanner, "\nSelect a seat (1-30) or 0 to Exit: ", 0, 30);//Koltuk seçimi
            
            //O girilirse sistemden çıkılır
            if (seatChoice == 0) {
                System.out.println("\n=== Goodbye! ===");
                break;
            }

            
            Seat selectedSeat = selectedShow.getSeat(seatChoice);//Koltuğun doluluğu kontrol eder
            
            //Koltuk doluysa uyarı verir ve tekrar seçtirmek için başa döner
            if (selectedSeat.isBooked()) {
                System.out.println("❌ This seat is already booked. Please choose another seat.");
                continue;
            }

            //Müşteri bilgilerinii alır
            String name = readNonEmptyLine(scanner, "\nEnter your name: ");
            Customer.CustomerType type = askCustomerType(scanner);

            Customer customer = new Customer(name, type);

            //Rezervasyonla ilgili tüm bilgileri tutar
            Booking booking = new Booking(customer, selectedShow, selectedSeat);
            System.out.println();
            booking.confirm();//Koltuğu rezerve edip müşteri tipine göre ücreti hesapladıktan sonra ekrana yazdırır

            //Tekrar koltuk almak isteyip istemediğimizi sorar ve istemezsek sistemi sonlandırır
            System.out.print("\nDo you want to book another seat? (Y/N): ");
            String again = scanner.nextLine().trim();
            if (!again.equalsIgnoreCase("Y")) {
                System.out.println("\n=== Thank you for using the system! ===");
                break;
            }
        }

        scanner.close();
    }

    private static int readInt(Scanner sc, String prompt, int min, int max) { //Kullanıcıdan sadece geçerli olan sayısal değerleri almak için yardımcı metot
        while (true) {//kullanıcı doğru değeri girene kadar döngü
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                int value = Integer.parseInt(line);//Kullanıcı sayı girmezse hata verir
                if (value < min || value > max) {//Girilen sayı doğru aralıkta mı diye bakıp değilse hata verir
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {//Hatalı giriş olduğunda program çökmesin hata verisn diye var
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static String readNonEmptyLine(Scanner sc, String prompt) {//boş isim boş metin girilmesini engeller
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Input cannot be empty.");
        }
    }

    private static Customer.CustomerType askCustomerType(Scanner sc) {//Müşteri tipi seçtirir
        System.out.println("\nCustomer type:");
        System.out.println("1) NORMAL");
        System.out.println("2) STUDENT (20% discount)");
        int choice = readInt(sc, "Select (1-2): ", 1, 2);
        return (choice == 2) ? Customer.CustomerType.STUDENT : Customer.CustomerType.NORMAL;
    }
}

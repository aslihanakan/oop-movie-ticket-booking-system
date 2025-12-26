package movieticketbooking;
public class Movie3D extends Movie {

   
    public Movie3D(String title, int duration) {
        super(title, duration);
    }

    //Abstract classdaki metotu override ederek 3D filmlerin ücretini tanımlıyoruz
    @Override
    public double getPrice() {
        return 300.0; 
    }
}

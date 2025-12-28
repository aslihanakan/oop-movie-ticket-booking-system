package movieticketbooking.model;

public class Movie2D extends Movie { //Movie sınıfından üretilmiştir title ve durationu miras alır

    public Movie2D(String title, int duration) {
        super(title, duration);//üst sınıfın constructorunu çağırıyoruz
    }
 
    //abstarct classdaki zorunlu methodu override ederek 2D filmlerin ücretini tanımlıyoruz
    @Override
    public double getPrice() {
        return 200.0;
    }
}

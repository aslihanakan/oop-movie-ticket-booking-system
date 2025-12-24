public class Movie2D extends Movie {

    public Movie2D(String title, int duration) {
        super(title, duration);
    }

    @Override
    public double getPrice() {
        return 10.0;
    }
}

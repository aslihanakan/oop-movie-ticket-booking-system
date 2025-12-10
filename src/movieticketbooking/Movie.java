public abstract class Movie {
	 private String MovieTitle;
	 private int MovieDuration; 
	 
	 public Movie(String MovieTitle, int MovieDuration) {
	        this.MovieTitle = MovieTitle;
	        this.MovieDuration = MovieDuration;
	    }

	   
	    public String getMovieTitle() {
	        return MovieTitle;
	    }

	    public int getMovieDuration() {
	        return MovieDuration;
	    }

	   
	    public abstract double getPrice();

	    @Override
	    public String toString() {
	        return MovieTitle + " (" + MovieDuration + " min)";
	    }
	}




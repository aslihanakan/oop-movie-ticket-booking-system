//Her filmin fiyatı farklı hesaplanır ama ortak özellikleri de vardır o yüzden abstract class yaparız
package model;
/**
* This is the basic abstract class for movie classes. 
* Defines movie title, duration, and pricing.
*/
public abstract class Movie {
	 private String MovieTitle;
	 private int MovieDuration; 
	 
	 /**
	 * Creates a movie with the given title and duration.
	 * @param movieTitle title of the movie
	 * @param movieDuration duration of the movie in minutes
	 * @throws IllegalArgumentException if title is empty or duration is not positive
	 */
	 public Movie(String MovieTitle, int MovieDuration) { //Filmin adını ve süresini tutar
		 
		  //Film adının boş olmaması gerektiğini ve film süresinin pozitif girilmesi gerektiğini söyler
		    if (MovieTitle == null || MovieTitle.trim().isEmpty()) {
		        throw new IllegalArgumentException("Movie title cannot be empty");
		    }
		    if (MovieDuration <= 0) {
		        throw new IllegalArgumentException("Movie duration must be positive");
		    }

		  //Alt sınıflar oluşturulurken çağrılırlar (Movie2D , Movie3D)
		    this.MovieTitle = MovieTitle;
		    this.MovieDuration = MovieDuration;
		}


	   /**
	   * Returns the title of the movie.
	   * @return movie title
	   */
	    public String getMovieTitle() {
	        return MovieTitle;
	    }

	    /**
	     * Returns the duration of the movie.
	     *
	     * @return movie duration in minutes
	     */
	    public int getMovieDuration() {
	        return MovieDuration;
	    }

	    
	    /**
	     * Returns the ticket price of the movie.
	     * Must be implemented by subclasses.
	     *
	     * @return movie ticket price
	     */
	    public abstract double getPrice(); //Alt sınıfların zorunlu olarak implement edeceği metot

	    
	    /**
	     * Returns a formatted string representation of the movie.
	     *
	     * @return movie title and duration
	     */
	    @Override
	    public String toString() {
	        return MovieTitle + " (" + MovieDuration + " min)"; //Filmin adının ve süresinin düzgün bir şekilde yazıldığı bir çıktı oluşmasını sağlar
	    }
	}





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
	 public Movie(String MovieTitle, int MovieDuration) { 
		 
		  
		    if (MovieTitle == null || MovieTitle.trim().isEmpty()) {
		        throw new IllegalArgumentException("Movie title cannot be empty");
		    }
		    if (MovieDuration <= 0) {
		        throw new IllegalArgumentException("Movie duration must be positive");
		    }

		  
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
	    public abstract double getPrice(); 
	    
	    /**
	     * Returns a formatted string representation of the movie.
	     *
	     * @return movie title and duration
	     */
	    @Override
	    public String toString() {
	        return MovieTitle + " (" + MovieDuration + " min)"; 
	    }
	}





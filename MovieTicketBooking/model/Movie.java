//Her filmin fiyatı farklı hesaplanır ama ortak özellikleri de vardır o yüzden abstract class yaparız
package model;

public abstract class Movie {
	 private String MovieTitle;
	 private int MovieDuration; 
	 
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


	   
	    public String getMovieTitle() {
	        return MovieTitle;
	    }

	    public int getMovieDuration() {
	        return MovieDuration;
	    }

	    //Alt sınıfların zorunlu olarak implement edeceği metot
	    public abstract double getPrice();

	    //Filmin adının ve süresinin düzgün bir şekilde yazıldığı bir çıktı oluşmasını sağlar
	    @Override
	    public String toString() {
	        return MovieTitle + " (" + MovieDuration + " min)";
	    }
	}





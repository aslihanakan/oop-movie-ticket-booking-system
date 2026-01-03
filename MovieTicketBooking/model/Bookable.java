package model;

/**
* Defines common behavior for reservable objects. 
* Classes using this interface must implement the book() method.
*/

public interface Bookable {
	//nesnenin rezerve edilebilmesi gerektiğini belirtiriz.
	void book();
	

}

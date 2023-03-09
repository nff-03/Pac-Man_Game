/*This class initialize a Pel object with a colour and location
 * Student Name: Nour Fayadh
 * Student Id: 251205677 */

public class Pel {
	
	private Location p;  // a variable that represents the location
	private int color;  // a variable that represent the color
	
	// a constructor that initializes the variables color and location to the given values
	public Pel(Location p, int color) {
		
		this.p = p;
		this.color = color;
	}
	
	// a method to return the variable location
	public Location getLocus() {
		
		return p;
	}
	
	// a method to return the variable color
	public int getColor() {
		
		return color;
	}

}

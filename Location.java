/*This class initialize a location object with an x and y corrdinates  */


public class Location {
	
	private int x;  // a variable to position x
	private int y;  // a variable to position y
	
	// constructor method that initializes the variables x and y with the given values
	public Location(int x, int y) {
		
		this.x = x;
		this.y = y;
	}
	
	// a method to return the variable x
	public int getx() {
		
		return x;
	}
	
	// a method to return the variable y
	public int gety() {
		
		return y;
	}
	
	// a method to compare the objects of class Location
	public int compareTo (Location p) {
		
		// if y is bigger or y is equal and x is bigger return one
		if(this.gety() > p.gety() || (this.gety() == p.gety() && this.getx() > p.getx())){
			
			return 1;
		}
		
		// if y and x are equal return zero
		else if(this.getx() == p.getx() && this.gety() == p.gety()) {
			
			return 0;
		}
		
		// if y is less or y is equal and x is less return negative one
		else {
			
			return -1;
		}
	}

}

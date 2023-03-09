/*This class initialize a MyObject with an id, width, type, pos, and tree */

public class MyObject implements MyObjectADT {
	
	int id;  // a variable that represents the id
	int width;  // a variable that represents the width
	int height; // a variable that represents the height
	String type;  // a variable that represents the type
	Location pos;  // a variable that represents the pos
	BinarySearchTree tree; // a variable that represents the tree
	
	/* a constructor that initializes the variables id, width, height, type and pos to the given values, and creates a new 
	binary search tree*/
	public MyObject(int id, int width, int height, String type, Location pos) {
		
		this.id = id;
		this.width = width;
		this.height = height;
		this.type = type;
		this.pos = pos;
		
		tree = new BinarySearchTree();
	}

	// a method to get the variable width
	public int getWidth() {
		return width;
	}

	// a method to get the variable height
	public int getHeight() {
		return height;
	}

	// a method to get the variable type
	public String getType() {
		return type;
	}

	// a method to get the variable id
	public int getId() {
		return id;
	}

	// a method to get the variable pos
	public Location getLocus() {
		return pos;
	}

	// a method to set the variable pos
	public void setLocus(Location value) {
		pos = value;
		
	}

	// a method to set the variable type
	public void setType(String type) {
		this.type = type;
		
	}


	// a method to add the given Pel object into the tree
	public void addPel(Pel pix) throws DuplicatedKeyException {
	
		try{tree.put(tree.getRoot(), pix);}  // try putting the Pel object in the tree
		catch (DuplicatedKeyException e){System.out.print("Key already exists!");}  // catch exception
	
	}

	// a method that checks if the two my objects intersect
	public boolean intersects(MyObject otherObject) {
		
		// get the x and y positions of my object
		int myObjectX = pos.getx();
		int myObjectY = pos.gety();
		
		// get the x and y positions of other object
		int otherObjectX = otherObject.getLocus().getx();
		int otherObjectY = otherObject.getLocus().gety();
		
		Pel smallPel = null;  // a smallPel object to be used later
		
		// int x and y to use when creating the location to be tested
		int x;
		int y;
		
		try {
			smallPel = otherObject.tree.smallest(tree.getRoot()); // try getting the smallest Pel in the otherObject tree
		} catch(EmptyTreeException e) {  // catch exception 
			e.printStackTrace();
		}
		
		// while the successor of the smallPel in this tree is not null
		while(tree.successor(tree.getRoot(), smallPel.getLocus()) != null) {
			
			// calculate the corrdinates of the object
			x = smallPel.getLocus().getx() + myObjectX - otherObjectX;
			y = smallPel.getLocus().gety() + myObjectY - otherObjectY;
			
			Location newLocus = new Location(x, y);  // create a new location object with the calculated corrdinates
			
			// if otherObject's tree has the calculated location
			if(otherObject.findPel(newLocus)) {
				return true;  // return true
			}
			
			smallPel = tree.successor(tree.getRoot(), smallPel.getLocus());  // set smallPel equal to the its successor
		}
		return false;  // else return false

	}
	
	// a helper method that checks if MyObject has a Pel object in the given location
	private boolean findPel(Location p) {
		
		if(tree.get(tree.getRoot(), p) != null) {
			
			return true;
		}
		
		else {
			return false;
		}
	}

}

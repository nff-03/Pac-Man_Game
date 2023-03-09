/*This class initialize a BNode with a value, left and right child, and parent
 * Student Name: Nour Fayadh
 * Student Id: 251205677 */

public class BNode {
	
	private Pel value;  // a variable that represent the value
	private BNode left;  // a variable that represent the left child
	private BNode right;  // a variable that represent the right child
	private BNode parent;  // a variable that represent the parent
	
	// a constructor that initializes the variables value, left, right, and parent to the given values
	public BNode (Pel value, BNode left, BNode right, BNode parent) {
		
		this.value = value;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
	
	// a constructor that initializes the variables value, left, right, and parent to null
	public BNode () {
		
		this.value = null;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
	
	// a method that returns the parent variable
	public BNode parent() {
		
		return parent;
	}
	
	// a method that sets the parent variable to the given value
	public void setParent(BNode newParent) {
		
		this.parent = newParent;
	}
	
	// a method that sets the left child variable to the given value
	public void setLeftChild (BNode p) {
		
		this.left = p;
	}
	
	// a method that sets the right child variable to the given value
	public void setRightChild (BNode p) {
		
		this.right = p;
	}
	
	// a method that sets the value variable to the given value
	public void setContent (Pel value) {
		
		this.value = value;
	}
	
	// a method to check if the node is a leaf
	public boolean isLeaf() {
		
		// if both children are null return true
		if(left == null && right == null) {
			
			return true;
		}
		
		// else return false
		else {
			
			return false;
		}
	}
	 
	// a method that returns the value variable
	public Pel getData () {
		
		return value;
	}
	
	// a method that returns the left child variable
	public BNode leftChild() {
		
		return left;
	}
	
	// a method that returns the right child variable
	public BNode rightChild() {
		
		return right;
	}

}

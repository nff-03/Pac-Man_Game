/*This class initialize a BinarySearchTree with a root of the tree
 * Student Name: Nour Fayadh
 * Student Id: 251205677 */

public class BinarySearchTree implements BinarySearchTreeADT {
	
	private BNode root; // a variable that represents the root
	
	// a constructor method that creates an empty node and store it in the root
	public BinarySearchTree() {
		
		root = new BNode(); 
	}
	
	// a method to get the Pel storing the given Location
	public Pel get(BNode r, Location key) {
		
		// if r is a lead
		if(r.isLeaf()) {
			
			return null;  // then return null
		}
		
		else {
			
			// if the location equal the given location
			if(r.getData().getLocus().compareTo(key) == 0) {
				
				return r.getData();  // return the pel object stored in that node
			}
			
			// if the location is less than the given location 
			else if(key.compareTo(r.getData().getLocus()) == -1) {
				
				return get(r.leftChild(), key); // look for the Pel object in the left subtree
			}
			
			// if the location is bigger than the given location 
			else {
				return get(r.rightChild(), key); // a method to get the Pel storing the given Location
			}
		}
	}
	
	// a helper method to get the node storing the given Location
	private BNode getNode(BNode r, Location k) {
		
		// if r is a leaf
		if(r.isLeaf()) {
			
			return r;  // return that node
		}
		
		else {
			
			// if the location equal the given location
			if(r.getData().getLocus().compareTo(k) == 0) {
				
				return r;  // return the node
			}
			
			// if the location is less than the given location 
			else if(k.compareTo(r.getData().getLocus()) == -1) {
				
				return getNode(r.leftChild(), k); // look for the node object in the left subtree
			}
			
			// if the location is bigger than the given location 
			else {
				return getNode(r.rightChild(), k); // look for the node object in the right subtree
				}
		}
	}
	
	// a method to put a node in the tree
	public void put(BNode r, Pel newData) throws DuplicatedKeyException {
		
		BNode p = getNode(r, newData.getLocus());  // get the node where the key is stored
		
		// if the node is not a leaf
		if(!p.isLeaf()) {
			
			throw new DuplicatedKeyException("Key already exists!");  // throw an error
		}
		
		else {
			
			p.setContent(newData);  // set the content of this node to the given key
			
			BNode newLeft = new BNode();  // create a new empty left node
			BNode newRight = new BNode();  // create a new empty right node
			
			p.setLeftChild(newLeft);  // set the left node of p to the new left node
			p.setRightChild(newRight);  // set the right node of p to the new right node
			
			newLeft.setParent(p);  // set the parent of the left child to p
			newRight.setParent(p);  // set the parent of the right child to p
		}
	}
	
	// a helper method that finds the smallest node in the tree
	private BNode smallestNode(BNode r) {
		
		// if r is a leaf
		if(r.isLeaf()) {return null;}  // return null
		
		else {
			
			BNode p = r;  // create a new node and set to the given root
			
			// while the node is not a leaf
			while (!p.isLeaf()) {
				
				p = p.leftChild();  // set p equal to its left child
			}
			
			return p.parent();  // return the parent of p
		}
	}
	
	// a method to remove a node from the tree
	public void remove (BNode r, Location key) throws InexistentKeyException{
		
		BNode p = getNode(r, key);  // get the node where the key is stored
		
		// if p is a leaf
		if(p.isLeaf()) {
			
			throw new InexistentKeyException("Key does not exist!");  // throw an exception
		}
		
		else {
			
			// if one of the two children is a leaf
			if(p.leftChild().isLeaf() || p.rightChild().isLeaf()) {
				
				BNode child = null;  // create a variable to store the child
				
				// if the left child is a leaf
				if(p.leftChild().isLeaf()) {
					
					child = p.rightChild();  // set the child equal to the right child
				}
				
				// if the right child is a leaf
				else if(p.rightChild().isLeaf()) {
					
					child = p.leftChild();  // set the child equal to the left child
				}
				
				BNode pParent = p.parent();  // create a parent variable and set it equal to p's parent
				
				// if the parent is not null
				if(pParent != null) {
					
					// if the parent is less than p
					if(pParent.getData().getLocus().compareTo(p.getData().getLocus()) == -1) {
						
						pParent.setRightChild(child); // set the right child of the parent to child
					}
					
					// if the parent is bigger than p
					else if(pParent.getData().getLocus().compareTo(p.getData().getLocus()) == 1) {
						
						pParent.setLeftChild(child);  // set the left child of the parent to child
					}
				}
				
				// if the parent is null
				else {root = child;  // set the child to the root
				child.setParent(null);} // set the child's parent to null
			}
			
			// if none of the two children is a leaf
			else {
				
				BNode s = smallestNode(p.rightChild()); // find the smallest node in the right child and store it in a variable
				p.setContent(s.getData());  // store the value in node s into node p
				remove(s, s.getData().getLocus());  // remove the node s
			}
		}
	}
	
	// a method that returns the successor of the given key
	public Pel successor(BNode r, Location key) {
		
		// if r is a leaf
		if(r.isLeaf()) {
			
			return null;  // return null
		}
		
		else {
			
			BNode p = getNode(r,key); // get the node where the key is stored
			
			// if p is not a leaf and the right child is not a leaf
			if(!p.isLeaf() && !p.rightChild().isLeaf()) {
				
				try{return smallest(p.rightChild());}  // try returning the smallest node in the right subtree
				catch (EmptyTreeException e){return null;}  // catch an error
			}
			
			else {
				
				p = p.parent();  // set the p to its parent
				
				// while p is not null and p's key is less than the give key
				while(p != null && (p.getData().getLocus().compareTo(key) == -1)) {
					
					p = p.parent();  // set the p to its parent
				}
				
				// if p is null
				if(p == null) {return null;}  // return null
				
				// else
				else {return p.getData();}  // return the data stored in p
			}
		}
	}

	// a method that returns the predecessor of the given key
	public Pel predecessor(BNode r, Location key) {
		
		// if r is a leaf
		if(r.isLeaf()) {
			
			return null;  // return null
		}
		
		else {
			
			BNode p = getNode(r,key);  // get the node where the key is stored
			
			// if p is not a leaf and the left child is not a leaf
			if(!p.isLeaf() && !p.leftChild().isLeaf()) {
				
				try{return largest(p.leftChild());}  // try returning the largest node in the right subtree
				catch (EmptyTreeException e){return null;} // catch an error
			}
			
			else {
				
				p = p.parent(); // set the p to its parent
				
				// while p is not null and p's key is bigger than the give key
				while(p != null && (p.getData().getLocus().compareTo(key) == 1)) {
					
					p = p.parent();  // set the p to its parent
				}
				
				// if p is null
				if(p == null) {return null;} // return null
				
				// else
				else {return p.getData();} // return the data stored in p
			}
		}
	}
	
	// a method to return the smallest Pel
	public Pel smallest(BNode r) throws EmptyTreeException{
		
		// if r is a leaf
		if(r.isLeaf()) {
			
			throw new EmptyTreeException("The tree is empty!");  // throw an exception
		}
		
		else {
			
			BNode p = r; // create a new node and set to the given root
			
			// while p is not a leaf
			while(!p.isLeaf()) {
				
				p = p.leftChild();  // set p to its left child
			}
			
			return p.parent().getData();  // return the pel object in the parent of the p
		}
	}
	
	// a method to return the largest Pel
	public Pel largest(BNode r) throws EmptyTreeException{
		
		// if r is a leaf
		if(r.isLeaf()) {
			
			throw new EmptyTreeException("The tree is empty!"); // throw an exception
		}
		
		else {
			
			BNode p = r;  // create a new node and set to the given root
			
			// while p is not a leaf
			while(!p.isLeaf()) {
				
				p = p.rightChild();  // set p to its right child
			}
			
			return p.parent().getData();  // return the pel object in the parent of the p
		}
	}
	
	// a method to return root
	public BNode getRoot() {
		
		return root;
	}

}

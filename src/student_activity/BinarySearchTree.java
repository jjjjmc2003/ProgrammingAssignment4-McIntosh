package student_activity;


/*
 * TODO 1: Implement the STUB methods (add, findLast, addChild, remove,  splice)
 * You may take help/code from your textbook.
 * 
 */


public class BinarySearchTree<T extends Comparable>{

		BSTNode root;
		int n;
		
		public BinarySearchTree() {
			n = 0;
			root = null;
		}
		
		int depth(BSTNode u) {
	        int d = 0;
	        while (u != root) {
	            u = u.parent;
	            d++;
	        }
	        return d;
	    }
		
		int depth(T data) {
	       
	        BSTNode x = this.search(data);
	        
	        if (x != null) {
	        	return depth(x);
	        }
	        else
	        	return -1;
	    }
		
		int size(BSTNode u) {
	        if (u == null) return 0;
	        return 1 + size(u.left) + size(u.right);
	    }
		
		int height(BSTNode u) {
	        if (u == null) return -1;
	        return 1 + Math.max(height(u.left), height(u.right));
	    }
		
		
		int height(T data) {
			
			BSTNode x = this.search(data);
	        return this.height(x);
	        
	    }
		
		/**
		 * performs in-order traversal 
		 * from the root node
		 */
		public void traverse() {
			traverse(root);
		}
		
		/**
		 * performs in-order traversal from node u
		 * @param u
		 */
		private void traverse(BSTNode u) {
	        if (u == null) return;
	        traverse(u.left);
	        System.out.println(u.data);
	        traverse(u.right);
	    }
		
		  public BSTNode search(T x) {
			
			BSTNode u = root;
			while(u != null) {
				if(u.data.compareTo(x) == 0) return u;
				else if (u.data.compareTo(x)>0) u = u.left;
				else u = u.right;
			}  
			return null;
			    
		  }
		  
		  /**
		   * This method intends to insert 
		   * a new node to the current BST
		   * @param x: the data for a new node
		   * @return true if insertion is successful
		   */
		  public boolean add(T x) {
			    //stub
				//needs implementation
			  BSTNode parent = findLast(x);
			  if (parent == null || parent.data.compareTo(x) != 0) {
				  BSTNode newNode = new BSTNode(x);
				  if (parent == null) {
					  root = newNode; // Set root if tree is empty
				  } else {
					  addChild(parent, newNode);
				  }
				  n++;
				  return true;
			  }
			  return false;
		  }
			 /**
			  * This method finds the potential parent node so we can 
			  * insert a new node to it with data property = x
			  * @param x: the data for a new node
			  * @return the potential parent node for inserting a 
			  *         new node with data = x
			  */
			 
			BSTNode findLast(T x) {
				// stub
				//needs implementation
				BSTNode u = root;
				BSTNode parent = null;
				while (u != null) {
					parent = u;
					if (x.compareTo(u.data) < 0) {
						u = u.left;
					} else if (x.compareTo(u.data) > 0) {
						u = u.right;
					} else {
						return u; // Node with x already exists
					}
				}
				return parent;
			}
			/**
			 * Adds u as a child of node p
			 * @param p
			 * @param u
			 * @return true if insertion is successfull
			 */
			boolean addChild(BSTNode p, BSTNode u) {
				// stub
				//needs implementation
				if (p == null || u == null) return false;
				if (u.data.compareTo(p.data) < 0) {
					p.left = u;
				} else {
					p.right = u;
				}
				u.parent = p;
				return true;
			  }
			

		  /**
		   * This method removes an existing node u 
		   * from the tree, given u is either a leaf node or a node 
		   * with single child 
		   * @param u: a BSTNode
		   */
		 void splice(BSTNode u) {
			// stub
			//needs implementation
			 if (u == null) return;
			 BSTNode child = (u.left != null) ? u.left : u.right;
			 if (u == root) {
				 root = child;
				 if (child != null) child.parent = null;
			 } else {
				 BSTNode parent = u.parent;
				 if (parent.left == u) {
					 parent.left = child;
				 } else {
					 parent.right = child;
				 }
				 if (child != null) child.parent = parent;
			 }
		  }
		  /**
		   * This method removes an existing node u 
		   * from the tree
		   * @param u: a BSTNode
		   */
		  void remove(BSTNode u) {
			// stub
				//needs implementation
			  if (u == null) return;
			  if (u.left == null || u.right == null) {
				  splice(u);
			  } else {
				  BSTNode successor = u.right;
				  while (successor.left != null) {
					  successor = successor.left;
				  }
				  u.data = successor.data;
				  splice(successor);
			  }
		  }
		  /**
		   * This method removes an existing node 
		   * that holds the data
		   * @param data: a generic variable
		   */
		  public void remove(T data) {
			  
			  BSTNode u = this.search(data);
			  if(u != null) 
				  this.remove(u);
		  }




}



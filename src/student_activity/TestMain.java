package student_activity;


public class TestMain<T extends Comparable>{
	
		public void testSearch(BinarySearchTree<T> aTree, T x) {
			 
			  BSTNode node = aTree.search(x);
			  if(node!= null) {
				  System.out.println(x + ": Search successfull.");
				  if(node.parent != null)
					  System.out.println("\tparent node:" + node.parent.data);
				  else
					  System.out.println("\troot node");
			  }
			  else
				  System.out.println(x+ ": Search unsuccessfull :(");
		}
		
		public static void main(String[] args) {
			  
			  Integer[] x = {5, 6, 10, 16, 2, 20};
			  BinarySearchTree<Integer> bt = new BinarySearchTree<Integer>(); 
			 

			 for(int i = 0; i < x.length; i++)
				bt.add(x[i]);
			  
			  System.out.println("Performing an inorder traversal: ");
			  bt.traverse();
			  
			  bt.remove(10);
			  
			  System.out.println("Performing an inorder traversal after removing 10: ");
			  bt.traverse();
			  
			  TestMain Z = new TestMain();
			  Z.testSearch(bt, 16);
			  Z.testSearch(bt, 1);
			  Z.testSearch(bt, 100);
			  Z.testSearch(bt, 5);
			  
			  System.out.println("The depth of the root node " + bt.root.data + " is: " + bt.depth(bt.root) );
			  
			  System.out.println("The depth of the node 16 is: " + bt.depth(16) );
				 
			  System.out.println("The depth of the node 25 is: " + bt.depth(25) );
			  
		      /*
		       * TODO 2: Create a new BST with a different data type.
		       * Insert at least 10 nodes to the tree.
		       * Print the tree
		       * Print the height of the tree
		       * Remove/Delete a node 
		       * Delete the root node
		       * Print the tree
		       * Print the height of the tree  
		       */
			// String-based BinarySearchTree
			String[] names = {"Emma", "Liam", "Olivia", "Noah", "Ava", "Mason", "Sophia", "Logan", "Isabella", "Ethan"};
			BinarySearchTree<String> nameTree = new BinarySearchTree<>();

			// Inserting the nodes
			for (String name : names) {
				nameTree.add(name);
			}

			// Traversal
			System.out.println("Printing the tree:");
			nameTree.traverse();

			System.out.println("Height of the tree: " + nameTree.height(nameTree.root));

			// Removing a node (not the root)
			nameTree.remove("Sophia");
			System.out.println("Tree after removing 'Sophia':");
			nameTree.traverse();

			// Removing the root node
			nameTree.remove("Emma");
			System.out.println("Tree after removing the root 'Emma':");
			nameTree.traverse();

			// Printing the height of the tree after deletions
			System.out.println("Height of the tree after deletions: " + nameTree.height(nameTree.root));
		}
}




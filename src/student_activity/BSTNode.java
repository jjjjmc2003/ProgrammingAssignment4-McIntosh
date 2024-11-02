package student_activity;


public class BSTNode<T extends Comparable>{
	T data;
	BSTNode parent;
	BSTNode left;
	BSTNode right;
	
	BSTNode(T x){
		this.data = x;
		parent = left = right = null;
	}
	
	
	
}

package com.practice.java.tree;

public class CheckSequenceExists {

	public static void main(String[] args) {
	    Node root = new Node(2);
	    root.left = new Node(7);
	    root.right = new Node(9);
	    root.right.right = new Node(3);
	    root.left.left = new Node(6);
	    root.left.right = new Node(6);
	    root.left.right.left = new Node(1);
	    root.left.right.left.left = new Node(4);
	    root.left.right.right = new Node(1);
	    
	    
	    int[] seq   = { 2, 7, 6, 1 };
	    
	    System.out.println(checkIfSequenceMatchedFromRootToLeaf(root, seq, 0));
	}

	private static boolean checkIfSequenceMatchedFromRootToLeaf(Node node, int[] seq, int index) {
		if(node == null) {
			return false;
		}
		if(index >= seq.length || node.key != seq[index]) {
			return false;
		}
		if(node.left == null && node.right == null && index == seq.length -1) {
			return true;
		}
		
		return checkIfSequenceMatchedFromRootToLeaf(node.left, seq, index + 1) 
				|| checkIfSequenceMatchedFromRootToLeaf(node.right, seq, index + 1);
	}

}

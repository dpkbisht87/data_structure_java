package com.practice.java.tree;

public class GetSibling {

	public static void main(String[] args) {
		Node root = new Node(2);
		root.left = new Node(7);
		root.right = new Node(9);
		root.left.left = new Node(2);
		root.left.right = new Node(6);
		root.left.right.left = new Node(5);
		root.left.right.right = new Node(11);
		
	     
	    Node sibling = getSibling(root, 11);
	    if( sibling != null) {
	    	System.out.println(sibling.key);
	    }else {
	    	System.out.println("Sibling is null");
	    }
	}

	private static Node getSibling(Node node, int val) {
		if(node == null || node.key == val) {
			return null;
		}
		if(node.left !=null && node.left.key == val) {
			return node.right;
		}
		if( node.right != null && node.right.key == val) {
			return node.left;
		}
		
		Node l = getSibling(node.left, val);
		if( l != null) {
			return l;
		}
		l = getSibling(node.right, val);
		
		return l;
	}

}

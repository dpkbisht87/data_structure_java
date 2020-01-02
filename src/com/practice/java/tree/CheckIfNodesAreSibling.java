package com.practice.java.tree;

public class CheckIfNodesAreSibling {

	public static void main(String[] args) {
		Node root = new Node(2);
		root.left = new Node(7);
		root.right = new Node(9);
		root.left.left = new Node(10);
		root.left.right = new Node(6);
		root.left.right.left = new Node(5);
		root.left.right.right = new Node(11);
		
		int val1 = 11;
		int val2 = 5;
		
		boolean isSibling = checkIfSibling(root, val1, val2);
		System.out.println(isSibling);
	}

	private static boolean checkIfSibling(Node node, int val1, int val2) {
		if(node == null) {
			return false;
		}
		return (node.left.key == val1 && node.right.key == val2) || 
					(node.left.key == val2 && node.right.key == val1) || 
					checkIfSibling(node.left, val1, val2) || 
					checkIfSibling(node.right, val1, val2);
	}
}

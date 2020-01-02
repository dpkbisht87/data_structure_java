package com.practice.java.tree;

public class DeleteBinaryTree {

	public static void main(String[] args) {
		Node root = null;
		root = new Node(15);
	    root.left = new Node(10);
	    root.right = new Node(20);
	    root.left.left = new Node(8);
	    root.left.right = new Node(12);
	    root.right.left = new Node(16);
	    root.right.right = new Node(25);
		
		deleteBinaryTree(root);
	}

	private static void deleteBinaryTree(Node node) {
		if (node == null) {
			return;
		}
		deleteBinaryTree(node.left);
		deleteBinaryTree(node.right);
		node = null;
	}

}

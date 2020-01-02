package com.practice.java.tree;

public class CalculateHeight {

	public static int height(Node node) {
		if(node == null) {
			return 0;
		}
		return 1 + Math.max(height(node.left), height(node.right));
	}
	public static void main(String[] args) {
		Node root = null;
		root = new Node(15);
		root.left = new Node(10);
		root.right = new Node(20);
		root.left.left = new Node(8);
		root.left.right = new Node(12);
		root.right.left = new Node(16);
		root.right.right = new Node(25);
		
		System.out.print("The height of the binary tree is " + height(root));
	}

}

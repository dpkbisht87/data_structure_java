package com.practice.java.tree;

public class DeepestLeftLeafNode {

    int currentLevel = 1;
	Node deepestLeafNode;
	
	public void findDeepestLeftLeafNode(Node node, int level, boolean isLeft) {
		if(node == null) {
			return;
		}
		
		if((node.left == null && node.right == null) && isLeft && level > currentLevel) {
			deepestLeafNode = node;
			currentLevel = level;
		}
		
		findDeepestLeftLeafNode(node.left, level + 1, true);
		findDeepestLeftLeafNode(node.right, level + 1 , false);
	}
	
	public static void main(String[] args) {
		Node root = new Node(2);
		root.left = new Node(7);
		root.right = new Node(9);
		root.left.left = new Node(2);
		root.left.right = new Node(6);
		root.left.right.left = new Node(5);
		root.left.right.right = new Node(11);
		
		DeepestLeftLeafNode leafNode = new DeepestLeftLeafNode();
		leafNode.findDeepestLeftLeafNode(root, 1, true);
	
		System.out.println(leafNode.deepestLeafNode.key);
	}

}

package com.practice.java.tree;

public class Cousins {

	public static void main(String[] args) {
		Node root = new Node(15);
		root.left = new Node(10);
		root.right = new Node(20);
		root.left.left = new Node(8);
		root.left.right = new Node(12);
		root.right.left = new Node(16);
		root.right.right = new Node(25);
		
		boolean isCousin = findIfCousins(root, 16, 8);
	}

	private static boolean findIfCousins(Node node, int elem1, int elem2) {
		if(node == null) {
			return false;
		}
		int level = 1;
		Node parent = null;
		
		NodeInfo x = new NodeInfo(elem1, 1, parent);
		NodeInfo y = new NodeInfo(elem2, 1, parent);
		
		inOrder(node, null, 1, x, y);
		
		if((x.level != y.level) || (x.parent == y.parent)){
			return false;
		}
		return true;
	}

	private static void inOrder(Node node, Node parent, int level, NodeInfo x, NodeInfo y) {
		if(node == null) {
			return;
		}
		inOrder(node.left, node, level + 1, x, y);
		
		if(node.key == x.key) {
			x.level = level;
			x.parent = parent;
		}
		
		if(node.key == y.key) {
			y.level = level;
			y.parent = parent;
		}
		
		inOrder(node.right, node, level + 1, x, y);
	}

}

class NodeInfo{
	int key;
	int level;
	Node parent = null;
	
	public NodeInfo(int key, int level, Node parent) {
		this.key = key;
		this.level = level;
		this.parent = parent;
	}
}

package com.practice.java.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.logging.Level;

public class SideViewOfTree {
	static int maxLevel = 0;
	public static void main(String[] args) {
		Node root = new Node(15);
		root.left = new Node(10);
		root.right = new Node(20);
		root.left.left = new Node(8);
		root.left.right = new Node(12);
		root.right.left = new Node(16);
		root.right.right = new Node(25);
		
		//leftView(root, 0);
		//maxLevel = 0;
		//rightView(root, 0);
		
		//bottomView(root);
		
		topView(root);
	}

	private static void rightView(Node node, int level) {
		if(node == null) {
			return;
		}
		
		if(level >= maxLevel) {
			System.out.println(node.key);
			maxLevel++;
		}
		rightView(node.right, level + 1);
		rightView(node.left, level + 1);
	}

	private static void leftView(Node node, int level) {
		if(node == null) {
			return;
		}
		
		if(level >= maxLevel) {
			System.out.println(node.key);
			maxLevel++;
		}
		leftView(node.left, level + 1);
		leftView(node.right, level + 1);
	}
	
	private static void bottomView(Node root) {
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.add(root);
		Node curr;
		while(!queue.isEmpty()) {
			curr = queue.poll();
			
			if(curr.left == null && curr.right == null) {
				System.out.println(curr.key);
			}
			if(curr.left != null) {
				queue.add(curr.left);
			}
			
			if(curr.right != null) {
				queue.add(curr.right);
			}
			
		}
		
	}
	
	private static void topView(Node node) {
		if(node == null) {
			return;
		}
		
		if(node.left != null) {
			System.out.println(node.left.key);
		}
		
		System.out.println(node.key);
		if(node.right != null) {
			System.out.println(node.right.key);

		}
	}


}

package com.practice.java.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		Node root = new Node(15);
		root.left = new Node(10);
		root.right = new Node(20);
		root.left.left = new Node(8);
		root.left.right = new Node(12);
		root.right.left = new Node(16);
		root.right.right = new Node(25);

		levelOrderTraversal(root);
		Node rightNode = findRightNode(root, 15);
		System.out.println(rightNode.key);
	}

	private static Node findRightNode(Node node, int i) {
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.add(node);
		Node curr;
		while(!queue.isEmpty()) {
			curr = queue.poll();
			if(curr.key == i) {
				if(queue.size() == 0) {
					return null;
				}
				return queue.peek();
			}
			if(curr.left != null) {
				queue.add(curr.left);
			}
			
			if(curr.right != null) {
				queue.add(curr.right);
			}
		}
		return null;
		
	}

	private static void levelOrderTraversal(Node root) {
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.add(root);
		Node curr;
		while(!queue.isEmpty()) {
			curr = queue.poll();
			
			System.out.println(curr.key + "  ");
			if(curr.left != null) {
				queue.add(curr.left);
			}
			
			if(curr.right != null) {
				queue.add(curr.right);
			}
		}
		
	}

}

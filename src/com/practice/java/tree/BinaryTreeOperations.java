package com.practice.java.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTreeOperations {

	
	
	/* QUEUE IMPLEMENTATION
	 * Check if the given binary tree is complete or not. 
	 */
	private static boolean isCompleteQueueImpl(Node node) {
		
		if(node == null) {
			return false;
		}
		
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.add(node);
		
		Node curr;
		boolean flag = false;
		while(!queue.isEmpty()) {
			curr = queue.poll();
			
			//If found any complete node after enqueuing one incomplete node
			if(flag && (curr.left != null || curr.right != null)) {
				queue.add(curr.left);
				flag = false;
			}
			
			//obvious condition for incomplete binary tree.
			if (curr.left == null && curr.right != null) {
				return false;
			}
			
			//Found non full node. expecting it to be the last so setting flag to true
			if(curr.left != null){
				queue.add(curr.left);
			}else {
				flag = true;
			}
			
			//Found non full node. expecting it to be the last so setting flag to true
			if(curr.right != null) {
				queue.add(curr.right);
			}else {
				flag = true;
			}
		}
		return true;
	}
	
	// ARRAY IMPLEMENTATION
	private static boolean isCompleteArrayImpl(Node node, int index, int size) {
		if(node == null){
			return true;
		}
		
		if((node.left != null && 2 * index + 1 >= size) || !isCompleteArrayImpl(node.left, 2 * index + 1, size)) {
			return false;
		}
		if((node.right != null && 2 * index + 2 >= size) || !isCompleteArrayImpl(node.right, 2 * index + 2, size)) {
			return false;
		}
		return true;
	}
	public static int size(Node node) {
		if(node == null) {
			return 0;
		}
		return 1 + size(node.left) + size(node.right);
	}
	
	
	public static void main(String[] args) {
		Node root = new Node(15);
		root.left = new Node(10);
		root.right = new Node(20);
		root.left.left = new Node(8);
		root.left.right = new Node(12);
		root.right.left = new Node(16);
		root.right.right = new Node(25);
		
		// QUEUE IMPLEMENTATION
		boolean isComplete = isCompleteQueueImpl(root);
		if(isComplete) {
			System.out.println("Complete binary tree");
		}else {
			System.out.println("Incomplete binary tree");
		}
		
		// ARRAY IMPLEMENTATION
		isComplete = isCompleteArrayImpl(root, 0, size(root));
	}

}

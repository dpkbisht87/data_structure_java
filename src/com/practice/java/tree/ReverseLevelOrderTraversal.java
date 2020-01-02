package com.practice.java.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderTraversal {

	public static void main(String args[]) {
		Node root = new Node(15);
		root.left = new Node(10);
		root.right = new Node(20);
		root.left.left = new Node(8);
		root.left.right = new Node(12);
		root.right.left = new Node(16);
		root.right.right = new Node(25);
		
		reverseLevelOrderTraversal(root);
	}

	private static void reverseLevelOrderTraversal(Node root) {
		Queue<Node> queue = new ArrayDeque<Node>();
		Stack<Integer> s1 = new Stack<Integer>();
		Node curr;
		queue.add(root);
		while(!queue.isEmpty()) {
			curr = queue.poll();
			//System.out.println(curr.key);
			s1.push(curr.key);
			
			if(curr.left != null) {
				queue.add(curr.left);
			}
			
			if(curr.right != null) {
				queue.add(curr.right);
			}
		}
		
		while(!s1.isEmpty()) {
			System.out.println(s1.pop());
		}
	}
}

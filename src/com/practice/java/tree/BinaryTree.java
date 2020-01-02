package com.practice.java.tree;


public class BinaryTree {

	 Node root;
	 BinaryTree(){
		 root = null;
	 }
	 
	 void printPostOrder(Node node) {
		 if(node == null) {
			 return;
		 }
		 printPostOrder(node.left);
		 printPostOrder(node.right);
		 System.out.println(node.key + " ");
	 }
	 
	 void printInOrder(Node node) {
		 if(node == null) {
			 return;
		 }
		 printInOrder(node.left);
		 System.out.println(node.key + " ");
		 printInOrder(node.right);
	 }
	 
	 void printPreOrder(Node node) {
		 if(node == null) {
			 return;
		 }
		 System.out.println(node.key + " ");
		 printPreOrder(node.left);
		 printPreOrder(node.right);
	 }
	 
	void printPostOrder()  {     printPostOrder(root);  } 
    void printInOrder()    {     printInOrder(root);   } 
    void printPreOrder()   {     printPreOrder(root);  } 
    
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		
		System.out.println("Preorder traversal of binary tree is "); 
        tree.printPreOrder();
        
        System.out.println("\nInorder traversal of binary tree is "); 
        tree.printInOrder(); 
  
        System.out.println("\nPostorder traversal of binary tree is "); 
        tree.printPostOrder(); 
	}

}

package com.practice.java.queue;

public interface Queue {
	void enqueue(Object item);
	
	Object dequeue();
	
	Object peek();
	
	int size();
	
	boolean isEmpty();

}

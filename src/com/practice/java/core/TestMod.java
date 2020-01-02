package com.practice.java.core;

public class TestMod {

	public static void main(String[] args) {
		int num = 2; 
		int cnt = 0;
		boolean reset = false;
		for (int i = 1; i <= num; i++) {
			if (i == 1) {
				reset = true;
			}
			for (int j = 1; j <= num; j++) {
				if (j == 1) {
					reset = true;
				}
				if (reset) {
					cnt = cnt +1;
					continue;
				}
				for (int k = 1; k <= num; k++) {
					reset = false;
					if((i * j)%k == 0) {
						cnt = cnt + 1;
					}
				}
			}
		}
		System.out.println("Answer:"+cnt);
	}

}

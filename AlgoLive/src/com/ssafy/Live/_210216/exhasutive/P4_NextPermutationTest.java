package com.ssafy.Live._210216.exhasutive;

import java.util.Arrays;
import java.util.Scanner;

public class P4_NextPermutationTest {

	static int N;
	static int[] input;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		Arrays.sort(input);
		do {
			System.out.println(Arrays.toString(input));
		}while(np());
		
	}

	private static boolean np() {
		
		//STEP 1
		int i=N-1;
		while(i>0 && input[i-1]>=input[i]) --i;
		
		if(i==0) return false;
		
		//STEP 2
		int j=N-1;
		while(input[i-1]>=input[j])	--j;
		
		//STEP 3
		swap(i-1,j);
		
		//STEP 4
		int k=N-1;
		while(i<k) {
			swap(i++,k--);			
		}
		return true;
	}
	
	private static void swap(int i,int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}

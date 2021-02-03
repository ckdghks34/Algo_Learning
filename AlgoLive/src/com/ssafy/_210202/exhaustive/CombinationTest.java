package com.ssafy._210202.exhaustive;

import java.util.Arrays;

public class CombinationTest {
	static int[] numbers;
	static int N = 4, R = 2;
	
	private static void combination(int cnt,int start) {
		
		if(cnt == R)
		{
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i = start; i <=N; i++) {
			numbers[cnt] = i;
			combination(cnt+1, i+1);
		}
		
		
	}
	
	public static void main(String[] args) {
		numbers = new int[R];
		combination(0,1);
	}
}

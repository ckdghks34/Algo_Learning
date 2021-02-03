package com.ssafy._210202.exhaustive;

import java.util.Arrays;

public class PermutationTest {
	static int[] numbers;
	static int N = 3;
	static boolean[] isSelected;
	
	private static void permutation(int cnt) {
		if(cnt == N)
		{
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i = 1; i <= N; i++)
		{
			if(isSelected[i] == true)
				continue;
			
			numbers[cnt] = i;
			isSelected[i] = true;
			
			permutation(cnt+1);
			isSelected[i]= false;
		}
	}
	
	public static void main(String[] args) {
			numbers = new int[N];
			isSelected = new boolean[N+1];
			
			permutation(0);
	}

}

package com.ssafy.Live._210215.exhasutive;

import java.util.Arrays;
import java.util.Scanner;

public class P4_PermutationNPTest {
	static int[] input;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		
		for(int i =0 ; i < N; ++i) {
			input[i] = sc.nextInt();
		}
		
		Arrays.sort(input); // 오름차순 정렬하여 가장 작은 순열의 상태로 만듦.
		
		do {
			System.out.println(Arrays.toString(input));
		}while(np());
		
		sc.close();
	}

	public static boolean np() {
		int i = N - 1;
		while (i > 0 && input[i - 1] >= input[i]) // 꼭대기 위치 i 찾기
			--i;
		
		// 더 이상 앞자리가 없는 상황 : 현 순열의 상태가 가장 큰 순열(마지막 순열)
		if(i == 0) return false;
		
		int j = N-1;
		while(input[i-1] >= input[j]) // i-1보다 큰  위치j 찾기
			--j;
		
		swap(i-1,j);
		
		int k = N-1;
		while(i<k) {
			swap(i++,k--);	//내림차순이라 오름차순으로 정렬
		}
		
		return true;
	}
	private static void swap(int i , int j)
	{
		int tmp = input[i];
		input[i] = input[j];
		input[j] = tmp;
	}
}

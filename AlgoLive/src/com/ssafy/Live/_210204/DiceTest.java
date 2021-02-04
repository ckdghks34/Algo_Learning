package com.ssafy.Live._210204;

import java.util.Arrays;
import java.util.Scanner;

public class DiceTest {

	static int N;
	static int[] numbers;
	static boolean[] isSelected;
	static int totalCnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];
		isSelected = new boolean[7];

		int M = sc.nextInt();
		totalCnt = 0;

		switch (M) {
		case 1:
			dice1(0);
			break;
		case 2:
			dice2(0);
			break;
		case 3:
			dice3(0,1);
			break;
		case 4:
			dice4(0,1);

		}
		System.out.println("총 경우의 수 :" + totalCnt);
	}

	// 중복 순열 n^r
	private static void dice1(int cnt) {

		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = 1; i <= 6; ++i) {
			numbers[cnt] = i;
			dice1(cnt + 1);
		}
	}

	// 순열 : nPr ==> n!
	private static void dice2(int cnt) {

		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 1; i <= 6; ++i) {
			if (isSelected[i])
				continue;

			numbers[cnt] = i;
			isSelected[i] = true;
			dice2(cnt + 1);
			isSelected[i] = false;
		}
	}
	
	// 중복 조합
	private static void dice3(int cnt, int start) {
		
		if(cnt == N)
		{
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice3(cnt+1, i);
		}
	}
	
	// 조합 : 
	private static void dice4(int cnt, int start) {
		
		if(cnt == N)
		{
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice4(cnt+1, i+1);
		}
	}
}

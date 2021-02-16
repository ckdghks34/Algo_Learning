package com.ssafy.Live._210216.exhasutive;
import java.util.Scanner;

public class C2_NextPermutationTest {
	static int N, R;
	static int[] input;
	static int[] P;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();

		input = new int[N];
		P = new int[N]; // N 크기의 flag 배열

		for (int i = 0; i < N; ++i) {
			input[i] = sc.nextInt();
		}

		int cnt = 0;
		while (++cnt <= R)
			P[N - cnt] = 1;
		
		do {
			for(int i =0 ; i < N; ++i) {
				if(P[i] == 1) System.out.print(input[i] + " ");
			}
			System.out.println();
		}while(np());
		
		sc.close();
	}

	public static boolean np() {

		// Step1
		int i = N - 1;
		while (i > 0 && P[i - 1] >= P[i]) // 꼭대기 위치 i 찾기
			--i;

		// 더 이상 앞자리가 없는 상황 : 현 순열의 상태가 가장 큰 순열(마지막 순열)
		if (i == 0)
			return false;

		// Step2
		int j = N - 1;
		while (P[i - 1] >= P[j]) // i-1보다 큰 위치j 찾기
			--j;

		// Step3
		swap(i - 1, j);

		// Step4
		int k = N - 1;
		while (i < k) {
			swap(i++, k--); // 내림차순이라 오름차순으로 정렬
		}

		return true;
	}

	private static void swap(int i, int j) {
		int tmp = P[i];
		P[i] = P[j];
		P[j] = tmp;
	}
}

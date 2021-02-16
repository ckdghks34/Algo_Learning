package com.ssafy.Live._210215.exhasutive;

import java.util.Arrays;
import java.util.Scanner;

public class P3_PermutationBitmaskTest {
	static int N;
	static int[] input, numbers;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		numbers = new int[N];

		for (int i = 0; i < N; i++)
			input[i] = sc.nextInt();

		Permutation(0, 0);
		sc.close();
	}

	private static void Permutation(int cnt, int flag) {
		if (cnt == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0)
				continue;
			numbers[cnt] = input[i];
			Permutation(cnt + 1, flag | 1 << i);
		}
	}

}

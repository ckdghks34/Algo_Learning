package com.ssafy.Live._210325.dp2;

import java.util.Arrays;
import java.util.Scanner;

public class DP2_LISTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N]; // 원소들 저장
		int[] LIS = new int[N]; // 각 원소를 마지막에 세웠을때의 최장 길이

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; ++i) {
			arr[i] = sc.nextInt();
		}

		// Arrays.fill(LIS, 1);

		for (int i = 0; i < N; ++i) {
			LIS[i] = 1; // 자기 혼자 세웠을때의 길이로 초기화
			for (int j = 0; j < i; ++j) { // 맨앞에서 부터 자신 앞까지 원소들과 비교
				if (arr[j] < arr[i] && LIS[i] < LIS[j] + 1) { // 앞의 원소 보다 자신의 원소가 크고 / 앞의 원소 최장길이 +1 가 자신의 최장길이 보다 길다면
					LIS[i] = LIS[j] + 1;
					max = Math.max(LIS[i], max);
				}
			}
		}
		System.out.println(max);
	}
}

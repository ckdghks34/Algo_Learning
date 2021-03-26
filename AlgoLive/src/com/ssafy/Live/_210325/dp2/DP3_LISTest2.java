package com.ssafy.Live._210325.dp2;

import java.util.Arrays;
import java.util.Scanner;

public class DP3_LISTest2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N]; // 원소들 저장
		int[] LIS = new int[N]; // 각 원소를 마지막에 세웠을때의 최장 길이

		for (int i = 0; i < N; ++i) {
			arr[i] = sc.nextInt();
		}

		int size = 0;

		for (int i = 0; i < N; ++i) {
			int tmp = Arrays.binarySearch(LIS, 0, size, arr[i]); // size 직전index 까지 해서 arr[i]에 담아라

			tmp = Math.abs(tmp) - 1; // 중복값이 없으므로 탐색에 실패하고 음수값 리턴
			LIS[tmp] = arr[i]; // 맨 뒤에 추가되거나 기존위치에 덮어쓰거나

			if (tmp == size)
				++size;
		}

		System.out.println(size);
	}
}

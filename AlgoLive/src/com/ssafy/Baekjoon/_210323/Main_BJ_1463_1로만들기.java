package com.ssafy.Baekjoon._210323;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//@fomatter:off
/*
 	* 문제
 	정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

	1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
	2. X가 2로 나누어 떨어지면, 2로 나눈다.
	3. 1을 뺀다.
	
	정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
 	
 	* 입력
	첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.

	* 출력
	첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
 */
//@fomatter:on

public class Main_BJ_1463_1로만들기 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N + 1];
		for (int i = 2; i <= N; ++i) {

			// 2와 3의 공배수 일 때,
			if (i % 6 == 0) {
				arr[i] = Math.min(arr[i - 1] + 1, Math.min(arr[i / 3] + 1, arr[i / 2] + 1));
			}

			// 2로 나누어지지만 3으로 나누어 지지 않을 때,
			else if (i % 2 == 0 && i % 3 != 0) {
				arr[i] = Math.min(arr[i / 2] + 1, arr[i - 1] + 1);
			}
			// 3으로 나누어지지만 2로 나누어 지지 않을 때
			else if (i % 2 != 0 && i % 3 == 0) {
				arr[i] = Math.min(arr[i / 3] + 1, arr[i - 1] + 1);
			}
			// 2 와 3 모두 나누어 지지 않을 때
			else {
				arr[i] = arr[i - 1] + 1;
			}

		}
		System.out.println(arr[N]);
	}
}

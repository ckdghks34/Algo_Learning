package com.ssafy.workshop._210323;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  - 연습문제 2 -
	1cm 짜리 파란 막대와 1cm 짜리 노란 막대 그리고 2cm 짜리 빨간 막대가 있다. 
	이 막대들을 연결하여 길이가 ncm인 막대를 만드는 방법의 수를 f(n)이라 하자. 
	예를 들면 2cm 막대를 만드는 방법은
	(파란 막대, 파란 막대), 
	(파란 막대, 노란 막대), 
	(노란 막대, 파란 막대), 
	(노란 막대, 노란 막대), 
	(빨간 막대)
	5가지이므로 f(2) = 5이다. 
	f(6)의 값은?
 */
public class DP_ws_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] F = new int[N + 1];
		F[0] = 1;
		F[1] = 2;

		for (int i = 2; i <= N; ++i) {
			F[i] = 2*F[i - 1] + F[i - 2];
		}
		System.out.println(F[N]);
		System.out.println(Arrays.toString(F));

	}

}

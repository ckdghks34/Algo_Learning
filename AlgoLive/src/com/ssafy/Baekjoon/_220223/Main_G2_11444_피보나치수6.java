package com.ssafy.Baekjoon._220223;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 참고사이트 : https://st-lab.tistory.com/252
/*
 * F(n+2)		1	1		F(n+1)
 * 			= 			*
 * F(n+1)		1	0		F(n)
 */
/*
 * F(n+1)		1
 * 			= 
 * F(n)			0
 */

public class Main_G2_11444_피보나치수6 {
	public static long N;
	public static long[][] init = { { 1, 1 }, { 1, 0 } };
	public static long[][] result;
	public static final long MOD = 1000000007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Long.parseLong(br.readLine());

		bw.write(Long.toString(pivonacci(N)));
		bw.flush();
		bw.close();
		br.close();

	}

	public static long pivonacci(long n) {
		long[][] pow = exponentiation(n);
		
		// {1, 0} 행렬 곱 하면, 0 때문에 뒤에 [x][0],[x][1]은 0으로 된다.
		// 따라서, pow[1][0]의 값을 return
		return pow[1][0];
	}

	public static long[][] exponentiation(long n) {

		if (n == 0)
			return new long[2][2];

		if (n == 1)
			return init;

		long[][] pow = exponentiation(n / 2);

		if (n % 2 == 0) {
			return multiple(pow, pow);
		} else
			return multiple(multiple(pow, pow), init);

	}

	public static long[][] multiple(long[][] a, long[][] b) {
		long[][] res = new long[2][2];

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++) {
					res[i][j] += (a[i][k] * b[k][j]) % MOD;
					res[i][j] %= MOD;
				}
			}
		}

		return res;
	}
}

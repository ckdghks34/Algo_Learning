package com.ssafy.Baekjoon._220109;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_S1_10844_쉬운계단수 {

	public static int N;
	public static long[][] dp;
	public static long[] sum;
	public static final int remainder = 1000000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		dp = new long[N + 1][10];
		sum = new long[N + 1];
		for (int i = 1; i < 10; ++i) {
			dp[1][i] = 1;
			sum[1] += dp[1][i];
		}

		for (int i = 2; i <= N; ++i) {
			for (int j = 0; j <= 9; ++j) {
				if (j == 0) {
					dp[i][j] = dp[i-1][j+1] % remainder;
				} else if (j == 9) {
					dp[i][j] = dp[i-1][j - 1] % remainder;
				} else {
					dp[i][j] = (dp[i-1][j - 1] + dp[i-1][j + 1]) % remainder;
				}
				sum[i] += dp[i][j];
			}
		}

		long result = sum[N] % remainder;
		bw.write(Long.toString(result));
		bw.flush();
		bw.close();
		br.close();
	}

}

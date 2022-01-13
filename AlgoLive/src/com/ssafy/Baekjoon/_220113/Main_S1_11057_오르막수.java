package com.ssafy.Baekjoon._220113;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_S1_11057_오르막수 {
	public static int N;
	public static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1][10];

		int sum = 0;
		for (int i = 1; i <= N; ++i) {
			dp[i][0] = 1;
			for (int j = 1; j < 10; ++j)
				dp[i][j] = (dp[i][j - 1]+ dp[i - 1][j]) % 10007;
		}

		for (int i = 0; i < 10; ++i) {
			sum += dp[N][i];
		}
		sum = sum % 10007;
		bw.write(Integer.toString(sum));
		bw.flush();
		bw.close();
		br.close();
	}

}

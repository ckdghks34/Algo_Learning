package com.ssafy.Baekjoon._211227;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_S3_2193_이친수 {

	public static int N;
	public static long[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		dp = new long[N + 1];

		dp[1] = 1;

		if (N >= 2) {
			for (int i = 2; i <= N; ++i)
				dp[i] = dp[i - 2] + dp[i - 1];
		}

		sb.append(dp[N]);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}

package com.ssafy.Baekjoon._211228;

import java.io.*;
import java.util.*;

public class Main_S3_1904_01타일 {

	/*
	 * N = 1 => 1	[1]
	 * N = 2 => 00, 11	[2]
	 * N = 3 => 111, 100, 001	[3] 
	 * N = 4 => 1111, 1100, 1001, 0011, 0000	[5] 
	 * N = 5 => 11111, 11100, 11001, 10011, 10000, 00111, 00100, 00001	[8]
	 * 
	 * 점화식 
	 * dp[N] = dp[N-1] + dp[N-2]
	 * 
	 */
	public static int N;
	public static long[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		dp = new long[N + 1];
		dp[0] = dp[1] = 1;

		if (N >= 2) {
			for (int i = 2; i <= N; ++i) {
				dp[i] = ((dp[i - 1]%15746) + (dp[i - 2]%15746))%15746;
			}
		}
		sb.append(dp[N]);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

}

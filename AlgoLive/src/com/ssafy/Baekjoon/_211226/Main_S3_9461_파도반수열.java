package com.ssafy.Baekjoon._211226;

import java.io.*;
import java.util.*;

public class Main_S3_9461_파도반수열 {

	/*
	 * 점화식 
	 	1. dp[N] = dp[N-1] + dp[N-5]; 
	 	2. dp[N] = dp[N-2] + dp[N-3];
	 */

	public static int T, N;
	public static long[] dp = new long[101];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		dp[0] = dp[1] = dp[2] = dp[3] = 1;

		for (int tc = 1; tc <= T; ++tc) {
			N = Integer.parseInt(br.readLine());

			for (int i = 4; i <= N; ++i) {
				if(dp[i] > 0)
					continue;
				dp[i] = dp[i-2] + dp[i-3];
			}
			sb.append(dp[N]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

}

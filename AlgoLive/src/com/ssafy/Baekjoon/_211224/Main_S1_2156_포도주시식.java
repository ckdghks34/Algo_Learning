package com.ssafy.Baekjoon._211224;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_S1_2156_포도주시식 {

	public static int N;
	public static int[] wine;
	public static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		wine = new int[N + 1];
		dp = new int[N + 1];

		for (int i = 1; i <= N; ++i)
			wine[i] = Integer.parseInt(br.readLine());

		dp[1] = wine[1];
		if (N > 1)
			dp[2] = wine[1] + wine[2];

		for (int i = 3; i <= N; ++i)
			dp[i] = Math.max(Math.max(dp[i - 2] + wine[i], wine[i - 1] + wine[i] + dp[i - 3]), dp[i - 1]);

		sb.append(dp[N]);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}
}

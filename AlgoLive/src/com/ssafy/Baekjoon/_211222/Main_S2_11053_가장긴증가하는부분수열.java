package com.ssafy.Baekjoon._211222;

import java.util.*;
import java.io.*;

public class Main_S2_11053_가장긴증가하는부분수열 {
	public static int N;
	public static int[] sequence, dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		sequence = new int[N + 1];
		dp = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= N; ++i) {
			sequence[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}

		for (int i = 2; i <= N; ++i)
			find(i);

		Arrays.sort(dp);
		sb.append(dp[dp.length - 1]);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static int find(int x) {
		
		if(dp[x] > 1)
			return dp[x];
		for (int i = x - 1; i > 0; --i) {
			if (sequence[i] < sequence[x]) {
				dp[x] = Math.max(find(i) + 1, dp[x]);
			}
		}

		return dp[x];
	}
}

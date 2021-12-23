package com.ssafy.Baekjoon._211223;

import java.io.*;
import java.util.*;

public class Main_S2_1912_연속합 {
	public static int N;
	public static int[] map;
	public static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		map = new int[N];
		dp = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; ++i) {
			map[i] = Integer.parseInt(st.nextToken());
			dp[i] = Integer.MAX_VALUE;
		}
		dp[0] = map[0];

		for (int i = 1; i < N; ++i)
			find(i);
		
		Arrays.sort(dp);
		
		sb.append(dp[N-1]);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static int find(int x) {

		// 이미 값이 있으면
		if (dp[x] != Integer.MAX_VALUE)
			return dp[x];
		if(dp[x-1] < 0)
			dp[x] = map[x];

		else
			dp[x] = Math.max(find(x-1) + map[x], map[x - 1] + map[x]);
		
		return dp[x];
	}
}

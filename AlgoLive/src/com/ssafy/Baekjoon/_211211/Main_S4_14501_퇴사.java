package com.ssafy.Baekjoon._211211;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S4_14501_퇴사 {
	public static int N;
	public static int max = Integer.MIN_VALUE;
	public static int[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		max = Integer.MIN_VALUE;
		int[][] data = new int[N][2];
		dp = new int[N+1];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			data[i][0] = Integer.parseInt(st.nextToken());
			data[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0 ; i<N;++i)
		{
			if(i + data[i][0] <= N)
			{
				dp[i+data[i][0]] = Math.max(dp[i+data[i][0]], dp[i]+data[i][1]);
			}
			dp[i+1] = Math.max(dp[i+1], dp[i]);
		}
		
		
		System.out.println(dp[N]);
	}
}

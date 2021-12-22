package com.ssafy.Baekjoon._211222;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_S3_2579_계단오르기 {
	
	public static int N;
	public static int[] dp;
	public static int[] floor;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		floor = new int[N+1];
		dp = new int[N+1];
		
		for(int i =1 ;i <= N;++i)
			floor[i] = Integer.parseInt(br.readLine());
		
		
		dp[1] = floor[1];
		
		sb.append(programming(N));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	public static int programming(int x) {
		
		if(x <= 0)
			return 0;
		
		if(dp[x] > 0)
			return dp[x];
		
		dp[x] = Math.max(programming(x-3)+floor[x-1], programming(x-2)) + floor[x];
		return dp[x];
	}
}

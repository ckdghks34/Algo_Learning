package com.ssafy.Baekjoon._211221;

import java.io.*;

public class Main_B2_10870_피보나치수5 {
	
	
	public static int[] dp = new int[21];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		dp[1] = 1;
		dp[2] = 1;
		
		
		sb.append(Fibonacci(N));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int Fibonacci(int x) {
		if(x <= 0)
			return 0;
		
		if(dp[x] > 0)
			return dp[x];
		
		dp[x] = Fibonacci(x-1) + Fibonacci(x-2);
		return dp[x];
	}
}

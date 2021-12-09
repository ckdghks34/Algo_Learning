package com.ssafy.Baekjoon._211209;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_B1_16395_파스칼의삼각형 {

	public static int n, k;
	public static int[][] dp;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		dp = new int[n][n];
		
		sb.append(pascal(n-1, k-1));
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int pascal(int N, int K) {
		if(N <= 0)
		{
			dp[N][K] = 1;
			return 1;	
		}
		
		if(K == 0 || K == N)
		{			
			dp[N][K] = 1;
			return 1;
		}
		
		if(dp[N][K] > 0)
		{
			return dp[N][K];
		}
		
		dp[N][K] = pascal(N-1, K-1) + pascal(N-1,K);
		
		return dp[N][K];
	}
}

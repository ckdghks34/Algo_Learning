package com.ssafy.Baekjoon._211207;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_S1_11051_이항계수2  {

	public static int N,K;
	public static int result;
	public static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[N+1][K+1];
		result = 0;
		
//		Combination(0, 0);
		result = Combinations(N,K);
		
		
		if(result >= 10007)
			result %= 10007;
		sb.append(result);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void Combination(int start, int count) {
		if(count == K)
		{
			result++;
		}
		
		for(int i = start; i < N; i++)
			Combination(i+1, count+1);
	}
	
	public static int Combinations(int n, int k) {
		if(n == k || k == 0)
			return 1;
		
		if(dp[n][k] > 0)
			return dp[n][k];
		
		dp[n][k] = ((Combinations(n-1,k-1)%10007) + (Combinations(n-1,k)%10007))%10007;
		
		return dp[n][k];
	}
}

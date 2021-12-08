package com.ssafy.Baekjoon._211208;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_S3_2407_조합 {
	public static int N,M;
	public static BigInteger [][] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dp = new BigInteger[N+1][M+1];
		
		BigInteger result;
		result = Combinations(N, M); 
		
		bw.write(result.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static BigInteger Combinations(int n, int c)
	{
		if(n == c || c == 0)
			return BigInteger.ONE;
		
		if(dp[n][c] != null)
			return dp[n][c];
		
		dp[n][c] = Combinations(n-1, c-1).add(Combinations(n-1,c));
		return dp[n][c];
	}

}

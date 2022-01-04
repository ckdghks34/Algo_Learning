package com.ssafy.Baekjoon._220104;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S4_11866_요세푸스문제0 {
	public static int dp[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append("<");

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1];
		dp[1] = 1;
		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 1; i <= N; ++i)
			queue.offer(i);

		while (!queue.isEmpty()) {
			for (int i = 1; i < K; ++i) {
				queue.offer(queue.poll());
			}

			sb.append(queue.poll());

			if (!queue.isEmpty())
				sb.append(", ");
		}
		sb.append(">").append("\n");
		sb.append("마지막 생존자 : ").append(lastSurvior(N, K));
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int lastSurvior(int n, int k) {
		
		if(n == 1)
			return 1;
		
		if(dp[n] > 0)
			return dp[n];
		
		dp[n] = ((lastSurvior(n-1, k) + k-1) % n)+1;
		
		return dp[n];
	}
}

package com.ssafy.Baekjoon._220110;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_S1_11052_카드구매하기 {

	static int N;
	static int[] card;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		card = new int[N + 1];
		dp = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i) {
			card[i] = Integer.parseInt(st.nextToken());
			dp[i] = card[i];
		}

		for (int i = 1; i <= N; ++i) {
			for (int j = 1; j <= i; ++j) {
				dp[i] = Math.max(dp[i], card[j] + dp[i - j]);
			}
		}
		bw.write(Integer.toString(dp[N]));
		bw.flush();
		bw.close();
		br.close();
	}
}

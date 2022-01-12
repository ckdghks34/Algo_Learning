package com.ssafy.Baekjoon._220112;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_S1_9465_스티커 {
	static int T, N;
	static int[][] sticker;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			int max = 0;
			
			
			N = Integer.parseInt(br.readLine());
			sticker = new int[2][N];
			dp = new int[2][N + 1];
			for (int i = 0; i < 2; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; ++j) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dp[0][1] = sticker[0][0];
			dp[1][1] = sticker[1][0];
			max = Math.max(dp[0][1], dp[1][1]);
			
			for (int i = 2; i <= N; ++i) {
				dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i - 1];
				dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i - 1];
				max = Math.max(max, Math.max(dp[0][i], dp[1][i]));
			}
			sb.append(max).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}

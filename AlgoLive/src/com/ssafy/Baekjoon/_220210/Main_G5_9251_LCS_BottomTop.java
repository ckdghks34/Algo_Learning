package com.ssafy.Baekjoon._220210;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_G5_9251_LCS_BottomTop {

	static String s1, s2;
	static int size1, size2;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		s1 = br.readLine();
		s2 = br.readLine();

		size1 = s1.length();
		size2 = s2.length();

		dp = new int[size1 + 1][size2 + 1];

		// 길이 구하기
		for (int i = 1; i <= size1; ++i) {
			for (int j = 1; j <= size2; ++j) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		// LCS 수열 구하기
		int cur = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("LCS 수열 : ");
		for (int i = 1; i <= size1; ++i) {
			for (int j = 1; j <= size2; ++j) {
				if (dp[i][j] == cur + 1) {
					sb.append(s1.charAt(i-1));
					cur += 1;
					break;
				}
			}
		}
		
		bw.write(sb.append("\n").toString());
		bw.flush();
		sb = new StringBuilder();
		
		sb.append("LCS 수열 길이 구하기 : ").append(dp[size1][size2]);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}

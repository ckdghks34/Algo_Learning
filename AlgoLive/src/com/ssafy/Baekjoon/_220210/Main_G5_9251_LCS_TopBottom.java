package com.ssafy.Baekjoon._220210;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_G5_9251_LCS_TopBottom {

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

		dp = new int[size1][size2];

		int result = LCS(size1 - 1, size2 - 1);

		bw.write(Integer.toString(result));
		bw.flush();
		bw.close();
		br.close();
	}

	public static int LCS(int x, int y) {
		if (x < 0 || y < 0)
			return 0;

		if (dp[x][y] > 0)
			return dp[x][y];

		if (s1.charAt(x) == s2.charAt(y)) {
			dp[x][y] = LCS(x - 1, y - 1) + 1;
		} else {
			dp[x][y] = Math.max(LCS(x - 1, y), LCS(x, y - 1));
		}

		return dp[x][y];
	}
}

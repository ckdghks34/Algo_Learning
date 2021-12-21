package com.ssafy.Baekjoon._211221;

import java.util.*;
import java.io.*;

public class Main_S3_9095_123더하기 {

	public static int T;
	public static int[] dp = new int[11];
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());

		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;

		for (int tc = 0; tc < T; ++tc) {
			int c = Integer.parseInt(br.readLine());

			sb.append(expression(c)).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static int expression(int x) {
		if (x < 0)
			return 0;

		if (dp[x] > 0)
			return dp[x];

		dp[x] = expression(x - 1) + expression(x - 2) + expression(x - 3);

		return dp[x];

	}
}

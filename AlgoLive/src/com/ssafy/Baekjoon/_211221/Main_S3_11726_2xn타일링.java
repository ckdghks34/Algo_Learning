package com.ssafy.Baekjoon._211221;

import java.io.*;

public class Main_S3_11726_2xn타일링 {

	public static int[] dp = new int[1001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		dp[0] = dp[1] = 1;

		sb.append(dynamic(n));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static int dynamic(int x) {
		if (x < 0)
			return 0;
		if (dp[x] > 0)
			return dp[x];

		dp[x] = ((dynamic(x - 1)%10007) + (dynamic(x - 2)%10007))%10007;
		
		return dp[x];
	}
}

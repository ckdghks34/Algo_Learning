package com.ssafy.Baekjoon._220214;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_11399_ATM {
	public static int N, result;
	public static int[] data;
	public static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		data = new int[N];
		dp = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i)
			data[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(data);

		dp[0] = data[0];
		result = dp[0];
		for (int i = 1; i < N; ++i) {
			dp[i] = dp[i - 1] + data[i];
			result += dp[i];
		}

		bw.write(Integer.toString(result));
		bw.flush();
		bw.close();
		br.close();
	}

}

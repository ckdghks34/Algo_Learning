package com.ssafy.Baekjoon._220108;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_S1_1932_정수삼각형 {
	public static int N, sum;
	public static int[][] dp;
	public static int[][] data;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		data = new int[N + 1][N + 1];
		dp = new int[N + 1][N + 1];
		int max = 0;

		for (int i = 1; i < N + 1; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < i + 1; ++j) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		if (N == 1) {
			// 삼각형의 크기가 1이라면 입력값이 최대 경로 합
			max = data[1][1];
		} else {
			dp[1][1] = data[1][1];

			for (int i = 2; i < N + 1; ++i) {
				for (int j = 1; j < i + 1; ++j) {

					// 왼쪽 부모 + 현재 값
					int left = dp[i - 1][j - 1] + data[i][j];
					// 오른쪽 부모 + 현재 값
					int right = dp[i - 1][j] + data[i][j];

					// 더 큰 값을 dp 저장
					dp[i][j] = Math.max(left, right);

					// 돌면서 가장 큰 값 저장
					max = Math.max(max, dp[i][j]);
				}
			}
		}

		bw.write(Integer.toString(max));
		bw.flush();
		bw.close();
		br.close();
	}

}

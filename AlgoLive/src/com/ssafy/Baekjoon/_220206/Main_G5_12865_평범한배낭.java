package com.ssafy.Baekjoon._220206;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_G5_12865_평범한배낭 {
	public static int N, K;
	public static int[] W, V;
	public static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		W = new int[N+1];
		            V = new int[N + 1];
		map = new int[N + 1][K + 1];

		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; ++i) {
			for (int j = 1; j <= K; ++j) {
				if (j - W[i] >= 0) {
					map[i][j] = Math.max(map[i - 1][j], map[i - 1][j - W[i]] + V[i]);
				} else {
					map[i][j] = map[i - 1][j];
				}
			}
		}

		bw.write(Integer.toString(map[N][K]));
		bw.flush();
		bw.close();
		br.close();
	}
}

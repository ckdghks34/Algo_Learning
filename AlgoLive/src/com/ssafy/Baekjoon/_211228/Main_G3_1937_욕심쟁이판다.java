package com.ssafy.Baekjoon._211228;

import java.util.*;
import java.io.*;

public class Main_G3_1937_욕심쟁이판다 {

	public static int N;
	public static int[][] map;
	public static int[][] dp;

	// 상하좌우
	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N];
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (dp[i][j] == 0)
					result = Math.max(result, dfs(i, j));
			}
		}
		
		sb.append(result);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static int dfs(int y, int x) {
		if (dp[y][x] > 0)
			return dp[y][x];
		int max = 1;

		for (int i = 0; i < 4; ++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if (map[ny][nx] > map[y][x]) {
					max = Math.max(dfs(ny, nx)+1, max);
					dp[y][x] = max;
				}
			}
		}

		return max;
	}
}

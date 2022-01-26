package com.ssafy.Baekjoon._220126;

import java.awt.Checkbox;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_S2_13565_침투 {
	public static int N, M;
	public static int[][] map;

	public static boolean success = false;

	// 상하좌우
	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		String result = "";
		for (int i = 0; i < N; ++i) {
			String tmp = br.readLine();
			for (int j = 0; j < M; ++j) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}

		for (int i = 0; i < M; ++i) {
			if (success)
				break;
			if (map[0][i] == 0) {
				boolean[][] visited = new boolean[N][M];
				dfs(i, 0, visited);
			}
		}
		result = success ? "YES" : "NO";

		bw.write(result);
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dfs(int x, int y, boolean[][] visited) {
		if (success)
			return;

		if (y == N-1) {
			success = true;
			return;
		}

		visited[y][x] = true;

		for (int i = 0; i < 4; ++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
				if (!visited[ny][nx]) {
					if (map[ny][nx] == 0) {
						dfs(nx, ny, visited);
					}
				}
			}
		}
	}
}

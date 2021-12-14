package com.ssafy.Baekjoon._211214;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_S2_4963_섬의개수 {

	public static int N = -1, M = -1;
	public static int[][] map;
	public static boolean[][] visited;
	// 상 우상 우 우하 하 하좌 좌 좌상
	public static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	public static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = 0;

		while(true) {
			// Map 크기 입력
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			if(N == 0 && M == 0)
				break;
			
			map = new int[M][N];
			visited = new boolean[M][N];
			count = 0;
			for (int i = 0; i < M; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < M; ++i) {
				for (int j = 0; j < N; ++j) {
					if (map[i][j] == 1 && !visited[i][j]) {
						count++;
						dfs(i, j);
					}
				}
			}
			sb.append(count);
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dfs(int i, int j) {
		if (visited[i][j])
			return;

		visited[i][j] = true;
		for (int t = 0; t < 8; ++t) {
			int nx = j + dx[t];
			int ny = i + dy[t];

			if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
				if (map[i][j] == 1&&!visited[ny][nx]) {
					dfs(ny, nx);
				}
			}
		}
	}
}
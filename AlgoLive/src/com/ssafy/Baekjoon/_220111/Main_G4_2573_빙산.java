package com.ssafy.Baekjoon._220111;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_2573_빙산 {
	static int N, M;
	static int[][] map;

	// 상하좌우
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		int max = -1;

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}
		int cnt = 0;
		while ((cnt = SeparateNum()) < 2) {
			boolean[][] visited = new boolean[N][M];

			int count = 0;

			for (int j = 0; j < N; ++j) {
				for (int k = 0; k < M; ++k) {
					if (map[j][k] > 0 && !visited[j][k]) {
						count++;
						if (count > 1) {
							bw.write(Integer.toString(cnt));
							bw.flush();
							bw.close();
							br.close();
							return;
						}
						bfs(k, j, visited);
					}
				}
			}
		}
		bw.write("0");
		bw.flush();
		bw.close();
		br.close();
	}

	public static int SeparateNum() {
		boolean[][] visited = new boolean[N][M];

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					dfs(i, j, visited);
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static void dfs(int x, int y, boolean[][] visited) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx <= 0 && ny >= 0 && nx < N && ny < N) {
				if (map[ny][nx] != 0 && !visited[ny][nx]) {
					dfs(nx, ny, visited);
				}
			}
		}
	}

	public static void bfs(int x, int y, boolean[][] visited) {
		Queue<int[]> queue = new LinkedList<>();

		queue.offer(new int[] { x, y });
		visited[y][x] = true;

		while (!queue.isEmpty()) {
			int cur[] = queue.poll();
			int curx = cur[0];
			int cury = cur[1];

			for (int i = 0; i < 4; ++i) {
				int nx = curx + dx[i];
				int ny = cury + dy[i];

				if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
					if (map[ny][nx] == 0 && !visited[ny][nx]) {
						map[cury][curx] = map[cury][curx] > 0 ? map[cury][curx] - 1 : 0;

					} else {
						if (!visited[ny][nx]) {
							queue.offer(new int[] { nx, ny });
							visited[ny][nx] = true;
						}
					}
				}
			}
		}
	}
}

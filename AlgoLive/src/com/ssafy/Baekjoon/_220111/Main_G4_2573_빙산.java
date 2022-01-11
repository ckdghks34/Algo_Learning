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

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		int number = 0;
		do {
			// 빙산 구역 세기
			cnt = iceCounting();

			if (cnt == 0) {
				number = 0;
				break;
			} else if (cnt > 0) {
				break;
			} else {
				// 빙산 녹이기
				bfs();
			}

			number++;
		} while (true);

		bw.write(Integer.toString(number));
		bw.flush();
		bw.close();
		br.close();
	}

	// 빙산 구역 세기
	public static int iceCounting() {
		boolean[][] visited = new boolean[N][M];

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					dfs(j, i, visited);
					cnt++;
				}
				if (cnt > 1)
					return cnt;
			}
		}
		return cnt;
	}

	public static void dfs(int x, int y, boolean[][] visited) {
		visited[y][x] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
				if (map[ny][nx] != 0 && !visited[ny][nx]) {
					dfs(nx, ny, visited);
				}
			}
		}
	}
	
	// 빙산 녹이기
	public static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j)
				if (map[i][j] != 0) {
					queue.offer(new int[] { j, i });
					visited[i][j] = true;
				}
		}

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
					}
				}
			}
		}
	}
}

package com.ssafy.Baekjoon._220203;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_22352_항체인식 {
	static int N, M;
	static int[][] before, after;
	static boolean[][] visited;

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		before = new int[N][M];
		after = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j)
				before[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j)
				after[i][j] = Integer.parseInt(st.nextToken());
		}
		put();
		String result = check() ? "YES" : "NO";

		bw.write(result);
		bw.flush();
		bw.close();
		br.close();

	}

	public static boolean check() {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (before[i][j] != after[i][j])
					return false;
			}
		}
		return true;
	}

	public static void put() {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (!visited[i][j]) {
					if (before[i][j] != after[i][j]) {
						bfs(i, j, after[i][j]);
						return;
					}
				}
			}
		}
	}

	public static void bfs(int y, int x, int value) {
		int bvalue = before[y][x];
		Queue<int[]> queue = new LinkedList<int[]>();

		queue.offer(new int[] { x, y });
		visited[y][x] = true;
		before[y][x] = value;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int curx = current[0];
			int cury = current[1];

			for (int i = 0; i < 4; ++i) {
				int nx = curx + dx[i];
				int ny = cury + dy[i];

				if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
					if (!visited[ny][nx]) {
						if (before[ny][nx] == bvalue) {
							queue.offer(new int[] { nx, ny });
							visited[ny][nx] = true;
							before[ny][nx] = value;
						}
					}
				}
			}
		}
	}
}

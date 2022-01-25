package com.ssafy.Baekjoon._220125;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_1743_음식물피하기 {
	public static int N, M, K;
	public static int[][] map;
	public static boolean[][] visited;

	public static int max = 0;
	public static int count = 0;
	// 상하좌우
	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0, 0 };
	public static Queue<int[]> queue = new LinkedList<int[]>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			map[r][c] = 1;
			queue.add(new int[] { r, c });
		}

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int y = current[0];
			int x = current[1];
			count = 0;

			if (!visited[y][x]) {
				dfs(x, y);
			}

			max = count > max ? count : max;
		}
		bw.write(Integer.toString(max));
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dfs(int x, int y) {
		visited[y][x] = true;
		count++;

		max = count > max ? count : max;

		for (int i = 0; i < 4; ++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
				if (!visited[ny][nx]) {
					if (map[ny][nx] == 1) {
						dfs(nx, ny);
					}
				}
			}
		}
	}
}

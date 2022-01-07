package com.ssafy.Baekjoon._220107;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_1261_알고스팟 {
	public static int N, M;
	public static int[][] map;
	// 상하좌우
	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; ++i) {
			String tmp = br.readLine();
			for (int j = 0; j < M; ++j)
				map[i][j] = tmp.charAt(j) - '0';
		}

		if (M == 1 && N == 1)
			sb.append(0);
		else
			sb.append(bfs());
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static int bfs() {
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			};
		});
		int min = Integer.MAX_VALUE;
		boolean[][] visited = new boolean[N][M];

		visited[0][0] = true;
		queue.offer(new int[] { 0, 0, 0, 0 });

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];
			int cnt = cur[2];
			int wall = cur[3];

			for (int i = 0; i < 4; ++i) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx == M - 1 && ny == N - 1) {
					min = min > cnt ? cnt : min;
					return min;
				}

				if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
					if (!visited[ny][nx]) {
						if (map[ny][nx] == 1) {
							queue.offer(new int[] { nx, ny, cnt + 1, wall });
						} else {
							queue.offer(new int[] { nx, ny, cnt, wall });
						}
						visited[ny][nx] = true;
					}
				}
			}
		}

		return min;
	}
}
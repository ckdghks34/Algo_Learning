package com.ssafy.Baekjoon._220106;

import java.util.*;
import java.io.*;

public class Main_G4_2206_벽부수고이동하기 {

	public static int N, M;
	public static int[][] map;
	// 상하좌우
	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; ++i) {
			String tmp = br.readLine();
			for (int j = 0; j < M; ++j) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}
		int result = bfs();
		if (result == 1000 * 1000)
			sb.append(-1);
		else
			sb.append(result);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static int bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][][] visited = new boolean[2][N][M];
		int min = 1000 * 1000;
		// { x좌표,y좌표, 벽, 이동개수}
		queue.offer(new int[] { 0, 0, 1, 1 });
		visited[0][0][0] = true;
		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			int x = current[0];
			int y = current[1];
			int wall = current[2];
			int cnt = current[3];

			if (x == M - 1 && y == N - 1) {
				min = min > cnt ? cnt : min;
				continue;
			}

			for (int i = 0; i < 4; ++i) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
					if (map[ny][nx] == 1) {
						if (wall == 1 && !visited[0][ny][nx]) {
							visited[0][ny][nx] = true;
							queue.offer(new int[] { nx, ny, 0, cnt + 1 });
						}
					} else {
						if (wall == 1 && !visited[wall][ny][nx]) {
							visited[wall][ny][nx] = true;
							queue.offer(new int[] { nx, ny, wall, cnt + 1 });
						} else if (wall == 0 && !visited[wall][ny][nx]) {
							visited[wall][ny][nx] = true;
							queue.offer(new int[] { nx, ny, wall, cnt + 1 });
						}

					}
				}
			}
		}
		return min;
	}
}

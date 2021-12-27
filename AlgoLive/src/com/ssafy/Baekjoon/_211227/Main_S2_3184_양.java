package com.ssafy.Baekjoon._211227;

import java.util.*;
import java.io.*;

public class Main_S2_3184_양 {
	public static int R, C;
	public static int[][] map;
	public static boolean[][] visited;
	// 상 하 좌우
	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0, 0 };
	public static int totalLamp, totalWolf;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; ++i) {
			String tmp = br.readLine();
			for (int j = 0; j < C; ++j) {
				/*
				 * 양 : 1 늑대 : 2 울타리 : 3
				 */
				switch (tmp.charAt(j)) {
				case 'o':
					map[i][j] = 1;
					totalLamp++;
					break;
				case 'v':
					map[i][j] = 2;
					totalWolf++;
					break;
				case '#':
					map[i][j] = 3;
					break;
				}
			}
		}
		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < C; ++j) {
				if (map[i][j] == 1 && !visited[i][j]) {
					int[] tmp = bfs(i, j);
					totalLamp -= tmp[0];
					totalWolf -= tmp[1];
				}
			}
		}
		sb.append(totalLamp).append(" ").append(totalWolf);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static int[] bfs(int y, int x) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { y, x });
		int[] reData;

		int tmpLamp = 1;
		int tmpWolf = 0;
		visited[y][x] = true;
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			

			for (int i = 0; i < 4; ++i) {
				int nextx = current[1] + dx[i];
				int nexty = current[0] + dy[i];

				if (nextx >= 0 && nexty >= 0 && nextx < C && nexty < R) {
					if (map[nexty][nextx] != 3) {
						if (!visited[nexty][nextx]) {
							if (map[nexty][nextx] == 1) {
								tmpLamp++;
							} else if (map[nexty][nextx] == 2) {
								tmpWolf++;
							}
							queue.add(new int[] { nexty, nextx });
							visited[nexty][nextx] = true;
						}
					}
				}
			}
		}
		if (tmpLamp > tmpWolf)
			tmpLamp = 0;
		else
			tmpWolf = 0;

		reData = new int[] { tmpLamp, tmpWolf };

		return reData;
	}
}

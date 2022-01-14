package com.ssafy.Baekjoon._220114;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_3055_탈출 {
	public static int R, C, result;
	public static int[][] map;
	public static boolean[][] visited;
	public static Queue<int[]> hedgehog = new LinkedList<>();
	public static Queue<int[]> water = new LinkedList<>();
	// 상하 좌우
	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		result = 0;
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; ++i) {
			String stmp = br.readLine();

			for (int j = 0; j < C; ++j) {
				char tmp = stmp.charAt(j);

				switch (tmp) {
				case 'D':
					map[i][j] = 1;
					break;
				case '.':
					map[i][j] = 0;
					break;
				case '*':
					map[i][j] = -1;
					water.offer(new int[] { j, i });
					break;
				case 'S':
					map[i][j] = 2;
					hedgehog.offer(new int[] { j, i });
					break;
				default:
					map[i][j] = 3;
				}

			}
		}
		int cnt = 0;

		while (!hedgehog.isEmpty()) {
			cnt++;
			flowWater();
			bfs(cnt);
		}
		String tmp = result == 0 ? "KAKTUS" : Integer.toString(result);
		bw.write(tmp);
		bw.flush();
		bw.close();
		br.close();
	}

	public static void flowWater() {
		int cnt = water.size();
		for (int i = 0; cnt > 0; cnt--) {
			int[] current = water.poll();
			int curx = current[0];
			int cury = current[1];

			for (int j = 0; j < 4; ++j) {
				int nx = curx + dx[j];
				int ny = cury + dy[j];

				if (nx >= 0 && ny >= 0 && nx < C && ny < R) {
					if (map[ny][nx] == 0) {
						map[ny][nx] = -1;
						water.offer(new int[] { nx, ny });
					}
				}
			}
		}
	}

	public static void bfs(int move) {
		int cnt = hedgehog.size();

		for (int i = 0; cnt > 0; --cnt) {
			int[] current = hedgehog.poll();
			int curx = current[0];
			int cury = current[1];

			for (int j = 0; j < 4; ++j) {
				int nx = curx + dx[j];
				int ny = cury + dy[j];

				if (nx >= 0 && ny >= 0 && nx < C && ny < R) {
					if (map[ny][nx] == 1 || map[ny][nx] == 0) {
						if (map[ny][nx] == 1) {
							result = move;
							hedgehog.clear();
							return;
						}
						if (!visited[ny][nx]) {
							hedgehog.offer(new int[] { nx, ny });
							visited[ny][nx] = true;
						}
					}
				}
			}
		}
	}
}

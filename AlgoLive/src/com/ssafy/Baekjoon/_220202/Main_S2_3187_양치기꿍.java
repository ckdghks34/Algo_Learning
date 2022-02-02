package com.ssafy.Baekjoon._220202;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_3187_양치기꿍 {
	public static int R, C;
	public static int w = 0, l = 0;
	public static boolean[][] visited;
	public static char[][] map;
	public static Queue<int[]> wolf = new LinkedList<>();

	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; ++i) {
			String tmp = br.readLine();
			for (int j = 0; j < C; ++j) {
				map[i][j] = tmp.charAt(j);
				if (map[i][j] == 'v') {
					wolf.offer(new int[] { j, i });
					w++;
				} else if (map[i][j] == 'k')
					l++;
			}
		}
		while (!wolf.isEmpty()) {
			int[] curWolf = wolf.poll();
			int wolfx = curWolf[0];
			int wolfy = curWolf[1];

			if (!visited[wolfy][wolfx]) {
				check(wolfx, wolfy);
			}
		}
		sb.append(l).append(" ").append(w);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void check(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();

		queue.offer(new int[] { x, y });
		visited[y][x] = true;
		int wolfcnt = 1;
		int lampcnt = 0;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curx = cur[0];
			int cury = cur[1];

			for (int i = 0; i < 4; ++i) {
				int nx = curx + dx[i];
				int ny = cury + dy[i];

				if (nx >= 0 && ny >= 0 && nx < C && ny < R) {
					if (!visited[ny][nx]) {
						if (map[ny][nx] == '.') {
							queue.offer(new int[] { nx, ny });
						} else if (map[ny][nx] == 'v') {
							queue.offer(new int[] { nx, ny });
							wolfcnt++;
						} else if (map[ny][nx] == 'k') {
							queue.offer(new int[] { nx, ny });
							lampcnt++;
						}
						visited[ny][nx] = true;
					}
				}
			}
		}

		if (lampcnt > wolfcnt)
			w -= wolfcnt;
		else
			l -= lampcnt;
	}
}

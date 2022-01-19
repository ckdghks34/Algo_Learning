package com.ssafy.Baekjoon._220119;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_10282_해킹{
	static int H, W;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<int[]> list = new ArrayList<>();
	// 상하좌우
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		visited = new boolean[H][W];
		int min = Integer.MAX_VALUE / 2;

		for (int i = 0; i < H; ++i) {
			String str = br.readLine();
			for (int j = 0; j < W; ++j) {
				char tmp = str.charAt(j);

				switch (tmp) {
				case 'C':
					map[i][j] = 1;
					list.add(new int[] { j, i });
					break;
				case '*':
					map[i][j] = -1;
					break;
				}
			}
		}
		int[] start = list.get(0);
		min = dijkstra(start[0], start[1]);
		sb.append(min);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static int dijkstra(int x, int y) {
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		int[] end = list.get(1);
		int cnt = 0;
		queue.offer(new int[] { x, y, 0, -1 });
		visited[y][x] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int curx = current[0];
			int cury = current[1];
			int curcnt = current[2];
			int curDirection = current[3];

			if (curx == end[0] && cury == end[1]) {
				cnt = curcnt;
				return cnt;
			}

			for (int i = 0; i < 4; ++i) {
				int nx = curx + dx[i];
				int ny = cury + dy[i];

				if (nx >= 0 && ny >= 0 && nx < W && ny < H) {
					if (!visited[ny][nx]) {
						if (map[ny][nx] != -1) {
							if (curDirection != -1) {
								if (i != curDirection) {
									queue.offer(new int[] { nx, ny, curcnt + 1, i });
									visited[ny][nx] = true;
								} else {
									queue.offer(new int[] { nx, ny, curcnt, i });
									visited[ny][nx] = true;
								}
							} else {
								queue.offer(new int[] { nx, ny, curcnt, i });
								visited[ny][nx] = true;
							}
						}
					}

				}
			}
		}

		return cnt;
	}
}

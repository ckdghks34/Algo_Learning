package com.ssafy.Baekjoon._220118;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_3385_녹색입은애가젤다지 {

	static int T;
	static int[][] map;
	static final int INF = Integer.MAX_VALUE / 2;

	// 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		int n = 1;
		T = Integer.parseInt(br.readLine());
		while (T != 0) {
			map = new int[T][T];
			for (int i = 0; i < T; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < T; ++j)
					map[i][j] = Integer.parseInt(st.nextToken());
			}

			sb.append("Problem ").append(n++).append(": ").append(bfs()).append("\n");
			T = Integer.parseInt(br.readLine());
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static int bfs() {
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		boolean[][] visited = new boolean[T][T];
		queue.offer(new int[] { 0, 0, map[0][0] });
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			int x = current[0];
			int y = current[1];
			int cnt = current[2];

			if (x == T - 1 && y == T - 1) {
				return cnt;
			}

			for (int i = 0; i < 4; ++i) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < T && ny < T) {
					if (!visited[ny][nx]) {
						queue.offer(new int[] { nx, ny, cnt + map[ny][nx] });
						visited[ny][nx] = true;
					}
				}
			}
		}
		return 0;
	}
}

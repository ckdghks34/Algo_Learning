package com.ssafy.Baekjoon._220117;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_G4_2665_미로만들기 {

	static int N;
	static int[][] map;
	static boolean[][][] visited;

	// 상하좌우
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		visited = new boolean[2][N + 1][N + 1];

		for (int i = 1; i <= N; ++i) {
			String tmp = br.readLine();
			for (int j = 1; j <= N; ++j) {
				map[i][j] = tmp.charAt(j - 1) - '0';
			}
		}

		bw.write(Integer.toString(bfs()));
		bw.flush();
		bw.close();
		br.close();

	}

	public static int bfs() {
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		queue.offer(new int[] { 1, 1, 0 });
		visited[0][1][1] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0];
			int y = current[1];
			int cnt = current[2];

			if (x == N && y == N)
				return cnt;

			for (int i = 0; i < 4; ++i) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx > 0 && ny > 0 && nx <= N && ny <= N) {
					if (!visited[0][ny][nx]) {
						if (map[ny][nx] == 1) {
							queue.offer(new int[] { nx, ny, cnt });
							visited[0][ny][nx] = true;
						} else {
							queue.offer(new int[] { nx, ny, cnt + 1 });
							visited[0][ny][nx] = true;
						}
					}
				}
			}
		}

		return 0;
	}
}

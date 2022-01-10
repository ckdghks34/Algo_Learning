package com.ssafy.Baekjoon._220110;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_1600_원숭이 {
	static int K, W, H;
	static int[][] map;
	// 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	// 1시, 2시, 4시, 5시, 7시, 8시, 10시, 11시
	static int[] hdx = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] hdy = { -2, -1, 1, 2, 2, 1, -1, -2 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];

		for (int i = 0; i < H; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bw.write(Integer.toString(bfs()));
		bw.flush();
		bw.close();
		br.close();
	}

	static int bfs() {
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[3] - o2[3];
			}
		});

		boolean[][][] visited = new boolean[K + 1][H][W];
		queue.offer(new int[] { 0, 0, K, 0 });
		visited[K][0][0] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];
			int k = cur[2];
			int cnt = cur[3];

			if (x == W - 1 && y == H - 1)
				return cnt;

			if (k > 0) {
				for (int i = 0; i < 8; ++i) {
					int nx = x + hdx[i];
					int ny = y + hdy[i];

					if (checkInMap(nx, ny)) {
						if (!visited[k-1][ny][nx] && map[ny][nx] == 0) {
							queue.offer(new int[] { nx, ny, k - 1, cnt + 1 });
							visited[k-1][ny][nx] = true;
						}
					}
				}
			}

			for (int i = 0; i < 4; ++i) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (checkInMap(nx, ny)) {
					if (!visited[k][ny][nx]&& map[ny][nx] == 0) {
						queue.offer(new int[] { nx, ny, k, cnt + 1 });
						visited[k][ny][nx] = true;
					}
				}
			}
		}
		return -1;

	}

	static boolean checkInMap(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < W && ny < H;
	}
}

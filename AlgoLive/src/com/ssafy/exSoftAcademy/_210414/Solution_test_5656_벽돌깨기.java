package com.ssafy.exSoftAcademy._210414;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_test_5656_벽돌깨기 {
	static int T, N, W, H;
	static int[][] map;
	static int res;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static boolean[][] isVisited;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./res/ES_input_TEST_5656.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			st = new StringTokenizer(br.readLine(), " ");
			sb = new StringBuilder();

			sb.append("#").append(tc).append(" ");

			res = Integer.MAX_VALUE;
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new int[H][W];

			for (int i = 0; i < H; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			process(0);
			sb.append(res != Integer.MAX_VALUE ? res : 0);

			System.out.println(sb.toString());
		}

	}

	private static void process(int count) {

		if (count == N) {
			// 남은 벽돌 세기
			int result = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] > 0)
						result++;
				}
			}
			if (res > result)
				res = result;
			return;
		}

		int[][] newMap = new int[H][W];
		copy(newMap);

		for (int j = 0; j < W; j++) {
			for (int i = 0; i < H; i++) {
				if (map[i][j] > 0) {
					down(i, j);
					move();
					process(count + 1);
					copy(map, newMap);
					break;
				}
			}
		}
	}

	private static void down(int x, int y) {
		isVisited = new boolean[H][W];
		Queue<int[]> queue = new LinkedList<int[]>();
		isVisited[x][y] = true;
		queue.offer(new int[] { x, y });

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int val = map[current[0]][current[1]] - 1;
			map[current[0]][current[1]] = 0;
			if (val > 0) {
				for (int i = 0; i < 4; i++) {
					for (int c = 1; c <= val; c++) {
						int nx = current[0] + dx[i] * c;
						int ny = current[1] + dy[i] * c;

						if (nx < 0 || ny < 0 || nx >= H || ny >= W || map[nx][ny] == 0 || isVisited[nx][ny] == true)
							continue;
						isVisited[nx][ny] = true;
						queue.offer(new int[] { nx, ny });
					}
				}
			}
		}
	}

	private static void move() {
		for (int j = 0; j < W; j++) {
			Queue<Integer> queue = new LinkedList<Integer>();

			for (int i = H - 1; i >= 0; i--) {
				if (map[i][j] > 0) {
					queue.offer(map[i][j]);
					map[i][j] = 0;
				}
			}
			int i = H - 1;

			while (!queue.isEmpty()) {
				map[i][j] = queue.poll();
				i--;
			}
		}
	}

	private static void copy(int[][] copymap) {
		for (int i = 0; i < H; ++i) {
			for (int j = 0; j < W; ++j) {
				copymap[i][j] = map[i][j];
			}
		}
	}

	private static void copy(int[][] copymap, int[][] copymap2) {
		for (int i = 0; i < H; ++i) {
			for (int j = 0; j < W; ++j) {
				copymap[i][j] = copymap2[i][j];
			}
		}
	}
}

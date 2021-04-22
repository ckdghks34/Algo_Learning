package com.ssafy.exSoftAcademy._210422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_D4_1868_파핑파핑지뢰찾기 {
	static int N, count;
	static int[][] map;
	static boolean[][] isVisisted;

	static Queue<int[]> zero_queue = new LinkedList<int[]>();
	static Queue<int[]> other_queue = new LinkedList<int[]>();

	// 상 상우 우 하우 하 하좌 좌 상좌
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");

			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			count = 0;

			isVisisted = new boolean[N][N];

			for (int i = 0; i < N; ++i) {
				String str = br.readLine();
				for (int j = 0; j < N; ++j) {
					char c = str.charAt(j);
					if (c == '*') // 지뢰면 -1로 넣음
						map[i][j] = -1;
					else {
						map[i][j] = 0;
					}
				}
			}

			// 주변 지뢰 갯수 파악
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j)
					if (map[i][j] != -1)
						checkmine(j, i);
			}

			while (!zero_queue.isEmpty()) {
				int[] location = zero_queue.poll();

				if (!isVisisted[location[1]][location[0]]) {
					press(location[0], location[1]);
					count++;
				}
			}
			while (!other_queue.isEmpty()) {
				int[] location = other_queue.poll();

				if (!isVisisted[location[1]][location[0]]) {
					press(location[0], location[1]);
					count++;
				}
			}

			sb.append(count);
			System.out.println(sb.toString());
		}
	}

	public static void checkmine(int x, int y) {
		int mine = 0;

		for (int d = 0; d < 8; ++d) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (0 <= nx && nx < N && 0 <= ny && ny < N) {
				if (map[ny][nx] == -1)
					mine++;
			}
		}

		if (mine == 0)
			zero_queue.offer(new int[] { x, y });
		else
			other_queue.offer(new int[] { x, y });

		map[y][x] = mine;
	}

	public static void press(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();

		queue.offer(new int[] { x, y });
		isVisisted[y][x] = true;

		if (map[y][x] == 0) {
			while (!queue.isEmpty()) {
				int[] current = queue.poll();

				for (int d = 0; d < 8; ++d) {
					int nx = current[0] + dx[d];
					int ny = current[1] + dy[d];

					if (0 <= nx && nx < N && 0 <= ny && ny < N) {
						if (!isVisisted[ny][nx] && map[ny][nx] != -1) {
							isVisisted[ny][nx] = true;

							if (map[ny][nx] == 0)
								queue.offer(new int[] { nx, ny });
						}
					}
				}
			}
		}
	}
}

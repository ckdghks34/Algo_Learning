package com.ssafy.exSoftAcademy._210412;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_d4_1249_보급로 {

	static int[][] map;
	static int[][] result;
	static boolean[][] check;
	static int N, min;

	// 상, 우, 하, 좌
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("./res/ES_input_d4_1249.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");

			min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			result = new int[N][N];
			check = new boolean[N][N];

			for (int i = 0; i < N; ++i) {
				String tmp = br.readLine();
				for (int j = 0; j < N; ++j) {
					map[i][j] = tmp.charAt(j) - '0';
				}
			}

			for (int i = 0; i < N; ++i)
				for (int j = 0; j < N; ++j)
					result[i][j] = Integer.MAX_VALUE;

			bfs(0, 0);
			sb.append(result[N - 1][N - 1]);
//			dfs(0, 0, 0);
//			sb.append(min);

			System.out.println(sb.toString());
		}
	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		result[y][x] = 0;
		check[y][x] = true;
		queue.add(new int[] { x, y });

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			for (int d = 0; d < 4; ++d) {
				int nx = current[0] + dx[d];
				int ny = current[1] + dy[d];

				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					if (!check[ny][nx] || result[ny][nx] > map[ny][nx] + result[current[1]][current[0]]) {
						check[ny][nx] = true;
						result[ny][nx] = map[ny][nx] + result[current[1]][current[0]];
						queue.offer(new int[] { nx, ny });
					}
				}
			}
		}
	}
}

// testcase 4개만 정답 나머지 값 안나옴
// 다시 풀어볼 것

/*
 private static void dfs(int x, int y, int sum) {
	check[y][x] = true;
	sum += map[y][x];

	for (int d = 0; d < 4; ++d) {
		int nx = x + dx[d];
		int ny = y + dy[d];

		if (0 <= nx && nx < N && 0 <= ny && ny < N) {
			if (x == N - 1 && y == N - 1) {
				min = Math.min(min, sum);
				continue;
			}
			if (sum + map[ny][nx] > min)
				continue;

			if (!check[ny][nx])
				dfs(nx, ny, sum);
		}
	}
	check[y][x] = false;
}
 */

package com.ssafy.exSoftAcademy._210415;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Soultion_TEST_1953_탈주범검거 {

	static int[][] map;
	static int N, M, R, C, hour, result;
	static boolean[][] isVisited;
	// 상하좌우
	static int[][] dx = { { 0, 0, -1, 1 }, // 1 : 상하좌우
			{ 0, 0, 0, 0 }, // 2 : 상하
			{ 0, 0, -1, 1 }, // 3 : 좌우
			{ 0, 0, 0, 1 }, // 4 : 상우
			{ 0, 0, 0, 1 }, // 5 : 하우
			{ 0, 0, -1, 0 }, // 6 : 하좌
			{ 0, 0, -1, 0 } }; // 7 : 상좌
	static int[][] dy = { { -1, 1, 0, 0 }, // 1 : 상하좌우
			{ -1, 1, 0, 0 }, // 2 : 상하
			{ 0, 0, 0, 0 }, // 3 : 좌우
			{ -1, 0, 0, 0 }, // 4 : 상우
			{ 0, 1, 0, 0 }, // 5 : 하우
			{ 0, 1, 0, 0 }, // 6 : 하좌
			{ -1, 0, 0, 0 } };// 7 : 상좌

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("./res/ES_input_TEST_1953.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			hour = Integer.parseInt(st.nextToken());
			result = 0;

			map = new int[N][M];
			isVisited = new boolean[N][M];

			// 입력
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken()) - 1;
				}
			}
			move(C, R);
			sb.append(result);

			System.out.println(sb.toString());
		}
	}

	private static void move(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { x, y, 1 });
		isVisited[y][x] = true;
		result++;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int curX = current[0];
			int curY = current[1];
			int curC = current[2];

			if (curC == hour)
				continue;

			for (int d = 0; d < 4; ++d) {

				if (dx[map[curY][curX]][d] == 0 && dy[map[curY][curX]][d] == 0)
					continue;

				int nx = curX + dx[map[curY][curX]][d];
				int ny = curY + dy[map[curY][curX]][d];

				if (0 <= nx && nx < M && 0 <= ny && ny < N) {
					// 파이프가 없을때
					if (map[ny][nx] == -1)
						continue;

					// 방문하지않았고, 연결 가능하다면
					if (!isVisited[ny][nx] && connect(d, nx, ny)) {
						isVisited[ny][nx] = true;
						queue.offer(new int[] { nx, ny, curC + 1 });
						result++;
					}

				}

			}
		}

	}

	private static boolean connect(int d, int x, int y) {
		int next = map[y][x] + 1;
		switch (d) {
		// 상
		case 0:
			switch (next) {
			case 1:
			case 2:
			case 5:
			case 6:
				return true;
			}
			break;
		// 하
		case 1:
			switch (next) {
			case 1:
			case 2:
			case 4:
			case 7:
				return true;
			}
			break;
		// 좌
		case 2:
			switch (next) {
			case 1:
			case 3:
			case 4:
			case 5:
				return true;
			}
			break;
		// 우
		case 3:
			switch (next) {
			case 1:
			case 3:
			case 6:
			case 7:
				return true;
			}
			break;
		}

		return false;
	}
}

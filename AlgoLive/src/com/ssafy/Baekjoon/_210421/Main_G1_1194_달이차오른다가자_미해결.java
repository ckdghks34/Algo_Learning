package com.ssafy.Baekjoon._210421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G1_1194_달이차오른다가자_미해결 {
	static int N, M, result;
	static char[][] map;

	static boolean[] key = new boolean[6];
	static boolean[] door = new boolean[6];

	// 상하좌우
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		int[] current = new int[2];

		for (int i = 0; i < N; ++i) {
			String s = br.readLine();
			for (int j = 0; j < M; ++j) {
				map[i][j] = s.charAt(j);

				if (map[i][j] == '0') {
					current[0] = j;
					current[1] = i;
				}
			}
		}

		bfs(current[0], current[1]);

		if (result == 0)
			System.out.println("-1");
		else
			System.out.println(result);
	}

	public static void bfs(int x, int y) {
		char[][] newMap = new char[N][M];

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				newMap[i][j] = map[i][j];
			}
		}

		Queue<int[][]> queue = new LinkedList<>();

		queue.offer(new int[][] { { x, y, 0 }, { 0, 0, 0, 0, 0, 0 } });
		newMap[y][x] = '.';
		while (!queue.isEmpty()) {
			int[][] current = queue.poll();
			int curX = current[0][0];
			int curY = current[0][1];
			int curV = current[0][2];
			int[] curkey = current[1];

			for (int d = 0; d < 4; ++d) {
				int nx = curX + dx[d];
				int ny = curY + dy[d];

				if (0 <= nx && nx < M && 0 <= ny && ny < N) {
					if (newMap[ny][nx] == '1') {
						result = curV + 1;
						return;
					}

					if (newMap[ny][nx] == '#')
						continue;

					else if (newMap[ny][nx] == '.') {
						queue.offer(new int[][] { { nx, ny, curV + 1 }, curkey });

					} else if (65 <= newMap[ny][nx] && newMap[ny][nx] <= 46) { // door

						if (curkey[newMap[ny][nx] - 'A'] == 1) { // 열쇠가 있으면
							queue.offer(new int[][] { { nx, ny, curV + 1 }, curkey });
						} else // 열쇠가 없으면
							continue;
					} else if (97 <= newMap[ny][nx] && newMap[ny][nx] <= 102) { // key
						
						if(curkey[newMap[ny][nx] - 'a'] == 1)
							continue;
						curkey[newMap[ny][nx] - 'a'] = 1;
						queue.offer(new int[][] { { nx, ny, curV + 1 }, curkey });
					}
				}
			}
		}
	}
}

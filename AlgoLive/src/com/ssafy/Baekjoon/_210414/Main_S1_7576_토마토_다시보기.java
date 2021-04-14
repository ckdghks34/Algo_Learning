package com.ssafy.Baekjoon._210414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_7576_토마토_다시보기 {
	static int N, M;
	static int map[][];
	static int result;
	static int count;
	static int mCount;
	// 상 우 하 좌
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static Queue<int[]> queue = new ArrayDeque<int[]>();

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		boolean check = false;

		map = new int[N][M];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (!check && map[i][j] == 0)
					check = true;
				if (map[i][j] == 1) {
					queue.offer(new int[] { j, i, 0 });
					count++;
				} else if (map[i][j] == -1)
					mCount++;
			}
		}

		if (!check) {
			System.out.println("0");
			return;
		}
		bfs();

		System.out.println(count == (N * M) - mCount ? result : -1);
	}

	private static void bfs() {
		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			for (int d = 0; d < 4; ++d) {
				int nx = current[0] + dx[d];
				int ny = current[1] + dy[d];

				if (0 <= nx && nx < M && 0 <= ny && ny < N) {
					if (map[ny][nx] == 0) {
						map[ny][nx] = 1;
						queue.offer(new int[] { nx, ny, current[2] + 1 });
						count++;
					}
				}
			}
			result = Math.max(current[2], result);
		}
	}
}

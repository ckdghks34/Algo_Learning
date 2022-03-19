package com.ssafy.codingTest.SK_1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Main_2 {

	public static void main(String[] args) {
		int n = 9;
		boolean clockwise = false;
		System.out.println(Arrays.deepToString(solution(n, clockwise)));
	}

	public static int[][] solution(int n, boolean clockwise) {
		int[][] answer = new int[n][n];
		drawMap(clockwise, n, answer);

		return answer;
	}

	public static void drawMap(boolean clock, int n, int[][] map) {
		// 북, 동, 남, 서
		int[][] clock_dir = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
		// 남 동 북 서
		int[][] nclock_dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		boolean[][] check = new boolean[n][n];
		if (clock) {
			pq.offer(new int[] { 0, 0, 2, 1 });
			pq.offer(new int[] { 0, n - 1, 2, 0 });
			pq.offer(new int[] { n - 1, 0, 2, 2 });
			pq.offer(new int[] { n - 1, n - 1, 2, 3 });
		} else {
			pq.offer(new int[] { 0, 0, 2, 0 });
			pq.offer(new int[] { 0, n - 1, 2, 1 });
			pq.offer(new int[] { n - 1, 0, 2, 3 });
			pq.offer(new int[] { n - 1, n - 1, 2, 2 });
		}
		check[0][0] = true;
		check[0][n - 1] = true;
		check[n - 1][0] = true;
		check[n - 1][n - 1] = true;

		map[0][0] = 1;
		map[0][n - 1] = 1;
		map[n - 1][0] = 1;
		map[n - 1][n - 1] = 1;

		int count = 4; // 칸 수
		while (!pq.isEmpty() && count < n * n) {
			int[] cur = pq.poll();
			int x = cur[0];
			int y = cur[1];
			int cnt = cur[2];
			int dir_idx = cur[3];

			int nx = 0;
			int ny = 0;
			if (clock) {
				nx = x + clock_dir[dir_idx][0];
				ny = y + clock_dir[dir_idx][1];
			} else {
				nx = x + nclock_dir[dir_idx][0];
				ny = y + nclock_dir[dir_idx][1];
			}

			if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
				if (!check[ny][nx]) {
					check[ny][nx] = true;
					map[ny][nx] = cnt;
					pq.offer(new int[] { nx, ny, cnt + 1, dir_idx });
					count++;
				} else {
					pq.offer(new int[] { x, y, cnt, (dir_idx + 1) % 4 });
				}

			}
		}
	}

}

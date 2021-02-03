package com.ssafy.exSoftAcademy._210203;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_d3_2805_농작물수확하기_구미_4_허창환_BFS {
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static int N, m, sum;
	static int[][] map;
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/ES_input_d3_2805.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; ++tc) {
			N = sc.nextInt();
			m = (N - 1) / 2;
			map = new int[N][N];
			visit = new boolean[N][N];

			for (int i = 0; i < N; ++i) {
				String s = sc.next();
				for (int j = 0; j < N; ++j)
					map[i][j] = s.charAt(j) - '0';
			}
			sum = 0;
			bfs(m, m);
			System.out.println("#" + tc + " " + sum);
		}
		sc.close();
	}

	static void bfs(int i, int j) {
		{
			Queue<int[]> q = new LinkedList<int[]>();
			visit[i][j] = true;
			sum += map[i][j];
			q.offer(new int[] { i, j });
			while (!q.isEmpty()) {
				int[] curr = q.poll();
				for (int d = 0; d < 4; d++) {
					int ni = curr[0] + di[d];
					int nj = curr[1] + dj[d];

					if (0 <= ni && ni < N && 0 <= nj && nj < N && !visit[ni][nj]) {
						visit[ni][nj] = true;
						q.offer(new int[] { ni, nj });
						sum += map[ni][nj];
					}
				}
			}
		}
	}
}

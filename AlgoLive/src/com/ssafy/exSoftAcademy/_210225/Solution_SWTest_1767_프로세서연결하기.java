package com.ssafy.exSoftAcademy._210225;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_SWTest_1767_프로세서연결하기 {

	static int T, N;
	static int[][] map;
	static boolean[][] isConnected;
	static List<Core> core;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			N = Integer.parseInt(br.readLine());
			core = new ArrayList<Core>();
			map = new int[N][N];
			isConnected = new boolean[N][N];

			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());

					if (map[i][j] == 1) {
						isConnected[i][j] = true;
						core.add(new Core(j, i));
					}
				}
			}
		}

	}

	public static void dfs(int x, int y, int d, int sum) {
		if (y == 0 || x == 0) {

			return;
		}
		
		
		int moveX = x + dx[d];
		int moveY = y + dy[d];

		if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < N) {
			if (isConnected[moveY][moveX])
				return;
		}

	}

	public static class Core {
		int x;
		int y;

		public Core(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

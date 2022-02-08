package com.ssafy.Baekjoon._220208;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_G5_9663_NQueen {
	public static int N, count;
	public static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		count = 0;

		for (int i = 0; i < N; ++i) {
			map = new int[N][N];
			map[0][i] = 1;
			Queen_put(1);
		}

		bw.write(Integer.toString(count));
		bw.flush();
		bw.close();
		br.close();
	}

	public static void Queen_put(int cnt) {
		if (cnt == N) {
			count++;
			return;
		}
		
		for (int i = 0; i < N; ++i) {
//			if(cnt == 0)
//				map = new int[N][N];
			if (dfs(i, cnt)) {
				map[cnt][i] = 1;
				Queen_put(cnt + 1);
				map[cnt][i] = 0;
			}
		}
	}

	public static boolean dfs(int x, int y) {

		// 현재 퀸을 놓은 위치 기준으로 ↑(상단)방향으로 탐색하며 이미 퀸이 놓여져있으면 놓지 못함.
		for (int i = 0; i < y; ++i) {
			if (map[i][x] == 1)
				return false;
		}

		int ny = y - 1;
		int nx = x - 1;
		while (ny >= 0 && nx >= 0) {
			if (map[ny][nx] == 1)
				return false;
			ny--;
			nx--;
		}

		ny = y - 1;
		nx = x + 1;

		while (ny >= 0 && nx < N) {
			if (map[ny][nx] == 1)
				return false;
			ny--;
			nx++;
		}

		return true;
	}
}

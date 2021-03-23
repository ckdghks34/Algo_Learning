package com.ssafy.Jungol._210322;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_1681_해밀턴순환회로 {

	static int N;
	static int[][] map;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		visited = new boolean[N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		move(0, 0, 0);
		System.out.println(min);
	}

	public static void move(int start, int sum, int idx) {

		// 이미 sum이 min보다 크면 종료
		if (sum > min) {
			return;
		}

		if (idx == N - 1) {
			if(map[start][0] == 0)
				return;
			min = Math.min(min, sum + map[start][0]);
			return;
		}

		visited[start] = true;

		for (int i = 0; i < N; ++i) {
			if (!visited[i] && map[start][i] != 0) {
				move(i, sum + map[start][i], idx + 1);
			}
		}
		visited[start] = false;
	}
}

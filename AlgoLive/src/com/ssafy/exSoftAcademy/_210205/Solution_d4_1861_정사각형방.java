package com.ssafy.exSoftAcademy._210205;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d4_1861_정사각형방 {
	static int map[][];
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int N = 0;
	static int max = 0;
	static int s = 0;

	static void dfs(int x, int y, int c, int a) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if ((nx >= 0 && nx < N) && (ny >= 0 && ny < N)) {
				if (map[x][y] + 1 == map[nx][ny]) {
					dfs(nx, ny, ++c, a);
				}
			}
		}

		if (max == c && s > a)
				s = a;
		if (max < c) {
			max = c;
			s = a;
		}
	}

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/ES_input_d4_1861.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			s = map[0][0];
			max = 0;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}


			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(i, j, 1, map[i][j]);
				}
			}
		
			System.out.println("#" + tc + " " + s + " " + max);
		}
		br.close();
	}
}

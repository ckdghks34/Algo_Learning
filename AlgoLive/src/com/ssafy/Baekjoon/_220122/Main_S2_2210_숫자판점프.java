package com.ssafy.Baekjoon._220122;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_S2_2210_숫자판점프 {
	public static int[][] map = new int[5][5];
	public static int N = 5;
	// 상 하 좌 우
	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0, 0 };

	public static ArrayList<String> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 5; ++j) {
				dfs(j, i, 0, "");
			}
		}

		bw.write(Integer.toString(list.size()));
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dfs(int x, int y, int cnt, String str) {
		if (cnt == 6) {
			boolean check = false;

			for (int i = 0; i < list.size(); ++i) {
				if (list.get(i).equals(str)) {
					check = true;
					break;
				}
			}
			
			if (!check)
				list.add(str);

			return;
		}

		for (int i = 0; i < 4; ++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
				String tmp = str + map[ny][nx];

				dfs(nx, ny, cnt + 1, tmp);
			}
		}
	}
}

package com.ssafy.Baekjoon._210421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_15683_감시_미해결 {

	static int N, M, total;
	static int[][] map;
	static List<int[]> list = new ArrayList<int[]>();
	// 상하좌우
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int[][][] dir = { {}, { { 0 }, { 1 }, { 2 }, { 3 } }, // 1일때
			{ { 0, 1 }, { 2, 3 } }, // 2일때
			{ { 0, 2 }, { 1, 2 }, { 1, 3 }, { 3, 0 } }, // 3일때
			{ { 0, 1, 2 }, { 1, 2, 3 }, { 0, 2, 3 }, { 0, 1, 3 } }, // 4일때
			{ { 0, 1, 2, 3 } } };

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (0 < map[i][j] && map[i][j] < 6)
					list.add(new int[] { j, i });
				if (0 == map[i][j])
					total++;
			}
		}

		int res = 0;
		for (int i = 0, size = list.size(); i < size; ++i) {
			int tmp = Integer.MIN_VALUE;
			int x = list.get(i)[0];
			int y = list.get(i)[1];
			int v = map[y][x];

			int tmp2 = 0;
			for (int j = 0, size2 = dir[v].length; j < size2; ++j) {
				int tmp3 = 0;
				for (int k = 0, size3 = dir[v][j].length; k < size3; ++k)
					tmp3 += watch(x, y, dir[v][j][k], 0);

				tmp2 = Math.max(tmp2, tmp3);
			}
			res += tmp2;
		}

		System.out.println(total - res);

	}

	public static int watch(int x, int y, int d, int count) {
		int nx = x + dx[d];
		int ny = y + dy[d];

		if (0 <= nx && nx < M && 0 <= ny && ny < N) {
			if (map[ny][nx] == 6)
				return count;
			else if (map[ny][nx] == 0) {
				count = watch(nx, ny, d, count + 1);
			} else
				count = watch(nx, ny, d, count);
		}

		return count;
	}
}

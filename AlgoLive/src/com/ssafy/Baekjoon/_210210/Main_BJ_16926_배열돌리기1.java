package com.ssafy.Baekjoon._210210;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BJ_16926_배열돌리기1 {
	static int N, M, R;
	static int[][] map;
	// 하,우,상,좌
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { +1, 0, -1, 0 };

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		// 입력
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; ++j)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		
		for (int k = 0; k < R; ++k) {
			int[][] tmp = new int[N][M];
			// N,M 중 작은 값에 / 2 한 만큼 돌린다.
			for (int n = 0; n < Math.min(N, M) / 2; ++n) {
				int x = n, y = n;
				int d = 0;

				while (d < 4) {
					int nx = x + dx[d];
					int ny = y + dy[d];

					if (nx < M - n && nx >= n && ny < N - n && ny >= n) {
						tmp[ny][nx] = map[y][x];
						x = nx;
						y = ny;
					} else
						d++;
				}
			}
			map = tmp;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}

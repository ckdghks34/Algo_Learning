package com.ssafy.Baekjoon._210210;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BJ_17406_배열돌리기4 {
	static int N, M, K;
	static int[][] map;
	// 우, 하, 좌, 상
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int min = Integer.MAX_VALUE;
	static int[][] info;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		info = new int[K][3];
		for (int row = 1; row <= N; ++row) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int col = 1; col <= M; ++col) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		for (int t = 0; t < K; ++t) {
			st = new StringTokenizer(br.readLine(), " ");
			info[t][0] = Integer.parseInt(st.nextToken());
			info[t][1] = Integer.parseInt(st.nextToken());
			info[t][2] = Integer.parseInt(st.nextToken());

		}
		lotation(map, 0,false);
		lotation(map, K-1,true);
		bw.write(Integer.toString(min));
		bw.flush();

		br.close();
		bw.close();
	}

	static void lotation(int[][] arr, int c,boolean reverse) {
		int[][] tmp = new int[N + 1][M + 1];

		for (int i = 0; i < arr.length; ++i) {
			System.arraycopy(arr[i], 0, tmp[i], 0, arr[0].length);
		}

		int startrow = (info[c][0] - info[c][2]);
		int startcol = (info[c][1] - info[c][2]);
		int lastrow = (info[c][0] + info[c][2]);
		int lastcol = (info[c][1] + info[c][2]);
		int rowlength = lastrow - startrow;
		int collength = lastcol - startcol;

		// 회전
		for (int n = 0; n < Math.min(rowlength, collength) / 2; ++n) {
			int x = startcol, y = startrow;
			int d = 0;

			while (d < 4) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx >= startcol && nx <= lastcol && ny >= startrow && ny <= lastrow) {
					tmp[ny][nx] = arr[y][x];
					x = nx;
					y = ny;
				} else
					d++;
			}
			startrow += 1;
			lastrow -= 1;
			startcol += 1;
			lastcol -= 1;
		}
		
		if(reverse)
		{
			if(c > 0)
				lotation(tmp, c-1, reverse);
		}
		else{
			if (c < K-1) 
				lotation(tmp, c + 1,false);
		}
		checkMin(tmp);
	}

	/*
	 * static void lotation() { int[][] tmp = new int[N + 1][M + 1];
	 * 
	 * for (int i = 0; i < map.length; ++i) { System.arraycopy(map[i], 0, tmp[i], 0,
	 * map[0].length); }
	 * 
	 * for (int k = 0; k < K; ++k) { int startrow = (info[k][0] - info[k][2]); int
	 * startcol = (info[k][1] - info[k][2]); int lastrow = (info[k][0] +
	 * info[k][2]); int lastcol = (info[k][1] + info[k][2]); int rowlength = lastrow
	 * - startrow; int collength = lastcol - startcol;
	 * 
	 * // 회전 for (int n = 0; n < Math.min(rowlength, collength) / 2; ++n) { int x =
	 * startcol, y = startrow; int d = 0;
	 * 
	 * while (d < 4) { int nx = x + dx[d]; int ny = y + dy[d];
	 * 
	 * if (nx >= startcol && nx <= lastcol && ny >= startrow && ny <= lastrow) {
	 * tmp[ny][nx] = map[y][x]; x = nx; y = ny; } else d++; } startrow += 1; lastrow
	 * -= 1; startcol += 1; lastcol -= 1; } } checkMin(); }
	 */
	static void checkMin(int[][] arr) {
		int sum;
		for (int row = 1; row <= N; ++row) {
			sum = 0;
			for (int col = 1; col <= M; ++col)
				sum += arr[row][col];

			min = Math.min(min, sum);
		}
	}
}

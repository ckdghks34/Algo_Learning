package com.ssafy.Baekjoon._220209;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_2580_스도쿠_2차코드 {

	public static int[][] map;
	public static final int mapSize = 9;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		map = new int[mapSize][mapSize];

		for (int i = 0; i < mapSize; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < mapSize; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		put_Sdoku(0, 0);

		br.close();
	}

	public static void put_Sdoku(int x, int y) throws Exception {
		if (y == 9) {
			put_Sdoku(x + 1, 0);
			return;
		}

		if (x == 9) {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < mapSize; ++i) {
				for (int j = 0; j < mapSize; ++j) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			bw.write(sb.toString());
			bw.flush();
			bw.close();
			System.exit(0);
		}
		if (map[y][x] == 0) {
			for (int i = 0; i <= mapSize; ++i) {
				if (check_square(x, y, i) && check_row(y, i) && check_col(x, i)) {
					map[y][x] = i;
					put_Sdoku(x, y + 1);
					
				}
			}
			map[y][x] = 0;
			return;
		}
		put_Sdoku(x, y+1);
	}

	public static boolean check_square(int x, int y, int value) {
		int startx = 3 * (x / 3);
		int starty = 3 * (y / 3);
		int endx = startx + 3;
		int endy = starty + 3;

		for (int i = starty; i < endy; ++i) {
			for (int j = startx; j < endx; ++j) {
				if (map[i][j] == value)
					return false;
			}
		}
		return true;
	}

	public static boolean check_col(int x, int value) {
		for (int i = 0; i < mapSize; ++i) {
			if (map[i][x] == value)
				return false;
		}

		return true;
	}

	public static boolean check_row(int y, int value) {
		for (int i = 0; i < mapSize; ++i) {
			if (map[y][i] == value)
				return false;
		}
		return true;
	}
}

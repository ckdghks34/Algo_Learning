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

public class Main_G4_2580_스도쿠_1차코드 {

	public static int[][] map;
	public static int count;
	public static final int mapSize = 9;
	public static Queue<int[]> queue = new LinkedList<int[]>();
	public static ArrayList<int[]> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		map = new int[mapSize][mapSize];

		for (int i = 0; i < mapSize; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < mapSize; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
//					queue.offer(new int[] { j, i });
					list.add(new int[] { j, i });
			}
		}
//		count = queue.size();
		count = list.size();

		put_Sdoku(0);

		for (int i = 0; i < mapSize; ++i) {
			for (int j = 0; j < mapSize; ++j) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static boolean put_Sdoku(int cnt) {
		if (cnt == count)
			return true;

		int x = list.get(cnt)[0];
		int y = list.get(cnt)[1];

		for (int i = 1; i <= mapSize; ++i) {
			if (check_col(x, i) && check_row(y, i) && check_square(x, y, i)) {
				map[y][x] = i;
				if (put_Sdoku(cnt + 1))
					return true;
				map[y][x] = 0;
			}
		}

//		int[] cur = queue.poll();
//		int x = cur[0];
//		int y = cur[1];
//
//		for (int i = 1; i <= mapSize; ++i) {
//			if (check_col(x, i) && check_row(y, i) && check_square(x, y, i)) {
//				map[y][x] = i;
//				if (put_Sdoku(cnt + 1))
//					return true;
//				map[y][x] = 0;
//			}
//		}
		return false;
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

package com.ssafy.Baekjoon._220221;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_S2_1780_종이의개수 {
	public static int N;
	public static int[][] data;
	public static int positive, zero, negative;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		data = new int[N][N];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j)
				data[i][j] = Integer.parseInt(st.nextToken());
		}
		divide(0, 0, N);

		sb.append(negative).append("\n");
		sb.append(zero).append("\n");
		sb.append(positive).append("\n");

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void divide(int x, int y, int size) {

		if (check(x, y, size, data[y][x])) {
			if (data[y][x] == -1)
				negative++;
			else if (data[y][x] == 0)
				zero++;
			else
				positive++;
		} else {
			int one_third = size / 3;

			// 상왼
			divide(x, y, one_third);
			// 상중
			divide(x + one_third, y, one_third);
			// 상오
			divide(x + one_third + one_third, y, one_third);
			// 중왼
			divide(x, y + one_third, one_third);
			// 중중
			divide(x + one_third, y + one_third, one_third);
			// 중오
			divide(x + one_third + one_third, y + one_third, one_third);
			// 하왼
			divide(x, y + one_third + one_third, one_third);
			// 하중
			divide(x + one_third, y + one_third + one_third, one_third);
			// 하오
			divide(x + one_third + one_third, y + one_third + one_third, one_third);
		}

	}

	public static boolean check(int x, int y, int size, int value) {
		for (int i = y; i < y + size; ++i) {
			for (int j = x; j < x + size; ++j) {
				if (data[i][j] != value)
					return false;
			}
		}
		return true;
	}
}

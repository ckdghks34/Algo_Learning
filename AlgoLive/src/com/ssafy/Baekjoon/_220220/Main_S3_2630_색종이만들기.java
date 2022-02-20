package com.ssafy.Baekjoon._220220;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_S3_2630_색종이만들기 {
	public static int[][] map;
	public static int white = 0, blue = 0;
	public static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		divideSquare(N, 0, 0);

		sb.append(white).append("\n").append(blue);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

	public static void divideSquare(int size, int x, int y) {
		int color = map[y][x];

		if (checkSquare(color, x, y, size)) {
			if (color == 0)
				white++;
			else
				blue++;
		} else {
			int tmpsize = size / 2;

			// 시작 지점을 기준으로 사이즈를 반틈으로 잘라 확인

			// 제1사분면
			divideSquare(tmpsize, x, y);
			// 제2사분면
			divideSquare(tmpsize, x + tmpsize, y);
			// 제3사분면
			divideSquare(tmpsize, x, y + tmpsize);
			// 제4사분면
			divideSquare(tmpsize, x + tmpsize, y + tmpsize);
		}
	}

	public static boolean checkSquare(int color, int x, int y, int size) {
		for (int i = y; i < y + size; ++i) {
			for (int j = x; j < x + size; ++j) {
				if (map[i][j] != color)
					return false;
			}
		}
		return true;
	}
}

package com.ssafy.Baekjoon._220711;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_S5_15312_이름궁합_DP {

	public static int[] list = { 3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String jongmin = br.readLine();
		String hername = br.readLine();

		int len = jongmin.length() * 2;
		int[][] map = new int[len - 1][len];

		for (int i = 0, j = 0; i < len / 2; ++i) {
			map[0][j++] = list[jongmin.charAt(i) - 'A'];
			map[0][j++] = list[hername.charAt(i) - 'A'];
		}

		for (int i = 1; i < len - 1; ++i)
			for (int j = 0; j < len - i; ++j)
				map[i][j] = (map[i - 1][j] + map[i - 1][j + 1]) % 10;

		sb.append(map[len - 2][0]).append(map[len - 2][1]);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
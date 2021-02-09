package com.ssafy.Baekjoon._210209;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BJ_2563_색종이 {

	static final int size = 101;
	static boolean[][] drawing = new boolean[size][size];
	static int T;
	static int sx, sy;
	static int totalcnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());

			for (int i = sy; i < sy + 10; ++i) {
				for (int j = sx; j < sx + 10; ++j) {
					if (!drawing[i][j]) {
						drawing[i][j] = true;
						totalcnt++;
					}
				}
			}
		}
		
		sb.append(totalcnt);
		bw.write(sb.toString());
		bw.flush();
		
		br.close();
		bw.close();
	}
}

package com.ssafy.exSoftAcademy._210203;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d2_2001_파리퇴치_구미_4_허창환 {

	static int[][] map;

	// 상,하,좌,우
	//static int[] dx = { -1, 1, 0, 0 };
	//static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/ES_input_d2_2001.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int sum = 0;
			int max = Integer.MIN_VALUE;

			map = new int[N][N];

			// 입력
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine(), " ");

				for (int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 순회
			for (int i = 0; i <= (N - M); ++i) {
				for (int j = 0; j <= (N - M); ++j) {
					for (int n = 0; n < M; ++n) {
						for (int m = 0; m < M; ++m) {
							sum += map[i + n][j + m];
						}
					}
					
					max = max < sum ? sum : max;
					sum = 0;
				}
			}

			System.out.println("#" + (tc + 1) + " " + max);
		}
	}
}

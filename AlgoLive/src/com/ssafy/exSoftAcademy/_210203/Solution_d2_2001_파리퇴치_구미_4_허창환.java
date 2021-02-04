package com.ssafy.exSoftAcademy._210203;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d2_2001_파리퇴치_구미_4_허창환 {

	static int[][] map;
	static int N;
	static int M;
	static int sum;
	static int max;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/ES_input_d2_2001.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // TestCase

//		long start = System.currentTimeMillis();

		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken()); // Map 크기
			M = Integer.parseInt(st.nextToken()); // 파리채 크기

			map = new int[N][N];
			sum = 0;
			max = Integer.MIN_VALUE;

			// 입력
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine(), " ");

				for (int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i <= (N - M); ++i) {
				for (int j = 0; j <= (N - M); ++j) {
					sum = 0;
					for (int n = 0; n < M; ++n) {
						for (int m = 0; m < M; ++m) {
							sum += map[i + n][j + m];
						}
					}
					// max = max < sum ? sum: max; // 합이 max보다 크면 max값 바꿈
					/*if (max < sum)
						max = sum;*/
					max = Math.max(max, sum);
				}
			}

//			sumArea(0, 0);
			System.out.println("#" + tc + " " + max);
		}

//		long end = System.currentTimeMillis();
//		System.out.println("실행시간 : " + (end - start)/1000.0);
	}
	
	static void sumArea(int x, int y) {
		sum = 0;
		for (int i = y; i < y + M; ++i) {
			for (int j = x; j < x + M; ++j) {
				sum += map[i][j];
			}
		}

		// max = max < sum ? sum: max; // 합이 max보다 크면 max값 바꿈
		if (max < sum)
			max = sum;

		if (x == N - M && y == N - M) // 종료
			return;

		if (x == N - M) // 행 다 돌았을 때,
			sumArea(0, y + 1); // 다음 행으로
		else {
			sumArea(x + 1, y); // 다음 열로
		}
	}

	
}

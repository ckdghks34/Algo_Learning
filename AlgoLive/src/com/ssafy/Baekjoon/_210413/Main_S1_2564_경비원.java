package com.ssafy.Baekjoon._210413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_2564_경비원 {

	static int N, M, sCount;
	static int result = 0;
	static int security[] = new int[2];
	static int store[][];

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 가로길이
		M = Integer.parseInt(st.nextToken()); // 세로길이

		sCount = Integer.parseInt(br.readLine()); // 상점 갯수
		store = new int[sCount][2]; // 상점 위치 정보

		for (int i = 0; i < sCount; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			store[i][0] = Integer.parseInt(st.nextToken());
			store[i][1] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		security[0] = Integer.parseInt(st.nextToken()); // 경비원 위치정보
		security[1] = Integer.parseInt(st.nextToken());

		Measure();
		System.out.println(result);
	}

	private static void Measure() {
		int half = N + M; // 사각형 크기 반틈

		for (int i = 0; i < sCount; ++i) {
			int tmp = 0;

			if (security[0] == store[i][0]) {
				result += Math.abs(security[1] - store[i][1]);
				continue;
			}

			switch (security[0]) {
			// 북
			case 1:
				switch (store[i][0]) {
				// 남
				case 2:
					tmp = M + security[1] + store[i][1];
					result += tmp < half ? tmp : 2 * half - tmp;
					break;
				// 서
				case 3:
					result += security[1] + store[i][1];
					break;
				// 동
				case 4:
					result += N - security[1] + store[i][1];
				}
				break;
			// 남
			case 2:
				switch (store[i][0]) {
				// 북
				case 1:
					tmp = M + security[1] + store[i][1];
					result += tmp < half ? tmp : 2 * half - tmp;
					break;
				// 서
				case 3:
					result += security[1] + (M - store[i][1]);
					break;
				// 동
				case 4:
					result += (N - security[1]) + (M - store[i][1]);
					break;
				}
				break;
			// 서
			case 3:
				switch (store[i][0]) {
				// 북
				case 1:
					result += security[1] + store[i][1];
					break;
				// 남
				case 2:
					result += (M - security[1]) + store[i][1];
					break;
				// 동
				case 4:
					tmp = N + security[1] + store[i][1];
					result += tmp < half ? tmp : 2 * half - tmp;
					break;
				}
				break;
			// 동
			case 4:
				switch (store[i][0]) {
				// 북
				case 1:
					result += security[1] + N - store[i][1];
					break;
				// 남
				case 2:
					result += N - store[i][1] + M - security[1];
					break;
				// 서
				case 3:
					tmp = N + security[1] + store[i][1];
					result += tmp < half ? tmp : 2 * half - tmp;
					break;
				}
				break;
			}
		}
	}
}

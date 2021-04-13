package com.ssafy.exSoftAcademy._210412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_Test_5644_무선충전2 {

	static int M, A;
	static int[] pathA, pathB, playerA, playerB;
	static int[][] ac;

	// 이동x, 상, 우, 하, 좌
	static int[] dx = { 0, 0, 1, 0, -1 };
	static int[] dy = { 0, -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

		int T = Integer.parseInt(br.readLine());
		int result = 0;
		playerA = new int[2]; // A 플레이어 위치
		playerB = new int[2]; // B 플레이어 위치

		for (int tc = 1; tc <= T; ++tc) {
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			result = 0;

			playerA[0] = 1;
			playerA[1] = 1;
			playerB[0] = 10;
			playerB[1] = 10;

			pathA = new int[M+1];
			pathB = new int[M+1];
			ac = new int[A][4];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= M; ++i) {
				pathA[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= M; ++i) {
				pathB[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < A; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				ac[i][0] = Integer.parseInt(st.nextToken()); // x
				ac[i][1] = Integer.parseInt(st.nextToken()); // y
				ac[i][2] = Integer.parseInt(st.nextToken()); // 거리
				ac[i][3] = Integer.parseInt(st.nextToken()); // 충전량
			}
			result = move();
			sb.append("#").append(tc).append(" ").append(result);
			System.out.println(sb.toString());
		}
	}

	private static int get() {
		int max = 0;

		for (int i = 0; i < A; ++i) {
			for (int j = 0; j < A; ++j) {
				int sum = 0;
				int amountA = check(i, playerA[0], playerA[1]);
				int amountB = check(j, playerB[0], playerB[1]);
				sum = i != j ? amountA + amountB : Math.max(amountA, amountB);
				max = Math.max(max, sum);
			}
		}
		return max;
	}

	private static int move() {
		int total = 0;

		for (int t = 0; t <= M; ++t) {
			playerA[0] += dx[pathA[t]];
			playerA[1] += dy[pathA[t]];
			playerB[0] += dx[pathB[t]];
			playerB[1] += dy[pathB[t]];

			total += get();
		}
		return total;
	}

	private static int check(int a, int x, int y) {
		int loc = Math.abs(ac[a][0] - x) + Math.abs(ac[a][1] - y);

		if (loc <= ac[a][2])
			return ac[a][3];

		return 0;
	}
}
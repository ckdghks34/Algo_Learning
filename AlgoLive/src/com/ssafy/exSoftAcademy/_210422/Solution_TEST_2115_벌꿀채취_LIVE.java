package com.ssafy.exSoftAcademy._210422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

10
4 2 13
6 1 9 7
9 8 5 8
3 4 5 3
8 2 6 7
 */
public class Solution_TEST_2115_벌꿀채취_LIVE {

	static int N, M, C;
	static int[][] map;
	static int maxSum = 0;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken()); // 전체 벌통 크기
			M = Integer.parseInt(st.nextToken()); // 선택할 수 있는 벌통 크기
			C = Integer.parseInt(st.nextToken()); // 꿀 채취할 수 있는 최대 양

			map = new int[N][N];

			// 맵 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			System.out.println("#" + tc + " " + getMaxBenefit());
		}
	}

	private static int getMaxBenefit() {
		return processCombination();
	}

	private static int processCombination() {
		int result = 0, aBenefit = 0, bBenefit = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N - M + 1; ++j) { // 첫열부터 연속된 M개 채취가 가능한 열까지, 일꾼 A의 선택

				// 선택된 M개 벌통에서 얻을 수 있는 최대 이익
				maxSum = 0;
				makeMaxSubset(i, j, 0, 0, 0);
				aBenefit = maxSum;

				maxSum = 0;
				bBenefit = 0; // b일꾼의 최대이익

				// 일꾼 B의 선택
				// 일꾼 A와 같은행에서 선택
				for (int j2 = j + M; j2 < N - M + 1; ++j2) {
					makeMaxSubset(i, j2, 0, 0, 0); // maxSum
				}

				// 일꾼 A의 다음 행 부터 선택
				for (int i2 = i + 1; i2 < N; ++i2) {
					for (int j2 = 0; j2 < N - M + 1; ++j2) {
						makeMaxSubset(i2, j2, 0, 0, 0);
					}
				}
				bBenefit = maxSum;

				if (result < aBenefit + bBenefit)
					result = aBenefit + bBenefit;
			}
		}
		return result;
	}

	private static void makeMaxSubset(int i, int j, int cnt, int sum, int powerSum) {

		if (sum > C)
			return;

		// 마지막 원소까지 다 부분집합에 고려해봤다면
		if (cnt == M) {
			if (maxSum < powerSum)
				maxSum = powerSum;

			return;
		}

		// 선택
		makeMaxSubset(i, j + 1, cnt + 1, sum + map[i][j], powerSum + (map[i][j] * map[i][j]));

		// 비선택
		makeMaxSubset(i, j + 1, cnt + 1, sum, powerSum);
	}
}

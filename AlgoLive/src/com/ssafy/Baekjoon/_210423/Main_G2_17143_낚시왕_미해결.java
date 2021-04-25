package com.ssafy.Baekjoon._210423;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G2_17143_낚시왕_미해결 {

	static int R, C, M;
	static int[][] map;
	static int[][] shark;
	static int kingR = 0, kingC = -1;
	static int sum;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		shark = new int[M][5];

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			shark[i][0] = Integer.parseInt(st.nextToken()) - 1;
			shark[i][1] = Integer.parseInt(st.nextToken()) - 1;
			shark[i][2] = Integer.parseInt(st.nextToken());
			shark[i][3] = Integer.parseInt(st.nextToken());
			shark[i][4] = Integer.parseInt(st.nextToken());

			map[shark[i][0]][shark[i][1]] = shark[i][4];
		}

		// 상어 크기 순으로 정렬
		Arrays.sort(shark, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[4] - o1[4];
			}
		});

		for (int i = 0; i < C; ++i) {
			// 낚시킹 이동
			kingC++;

			// 가장 앞에 있는 상어 잡음
			catchShark(kingC);

			// 상어 크기 순으로 정렬
			Arrays.sort(shark, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o2[4] - o1[4];
				}
			});

			// 상어 이동
			map = sharkMove();
		}
		System.out.println(sum);
	}

	public static void catchShark(int c) {
		for (int row = 0; row < R; ++row) {

			// 상어가 있다면
			if (0 < map[row][c]) {
				// 잡은 상어 무게 추가
				sum += map[row][c];
				// 잡은 상어 0으로 초기화
				for (int i = 0; i < M; ++i) {
					if (shark[i][0] == row && shark[i][1] == c) {
						shark[i][4] = 0;
						break;
					}
				}
				map[row][c] = 0;
				M--;
				return;
			}
		}
	}

	public static int[][] sharkMove() {
		int[][] newmap = new int[R + 1][C + 1];

		for (int i = 0; i < M; ++i) {
			// 없는 상어라면
			if (shark[i][4] == 0)
				continue;
			else {
				if (shark[i][2] > 0) {
					int nx = shark[i][1];
					int ny = shark[i][0];

					// 상어가 좌우로 움직일때
					if (shark[i][3] == 3) {
						int tmpx = Math.abs(shark[i][1] - shark[i][2]);

						// 다른 방향일 때
						if ((tmpx / C) % 2 == 0) {
							nx = tmpx % C;
							shark[i][3] = 4;
						}
						// 같은 방향일 때
						else {
							nx = Math.abs(nx - tmpx % C);

						}
					} else if (shark[i][3] == 4) {
						int tmpx = shark[i][1] + shark[i][2];

						// 같은 방향일 때
						if ((tmpx / C) % 2 == 0) {
							nx = tmpx % C;
						}
						// 방향이 바뀌었을 때
						else {
							nx = C - tmpx % C;
							shark[i][3] = (shark[i][3] == 3) ? 4 : 3; // 방향 변경
						}
					}
					// 상어가 상하 로 움직일때
					else if (shark[i][3] == 2) {
						int tmpy = shark[i][0] + shark[i][2];

						// 같은 방향일 떄
						if ((tmpy / R) % 2 == 0) {
							ny = tmpy % R;

						}
						// 방향이 바뀌었을 때
						else {
							ny = R - tmpy % R;
							shark[i][3] = (shark[i][3] == 1) ? 2 : 1; // 방향 변경
						}
					}

					else if (shark[i][3] == 1) {
						int tmpy = shark[i][0] + shark[i][2];

						// 방향이 바뀌었을 때
						if ((tmpy / R) % 2 == 0) {
							ny = tmpy % R;
							shark[i][3] = (shark[i][3] == 1) ? 2 : 1; // 방향 변경
						}
						// 같은 방향일 떄
						else {
							nx = Math.abs(ny - tmpy % R);
						}
					}

					// 이동할 자리에 다른 상어가 있다면 이동하는 상어는 잡아 먹힘.
					if (newmap[ny][nx] > 0) {
						shark[i][4] = 0;
						M--;
					} else {
						shark[i][0] = ny;
						shark[i][1] = nx;
					}
					newmap[ny][nx] = shark[i][4];
				}
			}
		}
		return newmap;
	}
}
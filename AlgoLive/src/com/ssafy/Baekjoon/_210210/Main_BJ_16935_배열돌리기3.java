package com.ssafy.Baekjoon._210210;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BJ_16935_배열돌리기3 {

	static int N, M, T;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < M; ++j)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");

		while (st.hasMoreTokens()) {
			int P = Integer.parseInt(st.nextToken());

			switch (P) {
			case 1:
				pFirst();
				break;
			case 2:
				pSecond();
				break;
			case 3:
				map = pThird();
				break;
			case 4:
				map = pFourth();
				break;
			case 5:
				map = pFifth();
				break;
			case 6:
				map = pSixth();
				break;
			}
		}
		for (int i = 0; i < map.length; ++i) {
			for (int j = 0; j < map[i].length; ++j)
				sb.append(map[i][j]).append(" ");
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();

		br.close();
		bw.close();
	}

	static void pFirst() {
		int row = map.length;
		int col = map[0].length;
		for (int i = 0; i < col; ++i) {
			for (int j = 0; j < row/2; ++j) {
				int cIndex = (row - 1 - j);
				int tmp = map[j][i];
				map[j][i] = map[cIndex][i];
				map[cIndex][i] = tmp;
			}
		}
	}

	static void pSecond() {
		int row = map.length;
		int col = map[0].length;
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col/ 2; ++j) {
				int cIndex = (col - 1 - j);
				int tmp = map[i][j];
				map[i][j] = map[i][cIndex];
				map[i][cIndex] = tmp;
			}
		}
	}

	static int[][] pThird() {
		int row = map.length;
		int col = map[0].length;
		int[][] tmp = new int[col][row];

		for (int i = 0; i < col; ++i) {
			for (int j = 0; j < row; ++j) {
				tmp[i][j] = map[row - 1 - j][i];
			}
		}
		return tmp;
	}

	static int[][] pFourth() {
		int row = map.length;
		int col = map[0].length;
		int[][] tmp = new int[col][row];

		for (int i = 0; i < col; ++i) {
			for (int j = 0; j < row; ++j) {
				tmp[i][j] = map[j][col - 1 - i];
			}
		}

		return tmp;
	}

	static int[][] pFifth() {
		int row = map.length;
		int col = map[0].length;
		int[][] tmp = new int[row][col];

		for (int i = 0; i < row / 2; ++i) {
			for (int j = col / 2; j < col; ++j) {
				tmp[i][j] = map[i][j - (col / 2)];
			}
		}

		for (int i = row / 2; i < row; ++i) {
			for (int j = col / 2; j < col; ++j) {
				tmp[i][j] = map[i - (row / 2)][j];
			}
		}

		for (int i = row / 2; i < row; ++i) {
			for (int j = 0; j < col / 2; ++j) {
				tmp[i][j] = map[i][j + (col / 2)];
			}
		}

		for (int i = 0; i < row / 2; ++i) {
			for (int j = 0; j < col / 2; ++j) {
				tmp[i][j] = map[i + (row / 2)][j];
			}
		}

		return tmp;
	}

	static int[][] pSixth() {
		int row = map.length;
		int col = map[0].length;
		int[][] tmp = new int[row][col];

		for (int i = 0; i < row / 2; ++i) {
			for (int j = col / 2; j < col; ++j) {
				tmp[i][j] = map[i + (row / 2)][j];
			}
		}

		for (int i = row / 2; i < row; ++i) {
			for (int j = col / 2; j < col; ++j) {
				tmp[i][j] = map[i][j - (col / 2)];
			}
		}

		for (int i = row / 2; i < row; ++i) {
			for (int j = 0; j < col / 2; ++j) {
				tmp[i][j] = map[i - (row / 2)][j];
			}
		}

		for (int i = 0; i < row / 2; ++i) {
			for (int j = 0; j < col / 2; ++j) {
				tmp[i][j] = map[i][j + (col / 2)];
			}
		}

		return tmp;
	}
}

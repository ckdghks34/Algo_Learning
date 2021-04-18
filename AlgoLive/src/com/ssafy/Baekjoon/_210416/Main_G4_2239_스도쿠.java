package com.ssafy.Baekjoon._210416;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_G4_2239_스도쿠 {

	static int N = 9, count = 0;
	static int[][] map;
	static boolean complete = false;
	static List<int[]> blank;

	// 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		blank = new ArrayList<>();
		map = new int[N][N];

		// 맵 입력
		for (int i = 0; i < N; ++i) {
			String s = br.readLine();

			for (int j = 0; j < N; ++j) {
				map[i][j] = s.charAt(j) - '0';

				// 빈칸일 경우
				if (map[i][j] == 0) {
					blank.add(new int[] { j, i }); // List에 추가
					count++; // 빈칸 개수 체크
				}
			}
		}

		sdoku(0, 0);
	}

	// cnt, start는 같음
	public static void sdoku(int start, int cnt) {

		if (complete) // 다 채웠으면 종료
			return;

		if (cnt == count) {
			// map 출력
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

			complete = true;
			return;
		}

		// 현재 빈칸 좌표 값
		int x = blank.get(start)[0];
		int y = blank.get(start)[1];

		// 현재 좌표에 넣을 수 있는 숫자
		// true : 사용 불가 .. false : 사용 가능
		boolean[] number = checkRC(x, y);

		for (int j = 1; j <= N; ++j) {
			int current = map[y][x];

			// j가 들어 갈 수 있는 값이 아니면 다른값
			if (number[j] == true)
				continue;

			// 현재 좌표에 j값 입력
			map[y][x] = j;
			sdoku(start + 1, cnt + 1);
			map[y][x] = current;
		}
	}

	public static boolean[] checkRC(int x, int y) {
		boolean[] number = new boolean[N + 1];

		// 가로 검사(행 고정)
		for (int i = 0; i < N; ++i) {
			if (map[y][i] != 0)
				number[map[y][i]] = true;
		}

		// 세로 검사 (열 고정)
		for (int i = 0; i < N; ++i) {
			if (map[i][x] != 0)
				number[map[i][x]] = true;
		}

		// 3*3 box 검사
		/*
		 
		 1 2 3 4 5 6 7 8 9
		 1 2 3 4 5 6 7 8 9
		 1 2 3 4 5 6 7 8 9
		 1 2 3 4 5 6 7 8 9
		 1 2 3 4 5 6 7 8 9
		 1 2 3 4 5 6 7 8 9
		 1 2 3 4 5 6 7 8 9
		 1 2 3 4 5 6 7 8 9
		 1 2 3 4 5 6 7 8 9
		 
		 */
		int startX = (x / 3) * 3;
		int startY = (y / 3) * 3;

		for (int i = startY; i < startY + 3; ++i) {
			for (int j = startX; j < startX + 3; ++j) {
				if (map[i][j] != 0)
					number[map[i][j]] = true;
			}
		}

		return number;
	}
}

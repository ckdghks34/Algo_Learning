package com.ssafy.exSoftAcademy._210203;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d3_1873_상호의배틀필드_구미_4_허창환 {

	static int x = 0, y = 0;					// 전차 위치
	static int H, W;							// Map 크기
	static final int[] dx = { -1, 1, 0, 0 };	// 상하좌우
	static final int[] dy = { 0, 0, -1, 1 };	// 상하좌우
	static char[][] map;						// 맵 그리기

	private static void Move(int a) {
		int nextX = x + dx[a];					// 전차가 이동할 x값 (y축)
		int nextY = y + dy[a];					// 전차가 이동할 y값 (x축)

		
		// 이동할 좌표가 맵 안에 있고, 이동할 좌표의 값이 '.' 일때  -> 이동
		if (nextX >= 0 && nextX < H && nextY >= 0 && nextY < W && map[nextX][nextY] == '.') {
			map[x][y] = '.';		// 현재 위치 값 변경
			x = nextX;				// 위치 x값 변경
			y = nextY;				// 위치 y값 변경 
		}
		
		switch (a) {
		case 0:
			map[x][y] = '^';
			break;
		case 1:
			map[x][y] = 'v';
			break;
		case 2:
			map[x][y] = '<';
			break;
		case 3:
			map[x][y] = '>';
			break;
		}
	}

	private static void Shoot() {
		int nextX = x;
		int nextY = y;
		int d = 0;

		switch (map[x][y]) {
		case '^':
			d = 0;
			break;
		case 'v':
			d = 1;
			break;
		case '<':
			d = 2;
			break;
		case '>':
			d = 3;
			break;
		}

		for (int i = 1;; ++i) {
			nextX = x + dx[d] * i;
			nextY = y + dy[d] * i;
			
			// 포탄이 맵 안에  있거나 '#' 강철벽을 만났을 때 	->	아무일이 일어나지 않음.
			if (nextX < 0 || nextX >= H || nextY < 0 || nextY >= W || map[nextX][nextY] == '#')
				break;
			
			// 벽돌로 된 벽을 만났을때	-> 벽을 뿌순다. 
			if (map[nextX][nextY] == '*') {
				map[nextX][nextY] = '.';	// 벽돌로 된벽을 평지로 바꿈
				break;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/ES_input_d3_1873.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		int C;
		char[] Command;

		for (int tc = 0; tc < T; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];

			for (int i = 0; i < map.length; ++i) {
				String s = br.readLine();
				for (int j = 0; j < map[i].length; ++j) {
					map[i][j] = s.charAt(j);

					if (s.charAt(j) == '<' || s.charAt(j) == '>' || s.charAt(j) == '^' || s.charAt(j) == 'v') {
						x = i;
						y = j;
					}
				}
			}
		
			C = Integer.parseInt(br.readLine());
			Command = br.readLine().toCharArray();

			for (int i = 0; i < C; ++i) {
				switch (Command[i]) {
				case 'U':
					Move(0);
					break;
				case 'D':
					Move(1);
					break;
				case 'L':
					Move(2);
					break;
				case 'R':
					Move(3);
					break;
				case 'S':
					Shoot();
					break;
				}
			}
			
			System.out.print("#" + (tc + 1) + " ");
			for (char[] a : map)
				System.out.println(a);
		}

	}
}

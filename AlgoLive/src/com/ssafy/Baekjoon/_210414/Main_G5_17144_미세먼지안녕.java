package com.ssafy.Baekjoon._210414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_17144_미세먼지안녕 {

	static int R, C, T;
	static int map[][];
	static List<int[]> aircleaner;
	static Queue<int[]> queue = new LinkedList<>();

	// 우 상 좌 하
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	// 공기 흐름
	// [0][] : 공기청정기 위쪽 (상우하좌)
	// [1][] : 공기 청정기 아래쪽 (하우상좌)
	static int[][] airdx = { { 0, 1, 0, -1 }, { 0, 1, 0, -1 } };
	static int[][] airdy = { { -1, 0, 1, 0 }, { 1, 0, -1, 0 } };

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		aircleaner = new ArrayList<>();

		int result = 0;

		// 값 입력
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] != 0) // 먼지 위치
					queue.offer(new int[] { j, i });

				if (map[i][j] == -1) // 공기청정기 위치
					aircleaner.add(new int[] { j, i });
			}
		}

		//
		for (int t = 0; t < T; ++t)
			diffusion();

		// T초 후 모든 먼지 합
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != -1) // 공기청정기 값 제외
					result += map[i][j];
			}
		}

		System.out.println(result);
	}

	// 먼지 확산
	private static void diffusion() {
		Queue<int[]> tq = new LinkedList<>();

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0];
			int y = current[1];
			int dv = map[y][x] / 5;
			
			int count = 0; 

			if (map[y][x] < 5)
				continue;

			for (int d = 0; d < 4; ++d) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				// 맵 안에 있다면
				if (0 <= nx && nx < C && 0 <= ny && ny < R) {
					// tq에 더해질 값 offer
					if (map[ny][nx] != -1) {
						tq.offer(new int[] { nx, ny, dv });
						count++;
					}
				}
			}
			map[y][x] -= dv * count;
		}
		
		while (!tq.isEmpty()) {
			int[] next = tq.poll();
			map[next[1]][next[0]] += next[2];
		}

		// 공기청정기
		for (int i = 0; i < 2; ++i) {
			int airX = aircleaner.get(i)[0];
			int airY = aircleaner.get(i)[1];
			air(airX, airY, i);
		}
	}

	private static void air(int airX, int airY, int loc) {
		int d = 0;
		int x = airX, y = airY;

		while (d < 4) {
			int nx = x + airdx[loc][d];
			int ny = y + airdy[loc][d];
			
			if (checkR(nx, ny, loc, airY))
			{
				// 다음 위치가 공기청정기 라면 (한바퀴 다 돌았을 때)
				if (map[ny][nx] == -1)
					map[y][x] = 0;
				
				// 현재 위치가 공기청정기가 아니라면 (시작위치가 아닐때)
				else if (map[y][x] != -1)
					map[y][x] = map[ny][nx];

				// 현재 위치가 0이 아니거나 현재위치가 공기청정기가 아니라면
				if (map[y][x] != 0 && map[y][x] != -1)
					queue.offer(new int[] { x, y });
				
				x = nx;
				y = ny;
			} else
				d++;
		}
	}

	private static boolean checkR(int nx, int ny, int i, int airY) {
		return i == 0 ? 0 <= nx && nx < C && 0 <= ny && ny <= airY : 0 <= nx && nx < C && airY <= ny && ny < R;
	}
}
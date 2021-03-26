package com.ssafy.Baekjoon._210326;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_14502_연구소 {

	static int row, col;
	static int[][] map;
	static int[][] copymap;
	static List<int[]> virus;
	static int max = 0;
	// 상좌하우
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		copymap = new int[row][col];
		virus = new ArrayList<int[]>();

		for (int i = 0; i < row; ++i) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < col; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					virus.add(new int[] { i, j });
			}
		}

		com(0,0);
		System.out.println(max);
	}

	// 맵 복사
	public static void copyMap() {
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				copymap[i][j] = map[i][j];
			}
		}
	}

	// 벽 세우기(조합)
	/*
	public static void com(int cnt) {
		if (cnt == 3) {
			copyMap();
			move();
			return;
		}
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					com(cnt + 1);
					map[i][j] = 0;
				}
			}
		}
	}
	 */
	public static void com(int cnt,int start) {
		if (cnt == 3) {
			copyMap();
			move();
			return;
		}
		for (int i = start; i < row * col; ++i) {
			int x = i % col;
			int y = i / col;
				if (map[y][x] == 0) {
					map[y][x] = 1;
					com(cnt + 1,i+1);
					map[y][x] = 0;
				}
		}
	}
	
	public static void move() {
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < virus.size(); ++i) {
			queue.offer(new int[] { virus.get(i)[0], virus.get(i)[1] });
			map[virus.get(i)[0]][virus.get(i)[1]] = 2;
			
			while (!queue.isEmpty()) {
				int[] current = queue.poll();
				

				for (int d = 0; d < 4; ++d) {
					int ny = current[0] + dy[d];
					int nx = current[1] + dx[d];

					if (0 <= nx && nx < col && 0 <= ny && ny < row)
						if (copymap[ny][nx] == 0) {
							copymap[ny][nx] = 2;
							queue.offer(new int[] { ny, nx });
						}
				}
			}
		}
// @formatter:off
/*
 	for (int i = 0; i < virus.size(); ++i) {
			queue.offer(new int[] { virus.get(i)[0], virus.get(i)[1] });
		}
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			visited[current[0]][current[1]] = true;
			copymap[current[0]][current[1]] = 2;
			
			for (int d = 0; d < 4; ++d) {
				int ny = current[0] + dy[d];
				int nx = current[1] + dx[d];
				
				if (0 <= nx && nx < col && 0 <= ny && ny < row)
					if (copymap[ny][nx] == 0 && !visited[ny][nx]) {
						queue.offer(new int[] { ny, nx });
					}
			}
		}

//@formatter:on

 */
		int count = 0;
		// 안전지역 check
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				if (copymap[i][j] == 0)
					count++;
			}
		}
		max = Math.max(max, count);
	}
}

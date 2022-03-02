package com.ssafy.Programmers._220302;

import java.util.PriorityQueue;
import java.util.*;

public class Soultion_게임맵최단거리_BFS {
	// 동서남북
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
				{ 0, 0, 0, 0, 1 } };
//		int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 0 },
//				{ 0, 0, 0, 0, 1 } };
		System.out.println(solution(maps));
	}

	public static int solution(int[][] maps) {
		int answer = -1;

		if (checkCanGo(maps))
			answer = Bfs(maps);

		return answer;
	}

	public static int Bfs(int[][] maps) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		int maxy = maps.length;
		int maxx = maps[0].length;

		boolean check[][] = new boolean[maxy][maxx];

		pq.offer(new int[] { 0, 0, 1 });
		check[0][0] = true;

		while (!pq.isEmpty()) {
			int[] current = pq.poll();
			int curx = current[0];
			int cury = current[1];

			if (curx == maxx - 1 && cury == maxy - 1)
				return current[2];

			for (int i = 0; i < 4; ++i) {
				int nx = curx + dx[i];
				int ny = cury + dy[i];

				if (nx >= 0 && ny >= 0 && nx < maxx && ny < maxy) {
					if (maps[ny][nx] == 1 && !check[ny][nx]) {
						pq.offer(new int[] { nx, ny, current[2] + 1 });
						check[ny][nx] = true;
					}
				}
			}
		}
		return -1;
	}

	public static boolean checkCanGo(int[][] maps) {
		int enemyx = maps[0].length - 1;
		int enemyy = maps.length - 1;

		for (int i = 0; i < 4; ++i) {
			int nx = enemyx + dx[i];
			int ny = enemyy + dy[i];

			if (nx >= 0 && ny >= 0 && nx < maps[0].length && ny < maps.length) {
				if (maps[ny][nx] == 1)
					return true;
			}
		}

		return false;
	}

}

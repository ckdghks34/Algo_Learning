package com.ssafy.Baekjoon._210317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_16236_아기상어 {
	static int answer;
	static int startX, startY;
	static boolean[][] visit;
	static int[][] map;
	static List<int[]> eatFish;
	static int n;
	// 상 좌 우 하
	static int[] dx = { 0, -1, 1, 0 };
	static int[] dy = { -1, 0, 0, 1 };
	static int eatN;

	static boolean checkRange(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < n;
	}

	static boolean bfs() {
		List<int[]> eat = new ArrayList<int[]>();
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { startX, startY, 0 });

		visit[startY][startX] = true;

		int minDist = Integer.MAX_VALUE;

		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int dist = q.poll()[2];

			for (int i = 0; i < 4; ++i) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				int nextD = dist + 1;

				// Map 바깥에 위치하거나
				// 방문했던적이 있거나
				// 상어가 물고기보다 작을 때
				if (!checkRange(nextX, nextY) || visit[nextY][nextX] || map[startY][startX] < map[nextY][nextX]
						|| minDist < nextD)
					continue;

				// 빈 칸이 아니고, 물고기가 상어보다 작을 때
				if (map[nextY][nextX] != 0 && map[nextY][nextX] < map[startY][startX]) {
					// 먹이 list에 추가
					eat.add(new int[] { nextX, nextY });
					minDist = nextD;
				} else {
					q.offer(new int[] { nextX, nextY, nextD });
				}

				visit[nextY][nextX] = true;
			}
		}

		// 먹을 수 있는 물고기가 없다면 false를 반환
		if (eat.size() == 0) {
			return false;
		}
		
		// 먹을 수 있는 물고기가 있다면
		
		// 같은거리에 있을 때 우선으로 먹어야하는 물고기들 찾는 조건
		int eatX = Integer.MAX_VALUE;
		int eatY = Integer.MAX_VALUE;

		for (int i = 0; i < eat.size(); ++i) {
			int nowX = eat.get(i)[0];
			int nowY = eat.get(i)[1];

			// 가장 위에 있는 물고기
			if (nowY < eatY) {
				eatX = nowX;
				eatY = nowY;
			}
			// 가장 위에 있늠 물고기가 여러개일때 가장 왼쪽에 있는 물고기
			else if (nowY == eatY) {
				if (nowX < eatX) {
					eatX = nowX;
					eatY = nowY;
				}
			}
		}
		// 먹은 물고기 수 증가
		++eatN;
		// 먹은 물고기 수가 상어 크기와 같다면
		// 상어 size-up , 먹은 물고기 초기화
		if (eatN == map[startY][startX]) {
			eatN = 0;
			map[startY][startX] += 1;
		}

		map[eatY][eatX] = map[startY][startX];
		map[startY][startX] = 0;
		startY = eatY;
		startX = eatX;
		answer += minDist;
		return true;

	}

	// bfs를 돌기전에 방문했던 지점 초기화
	static void initVisit() {
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				visit[i][j] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException, NumberFormatException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		visit = new boolean[n][n];
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					startY = i;
					startX = j;
					map[i][j] = 2;
				}
			}
		}
		answer = 0; // 이동한 거리 
		eatN = 0; // 먹은 물고기 수

		// 상어가 먹을 물고기가 있다면 true;
		// 상어가 먹을 물고기가 없다면 false;
		while (bfs()) {
			initVisit();
		}

		System.out.println(answer);
	}

}

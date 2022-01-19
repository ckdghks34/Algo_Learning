package com.ssafy.Baekjoon._220119;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_6087_레이저통신 {
	static int H, W;
	static int[][] map;
	static int[][] visited;
	static final int INF = Integer.MAX_VALUE / 2;
	static ArrayList<int[]> list = new ArrayList<>();
	// 상하좌우
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		visited = new int[H][W];

		int min = INF;

		for (int i = 0; i < H; ++i) {
			String str = br.readLine();
			Arrays.fill(visited[i], INF);
			for (int j = 0; j < W; ++j) {
				char tmp = str.charAt(j);

				switch (tmp) {
				case 'C':
					map[i][j] = 1;
					list.add(new int[] { j, i });
					break;
				case '*':
					map[i][j] = -1;
					break;
				}
			}
		}
		int[] start = list.get(0);
		min = dijkstra(start[0], start[1]);

		sb.append(min);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static int dijkstra(int x, int y) {
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		int[] end = list.get(1);
		int cnt = INF;

		queue.offer(new int[] { x, y, 0, -1 });
		visited[y][x] = 0;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int curx = current[0]; // 현재 x좌표
			int cury = current[1]; // 현재 y좌표
			int curcnt = current[2]; // 현재 거울 갯수
			int curDirection = current[3]; // 현재 방향

			// 도착했을 때
			if (curx == end[0] && cury == end[1]) {
				// 우선순위 큐로 거울갯수가 최소 인 경우 먼저 탐색하기 때문에
				// 가장 먼저 도착했을 때가 최소 갯수
				cnt = curcnt;
				break;
			}

			for (int i = 0; i < 4; ++i) {
				int nx = curx + dx[i];
				int ny = cury + dy[i];

				// 맵 안에 있으면
				if (nx >= 0 && ny >= 0 && nx < W && ny < H) {
					// 벽이 아니면
					if (map[ny][nx] != -1) {
						// 같은 방향이거나, 처음 시작일 때
						if (i == curDirection || curDirection == -1) {
							// 현재 거울의 갯수가 기존에 방문했을 때 거울 갯수 보다 적으면
							if (visited[ny][nx] >= curcnt) {
								// 거울 갯수 교체
								visited[ny][nx] = curcnt;
								// 다시 탐색
								queue.offer(new int[] { nx, ny, curcnt, i });
							}
						}
						// 다른 방향일 때
						else {
							// 방향이 바뀌기 때문에 거울 갯수 1 추가
							// 현재 거울의 갯수가 기존에 방문했을 때 거울 갯수 보다 적으면
							if (visited[ny][nx] >= curcnt + 1) {
								// 거울 개수 교체
								visited[ny][nx] = curcnt + 1;
								// 다시 탐색
								queue.offer(new int[] { nx, ny, curcnt + 1, i });
							}
						}
					}
				}
			}
		}

		return cnt;
	}
}

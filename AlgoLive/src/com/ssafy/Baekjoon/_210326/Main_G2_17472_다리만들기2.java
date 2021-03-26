package com.ssafy.Baekjoon._210326;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G2_17472_다리만들기2 {

	static int N, M;
	static int[][] map;
	static int[][] copyedMap;
	// 좌우하상
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static int[][] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		copyedMap = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 구역 나누기
		// BFS를 이용하여 인덱스에 인접한 값이 1이면 같은 섬의 땅이다
		int island = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					findIsland(j, i, island++);
				}
			}
		}
		island--;

		graph = new int[island][island];
		for (int i = 0; i < island; ++i) {
			for (int j = 0; j < island; ++j)
				graph[i][j] = i == j ? 0 : 100;
		}

		// 각 구역에서 연결된 가장 짧은 거리 찾기
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (map[i][j] != 0) {
					connect(map[i][j], j, i);
				}
			}
		}

		// MST 사용해서 총 길이 가장 짧은거 찾기
		int[] minEdge = new int[island];
		for (int i = 0; i < island; ++i) {
			minEdge[i] = Integer.MAX_VALUE;
		}
		boolean[] isvisited = new boolean[island];

		int result = 0;
		minEdge[0] = 0; // 0을 시작정점으로 처리하기 위해 0 세팅

		for (int i = 0; i < island; ++i) {
			int min = Integer.MAX_VALUE;
			int minVertex = 0;
			// 신장트리에 연결되지 않은 정점 중 minEdge 비용이 최소인 정점

			for (int j = 0; j < island; ++j) {
				if (!isvisited[j] && min > minEdge[j]) {
					min = minEdge[j];
					minVertex = j;
				}
			}

			result += min; // 해당 정점의 간선비용 누적
			isvisited[minVertex] = true;

			for (int j = 0; j < island; ++j) {
				if (!isvisited[j] && graph[minVertex][j] != 0 && minEdge[j] > graph[minVertex][j]) {
					minEdge[j] = graph[minVertex][j];
				}
			}
		}

		System.out.println(result > 60 ? -1 : result);
	}

	public static void findIsland(int x, int y, int island) {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] isChecked = new boolean[N][M];

		queue.offer(new int[] { x, y });

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			isChecked[current[1]][current[0]] = true;
			visited[current[1]][current[0]] = true;
			map[current[1]][current[0]] = island;

			for (int d = 0; d < 4; ++d) {

				int nx = current[0] + dx[d];
				int ny = current[1] + dy[d];

				// 좌표가 맵 안에 있고 방문하지 않았다면
				if (0 <= nx && nx < M && 0 <= ny && ny < N) {
					if (map[ny][nx] == 1 && !visited[ny][nx])
						queue.offer(new int[] { nx, ny });
				}
			}
		}
	}

	public static void connect(int start, int x, int y) {
		// 현재 x좌표,y좌표,방향,count
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] isChecked = new boolean[N][M];

		for (int d = 0; d < 4; ++d) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (0 <= nx && nx < M && 0 <= ny && ny < N)
				if (map[ny][nx] == 0)
					queue.offer(new int[] { x, y, d, 0 });
		}

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			isChecked[current[1]][current[0]] = true;

			int nx = current[0] + dx[current[2]];
			int ny = current[1] + dy[current[2]];

			if (0 <= nx && nx < M && 0 <= ny && ny < N) {
				if (map[ny][nx] == 0 && !isChecked[ny][nx])
					queue.offer(new int[] { nx, ny, current[2], current[3] + 1 });
				else if (map[ny][nx] != 0 && current[3] > 1)
					if (graph[start - 1][map[ny][nx] - 1] > current[3])
						graph[start - 1][map[ny][nx] - 1] = current[3];
			}
		}

	}
}

package com.ssafy.Baekjoon._211231;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G3_1238_파티 {
	static int N, M, X; // 학생 수, 도로 수, 파티 장소
	static int[][] map;
	static int[][] distance;
	static final int INF = Integer.MAX_VALUE / 2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		distance = new int[N + 1][N + 1];

		int max = Integer.MIN_VALUE;
		// INF로 맵 초기화
		for (int i = 1; i < N + 1; ++i) {
			Arrays.fill(map[i], INF);
			map[i][i] = 0; // A 마을에서 A마을로 이동하는데 걸리는 시간 0
		}
		// 맵 입력
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			map[from][to] = weight;
		}

		for (int i = 1; i < N + 1; ++i)
			dijkstra(i);

		for (int i = 1; i < N + 1; ++i) {
			int time = distance[i][X] + distance[X][i];
			max = max > time ? max : time;
		}
		sb.append(max);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dijkstra(int start) {
		boolean[] visited = new boolean[N + 1];
		for (int i = 1; i < N + 1; ++i)
			distance[start][i] = map[start][i];

		visited[start] = true;

		for (int i = 0; i < N; ++i) {
			int min = INF, current = start;

			// 가장 가까운 정점 찾기.
			for (int j = 1; j < N + 1; ++j) {
				if (!visited[j] && distance[start][j] < min) {
					min = distance[start][j];
					current = j;
				}
			}

			visited[current] = true;

			for (int j = 0; j < N + 1; ++j) {
				if (map[current][j] != INF && map[current][j] + distance[start][current] < distance[start][j]) {
					distance[start][j] = map[current][j] + distance[start][current];
				}
			}

		}
	}
}

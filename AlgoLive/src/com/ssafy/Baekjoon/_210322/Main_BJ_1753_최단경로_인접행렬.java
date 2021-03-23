package com.ssafy.Baekjoon._210322;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1753_최단경로_인접행렬 {

	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken()) - 1;

		map = new int[V][V];

		for (int i = 0; i < E; ++i) {
			st = new StringTokenizer(br.readLine(), " ");

			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());

			map[from][to] = weight;
		}

		int[] distance = new int[V];
		boolean[] visited = new boolean[V];

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;

		for (int i = 0; i < V; ++i) {
			int min = Integer.MAX_VALUE;
			int current = 0;

			for (int j = 0; j < V; ++j) {
				if (!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}

			visited[current] = true;
			if (current == V - 1)
				break;

			for (int j = 0; j < V; ++j) {
				if (!visited[j] && map[current][j] != 0 && distance[j] > min + map[current][j]) {
					distance[j] = min + map[current][j];
				}
			}
		}

		for (int i = 0; i < V; ++i) {
			if (distance[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else {
				System.out.println(distance[i]);
			}
		}
	}

}

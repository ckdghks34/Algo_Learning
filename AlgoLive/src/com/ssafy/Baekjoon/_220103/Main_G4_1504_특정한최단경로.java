package com.ssafy.Baekjoon._220103;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_1504_특정한최단경로 {

	public static int N, E;
	public static int vertex1, vertex2;
	public static final int INF = (200000 * 1000) + 1;
	public static int[][] distance;
	public static ArrayList<ArrayList<int[]>> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		distance = new int[N + 1][N + 1];
		int min = INF;

		for (int i = 0; i < N + 1; ++i) {
			list.add(new ArrayList<>());
			Arrays.fill(distance[i], INF);
			distance[i][i] = 0;
		}

		for (int i = 0; i < E; ++i) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list.get(from).add(new int[] { to, weight });
			list.get(to).add(new int[] { from, weight });
		}

		st = new StringTokenizer(br.readLine());
		vertex1 = Integer.parseInt(st.nextToken());
		vertex2 = Integer.parseInt(st.nextToken());

		dijkstra(1);

		dijkstra(vertex1);
		dijkstra(vertex2);

		int first = distance[1][vertex1] + distance[vertex1][vertex2] + distance[vertex2][N];
		int second = distance[1][vertex2] + distance[vertex2][vertex1] + distance[vertex1][N];

		// 1 → vertex1 → vertex2 → N;
		if (first < INF)
			min = first < min ? first : min;
		// 1 → vertex2 → vertex1 → N;
		if (second < INF)
			min = second < min ? second : min;

		if (min == INF)
			min = -1;
		bw.write(Integer.toString(min));
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dijkstra(int start) {
		boolean[] visited = new boolean[N + 1];

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		pq.offer(new int[] { start, 0 });

		while (!pq.isEmpty()) {
			int[] current = pq.poll();
			int vertex = current[0];

			if (!visited[vertex]) {
				visited[vertex] = true;

				for (int i = 0; i < list.get(vertex).size(); ++i) {
					int node = list.get(vertex).get(i)[0];
					int dis = list.get(vertex).get(i)[1];
					if (!visited[node] && distance[start][node] > distance[start][vertex] + dis) {
						distance[start][node] = distance[start][vertex] + dis;
						pq.offer(new int[] { node, distance[start][node] });
					}
				}
			}

		}
	}
}

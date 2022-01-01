package com.ssafy.Baekjoon._220101;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_S2_18352_특정거리의도시찾기 {
	public static int N, M, K, X;
	public static int[] distance;
	public static boolean[] visited;
	public static final int INF = Integer.MAX_VALUE / 2;
	public static ArrayList<ArrayList<int[]>> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 도시 개수
		M = Integer.parseInt(st.nextToken()); // 도로
		K = Integer.parseInt(st.nextToken()); // 거리 정보
		X = Integer.parseInt(st.nextToken()); // 출발 도시 번호

		distance = new int[N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < N + 1; ++i)
			list.add(new ArrayList<>());

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			list.get(from).add(new int[] { to, 1 });
		}
		Arrays.fill(distance, INF);
		distance[X] = 0;
		dijkstra(X);

		for (int i = 1; i < N + 1; ++i) {
			if (distance[i] == K)
				sb.append(i).append("\n");
		}

		if (sb.length() == 0)
			sb.append(-1);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

	public static void dijkstra(int start) {
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		queue.offer(new int[] { start, 0 });

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			if (distance[current[0]] < current[1])
				continue;

			for (int i = 0; i < list.get(current[0]).size(); ++i) {
				int cost = distance[current[0]] + list.get(current[0]).get(i)[1];

				if (cost < distance[list.get(current[0]).get(i)[0]]) {
					distance[list.get(current[0]).get(i)[0]] = cost;
					queue.offer(new int[] { list.get(current[0]).get(i)[0], cost });
				}
			}
		}
	}
}

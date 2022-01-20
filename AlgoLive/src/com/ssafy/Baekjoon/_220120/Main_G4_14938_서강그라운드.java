package com.ssafy.Baekjoon._220120;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_14938_서강그라운드 {
	static int N, M, R;
	static int[] map;
	static final int INF = Integer.MAX_VALUE / 2;
	static ArrayList<ArrayList<int[]>> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i) {
			map[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i <= N; ++i)
			list.add(new ArrayList<>());

		for (int i = 0; i < R; ++i) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list.get(from).add(new int[] { to, weight });
			list.get(to).add(new int[] { from, weight });
		}
		int min = 0;
		for (int i = 1; i <= N; ++i) {
			min = Math.max(min, dijkstra(i));
		}

		bw.write(Integer.toString(min));
		bw.flush();
		bw.close();
		br.close();
	}

	static int dijkstra(int start) {
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		queue.offer(new int[] { start, 0 });
		int[] distance = new int[N + 1];
		Arrays.fill(distance, INF);
		distance[start] = 0;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			for (int i = 0; i < list.get(current[0]).size(); ++i) {
				int cost = distance[current[0]] + list.get(current[0]).get(i)[1];

				if (distance[list.get(current[0]).get(i)[0]] > cost) {
					distance[list.get(current[0]).get(i)[0]] = cost;
					queue.offer(new int[] { list.get(current[0]).get(i)[0], cost });
				}
			}
		}

		int sum = 0;
		for (int i = 1; i <= N; ++i) {
			if (M >= distance[i])
				sum += map[i];
		}
		return sum;
	}
}

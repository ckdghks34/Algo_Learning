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

public class Main_G4_10282_해킹 {
	static int T;
	static ArrayList<ArrayList<int[]>> list;
	static int[] distance;
	static final int INF = Integer.MAX_VALUE / 2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		int n, d, c;
		for (int tc = 1; tc <= T; ++tc) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			list = new ArrayList<>();
			distance = new int[n + 1];
			for (int i = 0; i <= n; ++i) {
				list.add(new ArrayList<>());
			}

			for (int i = 0; i < d; ++i) {
				st = new StringTokenizer(br.readLine());

				int to = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());

				list.get(from).add(new int[] { to, weight });
			}

			dijkstra(c);
			int time = 0;
			int count = 0;
			for (int i = 1; i <= n; ++i) {
				if (distance[i] != INF) {
					count++;
					time = Math.max(distance[i], time);
				}
			}
			sb.append(count).append(" ").append(time).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static void dijkstra(int start) {
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		Arrays.fill(distance, INF);
		distance[start] = 0;

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
